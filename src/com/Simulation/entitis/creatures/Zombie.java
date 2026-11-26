package com.Simulation.entitis.creatures;

import com.Simulation.BfsPathFinder;
import com.Simulation.entitis.Coordinates;
import com.Simulation.entitis.Entity;
import com.Simulation.mapjungle.MapJungle;

import java.util.List;

public class Zombie extends Creature {
    public Zombie(Coordinates coordinates) {
        super(coordinates);
    }

    public static final int SPEED = 2;
    public static final int ATTACK = 50;

    public void makeMove(MapJungle mapJungle, Coordinates coordinates){
        int actionsPerformed = 0;
        BfsPathFinder bfsPathFinder = new BfsPathFinder();

        while(actionsPerformed < SPEED){
            List<Coordinates> shortestPathToTarget
                    = bfsPathFinder.findPathToTarget(mapJungle, coordinates);

            if (shortestPathToTarget.isEmpty()){
                System.out.println("nothing zomb");
                break;
            }

            Coordinates nextCoordinates = bfsPathFinder.getNextCoordinates(shortestPathToTarget);
            Entity targetEntity = mapJungle.getEntity(nextCoordinates);

            if(CanEat(targetEntity)){
                attackSurvivor(targetEntity);
                actionsPerformed++;

                if(isSurvivorAlive(targetEntity)){
                    mapJungle.moveEntity(coordinates, nextCoordinates, this);
                }
            } else {
                mapJungle.moveEntity(coordinates, nextCoordinates, this);
                coordinates = nextCoordinates;
                actionsPerformed++;
            }
        }
    }

    @Override
    public boolean CanEat(Entity entity){
        return entity instanceof Survivor;
    }

    private void attackSurvivor(Entity entity){
        if(entity instanceof Survivor survivor){
            survivor.receiveDamage(ATTACK);
        }
    }

    private boolean isSurvivorAlive(Entity entity){
        if(entity instanceof Survivor survivor){
            return survivor.isDead();
        }
        return false;
    }

}