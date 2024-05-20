package org.northcoders.marsroverproject;

import org.northcoders.io.UserInputValidation;

public class Main {
    public static void main(String[] args) {
        // Step 1 - get user input to define plateau boundaries AND validate user input is a number
        UserInputValidation plateauBoundariesFromUser = new UserInputValidation();
        int rows = plateauBoundariesFromUser.getPlateauBoundariesFromUser("rows");
        int columns = plateauBoundariesFromUser.getPlateauBoundariesFromUser("columns");
        // Step 2 - construct Plateau object, passing above user input to its row and column attributes, and call makePlateau()
        PlateauSize grid = new PlateauSize(rows, columns);
//        grid.makePlateau();
        // Step 3 - get user input to define where the rover will start on the grid AND validate:-
        // -> user input is a number
        // -> the starting position is within boundaries
        // set user input to x and y fields of the Position object
        int xPositionInput = plateauBoundariesFromUser.getRoverStartingCoordinateFromUser("x", grid, "vertical");
        int validXPosition = plateauBoundariesFromUser.getRoverStartingXCoordinateWithinPlateau(grid, xPositionInput, "vertical", "x");
        int yPositionInput = plateauBoundariesFromUser.getRoverStartingCoordinateFromUser("y", grid, "horizontal");
        int validYPosition = plateauBoundariesFromUser.getRoverStartingYCoordinateWithinPlateau(grid, yPositionInput, "horizontal", "y");
        // Step 4 - get user input to define which direction the rover is facing - validate input is N, S, E or W and then
        // set user input to directionFacing attribute of the gridPosition object
        String direction = plateauBoundariesFromUser.getDirectionRoverIsFacingFromUser().toUpperCase();
        Position gridPosition = new Position(validXPosition, validYPosition, direction);
        System.out.println("The Rover's starting x-y coordinate is " + validXPosition + ", "
                + validYPosition + " and is facing " + direction);
        // Step 5 - get user input to define movement instructions
        // validate user input moves rover within the grid i.e., not out of bounds
        // changePositionOnGrid() method should perform this check -> return Position after completing the move
        // -> if the movingInstructions push the rover outside grid, return last x-y coordinates on the grid
        char[] moveInstructions = plateauBoundariesFromUser.getMovementInstructionsFromUser();
        gridPosition.changePositionOnGrid(moveInstructions, grid);
        System.out.println("After moving, the Rover's x-y coordinate is (" + gridPosition.getX() + ", "
                + gridPosition.getY() + ") and is facing " + gridPosition.getFacing());
        // Step 6
        // the move() method will update the fields of the gridPosition object and rover1
        // return gridPosition object with final grid position and direction it is facing
        Rover rover1 = new Rover(gridPosition);
        rover1.moveRover(gridPosition);
    }
}
