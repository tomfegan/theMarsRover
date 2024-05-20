package org.northcoders.marsroverproject;

public class PlateauSize {
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
//    public List<List<List<Integer>>> makePlateau() {
//        List<List<List<Integer>>> gridOfCoordinates = new ArrayList<>();
//        for (int y = this.rows; y >= 0; y--) {
//            List<List<Integer>> rowOfCoordinates = new ArrayList<>();
//            for (int x = 0; x <= this.columns; x++) {
//                List<Integer> singleCoordinate = new ArrayList<>();
//                singleCoordinate.add(x);
//                singleCoordinate.add(y);
//                rowOfCoordinates.add(singleCoordinate);
//            }
//            gridOfCoordinates.add(rowOfCoordinates);
//        }
//        System.out.println(gridOfCoordinates);
//        return gridOfCoordinates;
//    }
}
