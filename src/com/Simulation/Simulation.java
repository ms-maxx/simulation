package com.Simulation;

import com.Simulation.mapjungle.MapJungle;

public class Simulation {

    private final MapJungle mapJungle;
    private static int turnCount = 1;

    MapConsoleRender render = new MapConsoleRender();

    public Simulation(MapJungle mapJungle){
        this.mapJungle = mapJungle;
    }

    public void SimulationLoop(){

        while(mapJungle.isMapHasPray()){

            System.out.println("Move: " + turnCount);
            render.renderer(mapJungle);

            processTurn(mapJungle);
            turnCount++;

            if(turnCount > 10){
                break;
            }
        }

    }

    private void processTurn(MapJungle mapJungle){
        CreatureTurnProcessor.moveAllCreatures(mapJungle);
    }

}