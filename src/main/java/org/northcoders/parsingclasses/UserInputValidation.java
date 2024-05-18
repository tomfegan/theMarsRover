package org.northcoders.parsingclasses;

import org.northcoders.marsroverproject.PlateauSize;
import org.northcoders.marsroverproject.Position;

import java.util.*;

public class UserInputValidation { // should this class be static?
    Scanner userInput = new Scanner(System.in);
    Position position = new Position();





    public int getRoverStartingCoordinateFromUser(String xOrY, PlateauSize grid) {
        System.out.print("Where would you like to place the Rover: please provide the " + xOrY +"-coordinate: ");
        String singleCoordinate = userInput.nextLine();
        while (!singleCoordinate.matches("\\d+")) {
            System.out.print("Please only enter a number to indicate the plane you want to place the rover at the start: ");
            singleCoordinate = userInput.nextLine();
        }
        return Integer.parseInt(singleCoordinate);
    }
    public int getStartingPositionWithinPlateau(PlateauSize grid, int coordinate) {

        while (coordinate > grid.getRows() || coordinate > grid.getColumns()) {
            coordinate = getRoverStartingCoordinateFromUser("x or y", grid);
        }
        System.out.println("In bounds");
        return coordinate;
    }






//    public int getRoverStartingCoordinateFromUser(String xOrY, PlateauSize grid) {
//        System.out.print("Where would you like to place the Rover: please provide the " + xOrY +"-coordinate: ");
//        String singleCoordinate = userInput.nextLine();
//        while (!singleCoordinate.matches("\\d+")) {
//            System.out.print("Please only enter a number to indicate the plane you want to place the rover at the start: ");
//            singleCoordinate = userInput.nextLine();
//        }
//        int validStaringCoordinate = Integer.parseInt(singleCoordinate);
//
//        if (isStartingPositionAvailable(grid, validStaringCoordinate)) {
//            return validStaringCoordinate;
//        } else {
//            System.out.println("-1");
//            return -1;
//        }
//    }
//    public boolean isStartingPositionAvailable(PlateauSize grid, int coordinate) {
//        while (coordinate > grid.getRows() || coordinate > grid.getColumns()) {
//            getRoverStartingCoordinateFromUser("x or y", grid);
//        }
//        System.out.println("In bounds");
//        return true;
//    }
    public String getDirectionRoverIsFacingFromUser() { // should I add a Scnner parameter?
        System.out.print("Do you want Rover to be facing North(N), South (S), East(E) or West(W)? ");
        String directionFacing = userInput.next();
        while (!directionFacing.matches("[EWNS]{1}")) {
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
    public int getPlateauBoundariesFromUser() throws InputMismatchException {
        String rowsInString = userInput.nextLine();
        while (!rowsInString.matches("\\d+")) {
            System.out.print("Please only enter a number to indicate how many you want the grid to have: ");
            rowsInString = userInput.nextLine();
        }
        return Integer.parseInt(rowsInString);
    }

    // getPlateauBoundariesFromUser() replaced the following methods to improve reusability:
//    public int getNumberOfRowsFromUser() throws InputMismatchException {
//        System.out.print("Enter number of rows: ");
//        String rowsInString = userInput.nextLine();
//        while (!rowsInString.matches("\\d+")) {
//            System.out.print("Please only enter a number to indicate how many rows you want the grid to have: ");
//            rowsInString = userInput.nextLine();
//        }
//        return Integer.parseInt(rowsInString);
//    }
//    public int getNumberOfColumnsFromUser() throws InputMismatchException {
//        System.out.print("Enter number of columns: ");
//        String columnsInString = userInput.nextLine();
//        while (!columnsInString.matches("\\d+")) {
//            System.out.print("Please only enter a number to indicate how many columns you want the grid to have: ");
//            columnsInString = userInput.nextLine();
//        }
//        return Integer.parseInt(columnsInString);
//    }
}