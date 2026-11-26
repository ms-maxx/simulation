package com.Simulation.entitis.creatures;

import com.Simulation.BfsPathFinder;
import com.Simulation.entitis.Coordinates;
import com.Simulation.entitis.Entity;
import com.Simulation.entitis.environment.Supply;
import com.Simulation.mapjungle.MapJungle;

import java.util.List;

public class Survivor extends Creature {
    public Survivor(Coordinates coordinates) {
        super(coordinates);
    }

    public static final int SPEED = 1;
    public static int HEALTH = 100;

    private int boostedSpeed = 0;

    public void makeMove(MapJungle mapJungle, Coordinates coordinates){
        int actionsPerformed = 0;
        BfsPathFinder bfsPathFinder = new BfsPathFinder();

        while(actionsPerformed < (boostedSpeed > 0 ? SPEED + 1: SPEED)){
            List<Coordinates> shortestPathToTarget
                    = bfsPathFinder.findPathToTarget(mapJungle, coordinates);

            if (shortestPathToTarget.isEmpty()){
                System.out.println("nothing surv");
                break;
            }

            Coordinates nextCoordinates = bfsPathFinder.getNextCoordinates(shortestPathToTarget);

            if(CanEat(mapJungle.getEntity(nextCoordinates))){
                boostedSpeed++;
                mapJungle.moveEntity(coordinates, nextCoordinates, this);

                return;
            } else {
                mapJungle.moveEntity(coordinates, nextCoordinates, this);
                coordinates = nextCoordinates;
                actionsPerformed++;
            }
        }

        if(boostedSpeed > 0){
            boostedSpeed = 0;
        }

    }

    public boolean isDead(){
        return HEALTH <= 0;
    }

    public void receiveDamage(int attackPower){
        HEALTH -= attackPower;
    }

    @Override
    public boolean CanEat(Entity entity){
        return entity instanceof Supply;
    }
}