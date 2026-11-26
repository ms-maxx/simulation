package com.Simulation.entitis.creatures;

import com.Simulation.entitis.Coordinates;
import com.Simulation.entitis.Entity;
import com.Simulation.mapjungle.MapJungle;

public abstract class Creature extends Entity {
    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    public abstract void makeMove(MapJungle mapJungle, Coordinates coordinates);
    public abstract boolean CanEat(Entity entity);
}