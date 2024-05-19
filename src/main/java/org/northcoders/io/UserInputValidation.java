package org.northcoders.io;
import org.northcoders.marsroverproject.PlateauSize;
import java.util.Scanner;

public class UserInputValidation {
    Scanner userInput = new Scanner(System.in);
    public int getRoverStartingCoordinateFromUser(String xOrY, PlateauSize grid, String plane) {
        System.out.print("Where would you like to place the Rover on the " + grid.getRows() + "x" + grid.getColumns() + " plateau: please provide the " + xOrY +"-coordinate: ");
        String singleCoordinate = userInput.nextLine();
        while (!singleCoordinate.matches("\\d+")) {
            System.out.print("Please only enter a number to indicate the " + plane + " plane you want to place the rover at the start: ");
            singleCoordinate = userInput.nextLine();
        }
        return Integer.parseInt(singleCoordinate);
    }
    public int getRoverStartingCoordinateWithinPlateau(PlateauSize grid, int coordinate, String plane, String xOrY) {
        while (coordinate > grid.getRows() || coordinate > grid.getColumns()) {
            System.out.println("Out of bounds - please try again");
            coordinate = getRoverStartingCoordinateFromUser(xOrY, grid, plane);
        }
        System.out.println("In bounds");
        return coordinate;
    }
    public String getDirectionRoverIsFacingFromUser() { // should I add a Scnner parameter?
        System.out.print("Do you want Rover to be facing North(N), South (S), East(E) or West(W)? ");
        String directionFacing = userInput.next();
        while (!directionFacing.matches("[ewnsEWNS]{1}")) {
            System.out.print("Please input N, S, E or W to indicate which direction Rover will be facing: ");
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
    public int getPlateauBoundariesFromUser(String gridReference) {
        System.out.print("Enter number of " + gridReference + ": ");
        String rowsInString = userInput.nextLine();
        while (!rowsInString.matches("\\d+")) {
            System.out.print("Please only enter a number to indicate how many " + gridReference + " you want the grid to have: ");
            rowsInString = userInput.nextLine();
        }
        return Integer.parseInt(rowsInString);
    }
}