package org.northcoders.marsroverproject;

import org.northcoders.parsingclasses.UserInputValidation;

public class Main {
    public static void main(String[] args) {
        Position startingPosition = new Position();
        UserInputValidation userRows = new UserInputValidation();
        PlateauSize grid = new PlateauSize();
        Rover rover1 = new Rover(startingPosition);
        // Step 1
        // get user input to define plateau boundaries
        // validate user input is a number
        int rows = userRows.getNumberOfRowsFromUser();
        int columns = userRows.getNumberOfColumnsFromUser();
        // Step 2
        // set user input to row and column attributes of the Plateau grid object
        grid.setRows(rows);
        grid.setColumns(columns);
        grid.makePlateau(rows, columns);
        // Step 3
        // get user input to define where the rover will start
        // validate user input is a number
        // validate user input within boundaries
        // set user input to x and y fields of the startingPosition object
        int xPosition = userRows.getRoverStartingCoordinateFromUser("x", grid);
        startingPosition.setX(xPosition);
        int yPosition = userRows.getRoverStartingCoordinateFromUser("y", grid);
        startingPosition.setY(yPosition);
        // Step 4
        // get user input to define which direction the rover is facing
        // validate user input is N, S, E or W
        // set user input to directionFacing attribute of the startingPosition object
        String direction = userRows.getDirectionRoverIsFacingFromUser();
        startingPosition.setFacing(direction);
        System.out.println("The Rover's starting x-y coordinate is " + startingPosition.getX() + ", "
                + startingPosition.getY() + " and is facing " + startingPosition.getFacing());
        // Step 5
        // get user input to define movement instructions
        // validate user input moves rover within the grid i.e., not out of bounds
        // changePositionOnGrid() method should perform this check -> return Position after completing the move
        // -> if the movingInstructions push the rover outside grid, return last x-y coordinates on the grid
        char[] moveInstructions = userRows.getMovementInstructionsFromUser();
        Position gridPositionAfterMove = startingPosition.changePositionOnGrid(moveInstructions, startingPosition, grid);
        System.out.println("The Rover is at x-y coordinate, " + startingPosition.getX() + ", "
                + startingPosition.getY() + " and facing " + startingPosition.getFacing());

        // Step 6
        // the move() method will update the fields of the startingPosition object and rover1
        // return startingPosition object with final grid position and direction it is facing
        rover1.moveRover(startingPosition);
    }
}
