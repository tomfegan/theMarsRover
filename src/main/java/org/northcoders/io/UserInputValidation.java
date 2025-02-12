package org.northcoders.io;
import org.northcoders.marsroverproject.Direction;
import org.northcoders.marsroverproject.PlateauSize;
import org.northcoders.marsroverproject.Position;
import java.util.Scanner;

public class UserInputValidation {
    public static PlateauSize getPlateauSizeFromUser(Scanner sc) {
        System.out.println("Enter number of rows: ");
        int rows = UserInputValidation.getPlateauBoundaryFromUser(sc);

        System.out.println("Enter number of columns: ");
        int columns = UserInputValidation.getPlateauBoundaryFromUser(sc);

        return new PlateauSize(rows, columns);
    }
    private static int getPlateauBoundaryFromUser(Scanner sc) {
        String rowsInString = sc.nextLine();
        while (!rowsInString.matches("\\d+")) {
            System.out.println("Please try again");
            rowsInString = sc.nextLine();
        }
        return Integer.parseInt(rowsInString);
    }
    public static Position getValidRoverStartingPositionFromUser(Scanner sc, PlateauSize userGrid) {
        UserInputValidation ui = new UserInputValidation();
        System.out.print("Where would you like to place the Rover on the plateau: please provide the x-coordinate first: ");
        int x = ui.getRoverStartingCoordinateFromUser(sc);
        x = ui.isXCoordinateWithinPlateau(userGrid, x);

        System.out.print("Where would you like to place the Rover on the plateau: please provide the y-coordinate now: ");
        int y = ui.getRoverStartingCoordinateFromUser(sc);
        y = ui.isYCoordinateWithinPlateau(userGrid, y);

        System.out.print("Do you want Rover to be facing North(N), South (S), East(E) or West(W)? ");
        Direction facingDirection = ui.getDirectionRoverIsFacingFromUser(sc);

        Position start = new Position(x, y, facingDirection);
        System.out.println(start);
        return start;
    }
    private int getRoverStartingCoordinateFromUser(Scanner sc) {
        String singleCoordinate = sc.nextLine();
        while (!singleCoordinate.matches("\\d+")) {
            System.out.print("Please only enter a positive number within the grid to indicate where you want to place the Rover at the start: ");
            singleCoordinate = sc.nextLine();
        }
            return Integer.parseInt(singleCoordinate);
    }
    private Direction getDirectionRoverIsFacingFromUser(Scanner sc) {
        String directionFacing = sc.next();
        while (!directionFacing.matches("[ewnsEWNS]{1}")) {
            System.out.print("Please input N, S, E or W to indicate which direction Rover will be facing: ");
            directionFacing = sc.next();
        }
        return switch (directionFacing.toLowerCase()) {
            case "n" -> Direction.NORTH;
            case "s" -> Direction.SOUTH;
            case "w" -> Direction.WEST;
            case "e" -> Direction.EAST;
            default -> null;
        };
    }
    private int isXCoordinateWithinPlateau(PlateauSize grid, int coordinate) {
        while (coordinate > grid.columns()) {
            System.out.println("Out of bounds - please try again");
            coordinate = getRoverStartingCoordinateFromUser( new Scanner(System.in));
        }
        System.out.println("In bounds");
        return coordinate;
    }
    private int isYCoordinateWithinPlateau(PlateauSize grid, int coordinate) {
        while (coordinate > grid.rows()) {
            System.out.println("Out of bounds - please try again");
            coordinate = getRoverStartingCoordinateFromUser( new Scanner(System.in));
        }
        System.out.println("In bounds");
        return coordinate;
    }
    public static char[] getMovementInstructionsFromUser(Scanner sc) {
        System.out.print("Please tell me how you want Rover to move (L turns Rover 90 degrees left/R turns Rover 90 degrees right/M moves Rover forward): ");
        String movementInstructions = sc.next();
        while (!movementInstructions.matches("[LRMlrm]+")) {
            System.out.print("Instructions for how you want Rover to move should only include L (turns Rover 90 degrees left), R (turns Rover 90 degrees right) and/or M (moves Rover forward): ");
            movementInstructions = sc.next();
        }
        return movementInstructions.toUpperCase().toCharArray();
    }
}