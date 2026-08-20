package com.Simulation;

import com.Simulation.mapjungle.MapJungle;

public class Main {
    public static void main(String[] args) {
        MapJungle mapJungle = new MapJungle();
        MapConsoleRender render = new MapConsoleRender();
        render.renderer(mapJungle);
    }
}
