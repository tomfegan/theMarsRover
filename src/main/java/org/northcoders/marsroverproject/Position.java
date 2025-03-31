package org.northcoders.marsroverproject;

public class Position {
    /* decided not to make Position an inner class of Rover to make code extensible as other vehicles could be placed on Mars in future -
    keeps code DRY (don't repeat yourself) */
    private int x;
    private int y;
    private Direction facing;
    public Position(int x, int y, Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Direction getFacing() {
        return facing;
    }
    /*tested*/public void changePositionOnPlateau(char[] moveInstructions, PlateauSize plateau) {
        if (moveInstructions == null) {
            System.out.println("Move instructions are null");
        } else if (plateau == null) {
            System.out.println("Plateau size is null");
        } else {
            for (Character instruction : moveInstructions) {
                if (this.facing.equals(Direction.NORTH) && instruction.equals('L')) {
                    this.facing = Direction.WEST;
                } else if (this.facing.equals(Direction.SOUTH) && instruction.equals('L')) {
                    this.facing = Direction.EAST;
                } else if (this.facing.equals(Direction.EAST) && instruction.equals('L')) {
                    this.facing = Direction.NORTH;
                } else if (this.facing.equals(Direction.WEST) && instruction.equals('L')) {
                    this.facing = Direction.SOUTH;
                } else if (this.facing.equals(Direction.NORTH) && instruction.equals('R')) {
                    this.facing = Direction.EAST;
                } else if (this.facing.equals(Direction.SOUTH) && instruction.equals('R')) {
                    this.facing = Direction.WEST;
                } else if (this.facing.equals(Direction.EAST) && instruction.equals('R')) {
                    this.facing = Direction.SOUTH;
                } else if (this.facing.equals(Direction.WEST) && instruction.equals('R')) {
                    this.facing = Direction.NORTH;
                } else if (instruction == 'M' && this.facing.equals(Direction.NORTH)) {
                    if (this.y + 1 <= plateau.rows()) {
                        this.y += 1;
                    }
                } else if (instruction == 'M' && this.facing.equals(Direction.SOUTH)) {
                    if (this.y - 1 >= 0) {
                        this.y -= 1;
                    }
                } else if (instruction == 'M' && this.facing.equals(Direction.EAST)) {
                    if (this.x + 1 <= plateau.columns()) {
                        this.x += 1;
                    }
                } else if (instruction == 'M' && this.facing.equals(Direction.WEST)) {
                    if (this.x - 1 >= 0) {
                        this.x -= 1;
                    }
                }
            }
            System.out.println(this);
        }
    }
    @Override
    public String toString() {
        return String.format("Mars Rover is now located at %d,%d and facing %s", x, y, facing);
    }
}
