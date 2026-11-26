package com.Simulation;

import com.Simulation.entitis.Coordinates;
import com.Simulation.mapjungle.MapJungle;

import java.util.List;

public class BfsPathFinder {

    private int target;

    public List<Coordinates> findPathToTarget(MapJungle mapJungle, Coordinates coordinates){
        return List.of();
    }

    public Coordinates getNextCoordinates(List<Coordinates> path){
        return path.remove(0);
    }
}