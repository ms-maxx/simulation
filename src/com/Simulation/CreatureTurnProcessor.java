package com.Simulation;

import com.Simulation.entitis.Coordinates;
import com.Simulation.entitis.Entity;
import com.Simulation.entitis.creatures.Creature;
import com.Simulation.mapjungle.MapJungle;

import java.util.*;

public class CreatureTurnProcessor {

    private static List<Coordinates> creatureStartPositions = new ArrayList<>();
    private static Set<Entity> creaturesThatAlreadyMoved = new HashSet<>();

    public static void moveAllCreatures(MapJungle mapJungle){
        creatureStartPositions.clear();
        creaturesThatAlreadyMoved.clear();

        saveCreaturesPositions(mapJungle);

        for(Coordinates coordinates : creatureStartPositions){
            Entity currentEntity = mapJungle.getEntity(coordinates);

            if(!(currentEntity instanceof Creature currentCreature)){
                continue;
            }

            if(creaturesThatAlreadyMoved.contains(currentCreature)){
                continue;
            }

            currentCreature.makeMove(mapJungle, coordinates);
            creaturesThatAlreadyMoved.add(currentCreature);
        }
    }

    private static void saveCreaturesPositions(MapJungle mapJungle){
        for(Map.Entry<Coordinates, Entity> entry : mapJungle.getEntries()){
            Coordinates coordinates = entry.getKey();
            Entity entity = entry.getValue();

            if(entity instanceof Creature){
                creatureStartPositions.add(coordinates);
            }
        }
    }

}