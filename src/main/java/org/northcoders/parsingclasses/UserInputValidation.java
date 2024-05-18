package org.northcoders.parsingclasses;

import org.northcoders.marsroverproject.PlateauSize;
import org.northcoders.marsroverproject.Position;

import java.util.*;

public class UserInputValidation {
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

    public int getRoverStartingCoordinateFromUser(String coordinate, PlateauSize grid) {
//        Position startingPosition = new Position();
        System.out.print("Where would you like to place the Rover: please provide the " + coordinate + "-coordinate: ");
        String startingXCoordinate = userInput.nextLine();
        while (!startingXCoordinate.matches("\\d")) {
            System.out.print("Please only enter a number to indicate the vertical plane you want to place the rover at the start: ");
            startingXCoordinate = userInput.nextLine();
        }
        int validStaringCoordinate = stringParser.parseInput(startingXCoordinate);

        if (isStartingPositionAvailable(grid, validStaringCoordinate)) {
            return validStaringCoordinate;
        } else {
            System.out.println("-1");
            return -1;
        }

//        return validStaringCoordinate;
//        if (coordinate.equalsIgnoreCase("x")) {
//            startingPosition.setX(validStaringCoordinate);
//        } else if (coordinate.equalsIgnoreCase("y")) {
//            startingPosition.setY(validStaringCoordinate);
//        }
//        while (validStaringCoordinate > grid.getRows() || validStaringCoordinate > grid.getColumns()) {
//            getRoverStartingCoordinateFromUser("x or y", grid);
//        }
//        System.out.println("In bounds");
//        return startingPosition;

    }

    public boolean isStartingPositionAvailable(PlateauSize grid, int coordinate) {

        while (coordinate > grid.getRows() || coordinate > grid.getColumns()) {
            getRoverStartingCoordinateFromUser("x or y", grid);
        }
        System.out.println("In bounds");
        return true;

//        List<Integer> proposedStartPosition = getRoverStartingPositionFromUser();
//        List<List<List<Integer>>> availableStartingPositions = plateauGrid.makePlateau();
//        List<Integer> xYCoordinate = new ArrayList<>();
//        xYCoordinate.add(position.getX());
//        xYCoordinate.add(position.getY());
//
//        List<List<List<Integer>>> plateauGrid =
//
//        while (!plateauGrid.contains(xYCoordinate)) {
//            getRoverStartingPositionFromUser();
//        }
//        return true;
    }

    public String getDirectionRoverIsFacingFromUser() { // should I add a Scnner parameter?
        System.out.print("Do you want Rover to be facing North(N), South (S), East(E) or West(W)? ");
        String directionFacing = userInput.next();
        while (directionFacing.matches("[^EWNS]")) {
            System.out.print("Please input N, S, E or W (case-sensitive) to indicate which direction Rover will be facing: ");
            directionFacing = userInput.next();
        }
        return directionFacing;
    }

    public char[] getMovementInstructionsFromUser() {
        System.out.print("Please tell me how you want Rover to move (L turns Rover 90 degrees left/R turns Rover 90 degrees right/M moves Rover forward): ");
        String movementInstructions = userInput.next();
        while (!movementInstructions.matches("[LRMlrm]+")) {
            System.out.print("Instructions for how you want Rover to move should only include L (turns Rover 90 degrees left), R (turns Rover 90 degrees right) and/or M (moves Rover forward): ");
            movementInstructions = userInput.next();
        }
        return movementInstructions.toUpperCase().toCharArray();
    }
}