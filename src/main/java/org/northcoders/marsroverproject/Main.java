package org.northcoders.marsroverproject;

import org.northcoders.io.UserInputValidation;

public class Main {
    public static void main(String[] args) {
        UserInputValidation plateauBoundariesFromUser = new UserInputValidation();
        // Step 1
        // get user input to define plateau boundaries
        // validate user input is a number
        int rows = plateauBoundariesFromUser.getPlateauBoundariesFromUser("rows");
        int columns = plateauBoundariesFromUser.getPlateauBoundariesFromUser("columns");
        // Step 2
        // set user input to row and column attributes of the Plateau grid object
        PlateauSize grid = new PlateauSize(rows, columns);
        grid.makePlateau();
        // Step 3
        // get user input to define where the rover will start
        // validate user input is a number
        // validate the starting position the user inputs is within boundaries
        // set user input to x and y fields of the gridPosition object
        int xPositionInput = plateauBoundariesFromUser.getRoverStartingCoordinateFromUser("x", grid, "vertical");
        int validXPosition = plateauBoundariesFromUser.getRoverStartingCoordinateWithinPlateau(grid, xPositionInput, "vertical", "x");
        int yPositionInput = plateauBoundariesFromUser.getRoverStartingCoordinateFromUser("y", grid, "horizontal");
        int validYPosition = plateauBoundariesFromUser.getRoverStartingCoordinateWithinPlateau(grid, yPositionInput, "horizontal", "y");
        // Step 4
        // get user input to define which direction the rover is facing
        // validate user input is N, S, E or W
        // set user input to directionFacing attribute of the gridPosition object
        String direction = plateauBoundariesFromUser.getDirectionRoverIsFacingFromUser().toUpperCase();
        Position gridPosition = new Position(validXPosition, validYPosition, direction);
        System.out.println("The Rover's starting x-y coordinate is " + validXPosition + ", "
                + validYPosition + " and is facing " + direction);
        // Step 5
        // get user input to define movement instructions
        // validate user input moves rover within the grid i.e., not out of bounds
        // changePositionOnGrid() method should perform this check -> return Position after completing the move
        // -> if the movingInstructions push the rover outside grid, return last x-y coordinates on the grid
        char[] moveInstructions = plateauBoundariesFromUser.getMovementInstructionsFromUser();
        Position gridPositionAfterMove = gridPosition.changePositionOnGrid(moveInstructions, grid);
        System.out.println("The Rover is at x-y coordinate, " + gridPositionAfterMove.getX() + ", "
                + gridPositionAfterMove.getY() + " and facing " + gridPositionAfterMove.getFacing().toUpperCase());
        // Step 6
        // the move() method will update the fields of the gridPosition object and rover1
        // return gridPosition object with final grid position and direction it is facing
        Rover rover1 = new Rover(gridPosition);
        rover1.moveRover(gridPositionAfterMove);
    }
}
