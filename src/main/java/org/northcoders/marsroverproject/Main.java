package org.northcoders.marsroverproject;

import org.northcoders.parsingclasses.UserInput;

public class Main {
    public static void main(String[] args) {

        UserInput userRows = new UserInput();
        int rows = userRows.getNumberOfRowsFromUser();
        int columns = userRows.getNumberOfColumnsFromUser();
        PlateauSize grid = new PlateauSize(rows, columns);
        grid.gridMaker(rows, columns);

        System.out.println(userRows.getRoverStartingPositionFromUser());
        System.out.println(userRows.getDirectionRoverIsFacingFromUser());
        System.out.println(userRows.getMovementInstructionsFromUser());

    }
}
