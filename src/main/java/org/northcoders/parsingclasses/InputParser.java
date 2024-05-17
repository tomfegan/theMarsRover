package org.northcoders.parsingclasses;

import org.northcoders.marsroverproject.Position;

import java.util.Scanner;

public class InputParser {
    /* This could become separate classes for each parse operation - this package is a
    critical part of my Input Layer */
//    musings: is this an adaptor/wrapper design pattern?
    private Scanner startingPositionInput;
    private Scanner instructionsInput;
    public int parseInput(String userInputAsString) {
        return Integer.parseInt(userInputAsString);
    }
    public Position parseInstructionInputFromUser(Position currentPosition) {
        // Should this method take the third user input as an argument and output a new Position object with the position after the move?
        Position nextPosition = new Position();
        UserInput movementInstructions = new UserInput();
        char[] userInstructions = movementInstructions.getMovementInstructionsFromUser();

        // Need to use enums, CompassDirection & Instructions here
        for (int i = 0; i < userInstructions.length; i++) {
            if (userInstructions[i] == 'L') {
                // change the direction the input rover is facing

            } else if (userInstructions[i] == 'R') {
                // change the direction the input rover is facing
            } else if (userInstructions[i] == 'M') {
                // change the x or y coordinate of the input rover based on the direction it is facing
            }
        }

        return nextPosition;
    }


}
