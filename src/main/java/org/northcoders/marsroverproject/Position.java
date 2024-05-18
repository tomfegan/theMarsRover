package org.northcoders.marsroverproject;


// Sprint task instructed this class with these fields _ i added constructor
public class Position {
    private int x;
    private int y;
    private String facing;
//    private CompassDirection facing; // enum with N, S, W, E

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getFacing() {
        return facing;
    }

    //    public Position(int x, int y, CompassDirection facing) {
//        this.x = x;
//        this.y = y;
//        this.facing = facing;
//    }
//
//    public Position() { // no args constructor
//    }
//    public boolean isStartingXCoordinateAvailable(Position proposedPosition, PlateauSize gridSize) {
//        return gridSize.getRows() >= proposedPosition.y;
//    }
//
//    public boolean isStartingYCoordinateAvailable(Position proposedPosition, PlateauSize gridSize) {
//        return gridSize.getColumns() >= proposedPosition.x;
//    }

//    public boolean isPositionAfterMoveAvailable(Position currentPosition, Position proposedPosition, PlateauSize gridSize) {
//
//    }
public Position changePositionOnGrid(char[] moveInstructions, Position currentPosition, PlateauSize grid) {
    for (Character instruction : moveInstructions) {
        if (currentPosition.getFacing().equals("N") && instruction.equals('L')) {
            currentPosition.setFacing("W");
        } else if (currentPosition.getFacing().equals("S") && instruction.equals('L')) {
            currentPosition.setFacing("E");
        } else if (currentPosition.getFacing().equals("E") && instruction.equals('L')) {
            currentPosition.setFacing("N");
        } else if (currentPosition.getFacing().equals("W") && instruction.equals('L')) {
            currentPosition.setFacing("S");
        } else if (currentPosition.getFacing().equals("N") && instruction.equals('R')) {
            currentPosition.setFacing("E");
        } else if (currentPosition.getFacing().equals("S") && instruction.equals('R')) {
            currentPosition.setFacing("W");
        } else if (currentPosition.getFacing().equals("E") && instruction.equals('R')) {
            currentPosition.setFacing("S");
        } else if (currentPosition.getFacing().equals("W") && instruction.equals('R')) {
            currentPosition.setFacing("N");
        } else if (instruction == 'M' && currentPosition.getFacing().equals("N")) {
            if (currentPosition.getY() + 1 <= grid.getRows() && currentPosition.getY() + 1 >= 0) {
                currentPosition.setY(currentPosition.getY() + 1);
            }
        } else if (instruction == 'M' && currentPosition.getFacing().equals("S")) {
            if (currentPosition.getY() - 1 <= grid.getRows() && currentPosition.getY() - 1 >= 0) {
                currentPosition.setY(currentPosition.getY() - 1);
            }
        } else if (instruction == 'M' && currentPosition.getFacing().equals("E")) {
            if (currentPosition.getX() + 1 <= grid.getColumns() && currentPosition.getX() + 1 >= 0) {
                currentPosition.setX(currentPosition.getX() + 1);
            }
        } else if (instruction == 'M' && currentPosition.getFacing().equals("W")) {
            if (currentPosition.getX() - 1 <= grid.getColumns() && currentPosition.getX() - 1 >= 0) {
                currentPosition.setX(currentPosition.getX() - 1);
            }
        }
    } // end of loop
    return currentPosition;
}
}
