package com.Simulation;

import com.Simulation.mapjungle.MapJungle;

public class Main {
    public static void main(String[] args) {
        MapJungle mapJungle = new MapJungle();
        Simulation simulation = new Simulation(mapJungle);
        simulation.SimulationLoop();
    }
}
