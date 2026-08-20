package com.Simulation.entitis;

import com.Simulation.mapjungle.MapJungle;

import java.util.Objects;
import java.util.Random;

public class Coordinates {

    private final int width;
    private final int height;

    private static final Random random = new Random();

    public Coordinates(int width, int height){
        this.width = width;
        this.height = height;
    }

    public static Coordinates getRandomCoordinates(MapJungle mapJungle){
        while(true){
            int width = random.nextInt(14) + 1;
            int height = random.nextInt(14) + 1;

            Coordinates newCoordinates = new Coordinates(width,height);

            if(mapJungle.isSquareEmpty(newCoordinates)){
                return newCoordinates;
            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return width == that.width && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "width= " + width +
                " height = " + height;
    }
}