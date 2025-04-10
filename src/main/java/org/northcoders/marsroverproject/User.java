package org.northcoders.marsroverproject;

import java.util.Scanner;

public class User {
    private final Scanner sc;
    private final String name;
    private Rover rover;
    private int score;

    public User(Scanner sc) {
        this("Test user", sc);
    }
    public User(String name, Scanner sc) {
        this.name = name;
        this.sc = sc;
        rover = new Rover();
        score = 0;
    }
    // getters
    public String getName() {
        return name;
    }
    public Rover getRover() {
        return rover;
    }
    public int getScore() {
        return score;
    }
    // setters
    public void setScore(int score) {
        this.score += score;
    }
    /*tested*/public PlateauSize specifyPlateauSize() {
        System.out.println("Enter number of rows: ");

        int rows = specifyPlateauBoundaries();

        System.out.println("Enter number of columns: ");
        int columns = specifyPlateauBoundaries();

        return new PlateauSize(rows, columns);
    }
    /*indirectly tested*/private int specifyPlateauBoundaries() {
        String boundary = sc.nextLine();
        while (!boundary.matches("\\d+")) {
            System.out.println("Please try again");
            boundary = sc.nextLine();
        }
        return Integer.parseInt(boundary);
    } // consider whether too coupled for debugging
    /*tested*/public Position chooseAValidStartingPositionForRoverOnPlateau(PlateauSize userSpecifiedPlateau) {
        if (userSpecifiedPlateau == null) {
            return null;
        }
        System.out.printf("Where would you like to place the Rover on the plateau: please provide an x-coordinate between 0 and %s: %n", userSpecifiedPlateau.columns());
        int x = chooseStartingCoordinateForRover();
        x = checkXCoordinateIsWithinPlateau(userSpecifiedPlateau, x);

        System.out.printf("Where would you like to place the Rover on the plateau: please provide a y-coordinate between 0 and %s: %n", userSpecifiedPlateau.rows());
        int y = chooseStartingCoordinateForRover();
        y = checkYCoordinateIsWithinPlateau(userSpecifiedPlateau, y);

        System.out.print("Do you want Rover to be facing North(N), South (S), East(E) or West(W)? ");
        Direction facingDirection = chooseTheDirectionTheRoverIsFacing();

        Position start = new Position(x, y, facingDirection);
        System.out.println(start);
        return start;
    }
    // The following 4 private methods have been indirectly tested by testing the public method above - consider whether this is too coupled for debugging
    private int chooseStartingCoordinateForRover() {
        String singleCoordinate = sc.nextLine();
        while (!singleCoordinate.matches("\\d+")) {
            System.out.print("Please only enter a positive number within the plateau to indicate where you want to place the Rover at the start: ");
            singleCoordinate = sc.nextLine();
        }
        return Integer.parseInt(singleCoordinate);
    }
    private Direction chooseTheDirectionTheRoverIsFacing() {
        String directionFacing = sc.next();
        while (!directionFacing.matches("[ewnsEWNS]{1}")) {
            System.out.print("Please input N, S, E or W to indicate which direction Rover will be facing: ");
            directionFacing = sc.next();
        }
        return switch (directionFacing.substring(0,1).toLowerCase()) {
            case "n" -> Direction.NORTH;
            case "s" -> Direction.SOUTH;
            case "w" -> Direction.WEST;
            case "e" -> Direction.EAST;
            default -> null; // null will never be returned as the while loop means the switch condition can only be "n", "s", "e" or "w"
        };
    }
    private int checkXCoordinateIsWithinPlateau(PlateauSize plateau, int coordinate) {
        if (plateau == null) {
            return -1;
        }
        while (coordinate > plateau.columns()) {
            System.out.println("Out of bounds - please try again");
            coordinate = chooseStartingCoordinateForRover();
        }
        System.out.println("In bounds");
        return coordinate;
    }
    private int checkYCoordinateIsWithinPlateau(PlateauSize plateau, int coordinate) {
        if (plateau == null) {
            return -1;
        }
        while (coordinate > plateau.rows()) {
            System.out.println("Out of bounds - please try again");
            coordinate = chooseStartingCoordinateForRover();
        }
        System.out.println("In bounds");
        return coordinate;
    }
    /*tested*/public char[] supplyMovementInstructionsForTheRover() {
        System.out.print("Please tell me how you want Rover to move (L turns Rover 90 degrees left/R turns Rover 90 degrees right/M moves Rover forward): ");
        String movementInstructions = sc.next();
        while (!movementInstructions.matches("[LRMlrm]+")) {
            System.out.print("Instructions for how you want Rover to move should only include L (turns Rover 90 degrees left), R (turns Rover 90 degrees right) and/or M (moves Rover forward): ");
            movementInstructions = sc.next();
        }
        return movementInstructions.toUpperCase().toCharArray();
    }
    /*tested*/public boolean moveTheRoverAgain() {
        System.out.println("Press Q to quit the application or any other key to make another move");
        String action = sc.next().substring(0, 1).toLowerCase();
        return !action.equals("q");
    }
}