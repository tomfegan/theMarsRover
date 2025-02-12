package org.northcoders.marsroverproject;

import org.northcoders.io.UserInputValidation;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlateauSize userGrid = UserInputValidation.getPlateauSizeFromUser(sc);
        Position validUserStartingPosition = UserInputValidation.getValidRoverStartingPositionFromUser(sc, userGrid);
        Rover rover = new Rover(validUserStartingPosition);
        validUserStartingPosition.changePositionOnGrid(UserInputValidation.getMovementInstructionsFromUser(sc), userGrid);
        rover.moveRover();
        System.out.println("Press Y to move the Rover again or Q to quit the application");
        String action = sc.next().toLowerCase();

        while (!Objects.equals(action, "q")) {
            validUserStartingPosition.changePositionOnGrid(UserInputValidation.getMovementInstructionsFromUser(sc), userGrid);
            rover.moveRover();
            System.out.println("Press Y to move the Rover again or Q to quit the application");
            action = sc.next().toLowerCase();
        }
    }
}
