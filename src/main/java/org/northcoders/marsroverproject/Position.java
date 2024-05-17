package org.northcoders.marsroverproject;


// Sprint task instructed this class with these fields _ i added constructor
public class Position {
    private int x;
    private int y;
    private CompassDirection facing; // enum with N, S, W, E

//    public Position(int x, int y, CompassDirection facing) {
//        this.x = x;
//        this.y = y;
//        this.facing = facing;
//    }

    public boolean isStartingXCoordinateAvailable(Position proposedPosition, PlateauSize gridSize) {
        return gridSize.getRows() >= proposedPosition.y;
    }

    public boolean isStartingYCoordinateAvailable(Position proposedPosition, PlateauSize gridSize) {
        return gridSize.getColumns() >= proposedPosition.x;
    }

//    public boolean isPositionAfterMoveAvailable(Position currentPosition, Position proposedPosition, PlateauSize gridSize) {
//
//    }
}
