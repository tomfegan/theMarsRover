package org.northcoders.marsroverproject;

import java.util.ArrayList;
import java.util.List;

public class PlateauSize {
    private int rows;
    private int columns;
    public PlateauSize() { }

//    public PlateauSize(int rows, int columns) {
//        this.rows = rows;
//        this.columns = columns;
//    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
    //
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<List<List<Integer>>> makePlateau(int rows, int columns) {

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
