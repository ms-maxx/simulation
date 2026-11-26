package com.Simulation.mapjungle;

import com.Simulation.entitis.Coordinates;
import com.Simulation.entitis.Entity;
import com.Simulation.entitis.creatures.Creature;
import com.Simulation.entitis.creatures.Survivor;
import com.Simulation.entitis.creatures.Zombie;
import com.Simulation.entitis.environment.Palm;
import com.Simulation.entitis.environment.Supply;
import com.Simulation.entitis.environment.Fire;

import java.util.*;

public class MapJungle {

    private static final int WEIGHT_SIZE = 14;
    private static final int HEIGHT_SIZE = 14;

    private HashMap<Coordinates, Entity> jungleMap = new HashMap<>();

    public MapJungle(){
        setupRandomEntityPositions();
    }

    public void setEntity(Coordinates coordinates, Entity entity){
        entity.coordinates = coordinates;
        jungleMap.put(coordinates, entity);
    }

    public void moveEntity(Coordinates currentCoordinates, Coordinates coordinatesToMove, Entity entity){
        removeEntity(currentCoordinates);
        setEntity(coordinatesToMove, entity);
    }

    public Entity getEntity(Coordinates coordinates){
        return jungleMap.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates){
        jungleMap.remove(coordinates);
    }

    public boolean isSquareEmpty(Coordinates coordinates){
        return !jungleMap.containsKey(coordinates);
    }

    public Set<Map.Entry<Coordinates,Entity>> getEntries(){
        return Collections.unmodifiableMap(jungleMap).entrySet();
    }

    public boolean isMapHasPray(){
        for(Map.Entry<Coordinates, Entity> entry : jungleMap.entrySet()){
            Entity entity = entry.getValue();

            if(entity instanceof Survivor){
                return true;
            }
        }

        return false;
    }

    public void setupRandomEntityPositions(){

        //Zombies
        for (int i = 0; i < 4; i++) {
            Coordinates randomCoordinates = Coordinates.getRandomCoordinates(this);
            setEntity(randomCoordinates, new Zombie(randomCoordinates));
        }

        //Survivors
        for (int i = 0; i < 10; i++) {
            Coordinates randomCoordinates = Coordinates.getRandomCoordinates(this);
            setEntity(randomCoordinates, new Survivor(randomCoordinates));
        }

        //Fire
        for (int i = 0; i < 7; i++) {
            Coordinates randomCoordinates = Coordinates.getRandomCoordinates(this);
            setEntity(randomCoordinates, new Fire(randomCoordinates));
        }

        //Palm
        for (int i = 0; i < 12; i++) {
            Coordinates randomCoordinates = Coordinates.getRandomCoordinates(this);
            setEntity(randomCoordinates, new Palm(randomCoordinates));
        }

        //Supplies
        for (int i = 0; i < 8; i++) {
            Coordinates randomCoordinates = Coordinates.getRandomCoordinates(this);
            setEntity(randomCoordinates, new Supply(randomCoordinates));
        }

    }
}