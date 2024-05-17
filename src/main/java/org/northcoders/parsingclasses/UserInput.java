package org.northcoders.parsingclasses;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    Scanner userInput = new Scanner(System.in);
    InputParser stringParser = new InputParser();

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
        // How do I restrict input to the board size?
        System.out.print("Where would you like to place the Rover: please provide the x-coordinate: ");
//        Scanner userInput = new Scanner(System.in);
        startingCoordinates.add(userInput.nextInt());

        // How do I restrict input to the board size?
        System.out.print("Where would you like to place the Rover: please provide the y-coordinate: ");
        startingCoordinates.add(userInput.nextInt());
//        userInput.close();
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
//        Scanner userInput = new Scanner(System.in);
        String movementInstructions = userInput.next();
//        userInput.close();
        char[] instructionsArray = movementInstructions.toCharArray();

        for (Character letter : instructionsArray) {
            if (letter != 'L' && letter != 'M' && letter != 'R') {
                System.out.print("Please tell me how you want Rover to move (L turns Rover 90 degrees left/R turns Rover 90 degrees right/M moves Rover forward): ");
                instructionsArray = userInput.next().toCharArray();
                // need this to loop to start of for loop if wrong input for 2nd time
            }
        }
        return instructionsArray;
    }
}