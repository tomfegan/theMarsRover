package org.northcoders.parsingclasses;

import org.northcoders.marsroverproject.Position;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    Scanner userInput = new Scanner(System.in);
    InputParser stringParser = new InputParser();
    Position position = new Position();

    public int getNumberOfRowsFromUser() {
        System.out.print("Enter number of rows: ");
        String rowsInString = userInput.nextLine();
        while (!rowsInString.matches("\\d")) {
            System.out.print("Please only enter a number to indicate how many rows you want the grid to have: ");
            rowsInString = userInput.nextLine();
        }
        return stringParser.parseInput(rowsInString);
    }
    public int getNumberOfColumnsFromUser() throws InputMismatchException {
        System.out.print("Enter number of columns: ");
        String columnsInString = userInput.nextLine();
        while (!columnsInString.matches("\\d")) {
            System.out.print("Please only enter a number to indicate how many columns you want the grid to have: ");
            columnsInString = userInput.nextLine();
        }
        return stringParser.parseInput(columnsInString);
    }
    public List<Integer> getRoverStartingPositionFromUser() {
        List<Integer> startingCoordinates = new ArrayList<>();
        System.out.print("Where would you like to place the Rover: please provide the x-coordinate: ");
        String startingXCoordinate = userInput.nextLine();
        while (!startingXCoordinate.matches("\\d")) {
            System.out.print("Please only enter a number to indicate the vertical plane you want to place the rover at the start: ");
            startingXCoordinate = userInput.nextLine();
        }

        startingCoordinates.add(stringParser.parseInput(startingXCoordinate));

        System.out.print("Where would you like to place the Rover: please provide the y-coordinate: ");
        String startingYCoordinate = userInput.nextLine();
        while (!startingYCoordinate.matches("\\d")) {
            System.out.print("Please only enter a number to indicate the horizontal plane you want to place the rover at the start: ");
            startingYCoordinate = userInput.nextLine();
        }
        startingCoordinates.add(stringParser.parseInput(startingYCoordinate));

        // How do I restrict input to the board size?
//        if (position.isStartingPositionAvailable(startingCoordinates)) {
//
//        }
//
        return startingCoordinates;
    }

    public String getDirectionRoverIsFacingFromUser() { // should I add a Scnner parameter?
        System.out.print("Do you want Rover to be facing North(N), South (S), East(E) or West(W)? ");
//        Scanner userInput = new Scanner(System.in);
        String directionFacing = userInput.next();
//        userInput.close();

        while (!directionFacing.equals("E") && !directionFacing.equals("W") &&
                !directionFacing.equals("N") && !directionFacing.equals("S")) {
            System.out.print("Please input N, S, E or W (case-sensitive) to indicate which direction Rover will be facing: ");
            directionFacing = userInput.next();
        }
        return directionFacing;
    }

    public char[] getMovementInstructionsFromUser() {
        System.out.print("Please tell me how you want Rover to move (L turns Rover 90 degrees left/R turns Rover 90 degrees right/M moves Rover forward): ");
        String movementInstructions = userInput.next();
        while (!movementInstructions.matches("[LRM]+")) {
            System.out.print("Instructions for how you want Rover to move should only include L (turns Rover 90 degrees left), R (turns Rover 90 degrees right) and/or M (moves Rover forward): ");
            movementInstructions = userInput.next();
        }
        return movementInstructions.toCharArray();
    }
}