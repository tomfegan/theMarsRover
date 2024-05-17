package org.northcoders.marsroverproject;

import java.util.ArrayList;
import java.util.List;

// Sprint task instructed this class without fields - I have added all code in this class
public class PlateauSize {
    // musings: do I need a scanner object field?
    private static final int lowerXCoordinate = 0;
    private static final int lowerYCoordinate = 0;
    private int rows;
    private int columns;

    public PlateauSize(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<List<List<Integer>>> gridMaker(int rows, int columns) {

        List<List<List<Integer>>> gridOfCoordinates = new ArrayList<>();

        for (int y = rows; y >= 0; y--) {
            List<List<Integer>> rowOfCoordinates = new ArrayList<>();
            for (int x = 0; x <= columns; x++) {
                List<Integer> singleCoordinate = new ArrayList<>();
                singleCoordinate.add(x);
                singleCoordinate.add(y);
                rowOfCoordinates.add(singleCoordinate);
            }
            gridOfCoordinates.add(rowOfCoordinates);
        }
        System.out.println(gridOfCoordinates);
        return gridOfCoordinates;
    }
}
