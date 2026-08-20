package com.Simulation;

import com.Simulation.entitis.Coordinates;
import com.Simulation.entitis.Entity;
import com.Simulation.mapjungle.MapJungle;

public class MapConsoleRender {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_DARK_GREEN_BG = "\u001B[48;5;22m";

    public static final String ANSI_RED             = "\u001B[31m";
    public static final String ANSI_BLUE            = "\u001B[34m";
    public static final String ANSI_YELLOW          = "\u001B[33m";
    public static final String ANSI_WHITE           = "\u001B[97m";
    public static final String ANSI_DARK_GREEN      = "\u001B[32m";

    public void renderer(MapJungle mapJungle){
        for (int height = 1; height <= 14; height++) {
            StringBuilder line = new StringBuilder();
            for (int width = 1; width <= 14; width++){
                Coordinates coordinates = new Coordinates(width, height);

                if(mapJungle.isSquareEmpty(coordinates)){
                    line.append(colorizeEmptySquare());
                } else {
                    line.append(colorizeSquareWithEntity(mapJungle.getEntity(coordinates)));
                }
            }
            line.append(ANSI_RESET);
            System.out.println(line);
        }

    }

    private String colorizeEmptySquare(){
        return ANSI_DARK_GREEN_BG + "   ";
    }

    private String colorizeSquareWithEntity(Entity entity) {
        String icon;
        String color;

        switch (entity.getClass().getSimpleName()) {
            case "Zombie" -> {
                icon = " \uD83E\uDDDF\u200D♂\uFE0F ";
                color = ANSI_RED;
            }
            case "Survivor" -> {
                icon = " \uD83D\uDC68 ";
                color = ANSI_BLUE;
            }
            case "Fire" -> {
                icon = " 🔥 ";
                color = ANSI_YELLOW;
            }
            case "Palm" -> {
                icon = " 🌴 ";
                color = ANSI_DARK_GREEN;
            }
            case "Supply" -> {
                icon = " ✚ ";
                color = ANSI_RED;
            }
            default -> {
                icon = " ? ";
                color = ANSI_WHITE;
            }
        }

        return ANSI_DARK_GREEN_BG + color + icon;
    }
}