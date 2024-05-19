package org.northcoders.marsroverproject;

public class Position {
    private int x;
    private int y;
    private String facing;
    public Position(int x, int y, String facing) {
        this.x = x;
        this.y = y;
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
    public Position changePositionOnGrid(char[] moveInstructions, PlateauSize grid) {
        for (Character instruction : moveInstructions) {
            if (this.facing.equalsIgnoreCase("N") && instruction.equals('L')) {
                this.facing = "W";
            } else if (this.facing.equalsIgnoreCase("S") && instruction.equals('L')) {
                this.facing = "E";
            } else if (this.facing.equalsIgnoreCase("E") && instruction.equals('L')) {
                this.facing = "N";
            } else if (this.facing.equalsIgnoreCase("W") && instruction.equals('L')) {
                this.facing = "S";
            } else if (this.facing.equalsIgnoreCase("N") && instruction.equals('R')) {
                this.facing = "E";
            } else if (this.facing.equalsIgnoreCase("S") && instruction.equals('R')) {
                this.facing = "W";
            } else if (this.facing.equalsIgnoreCase("E") && instruction.equals('R')) {
                this.facing = "S";
            } else if (this.facing.equalsIgnoreCase("W") && instruction.equals('R')) {
                this.facing = "N";
            } else if (instruction == 'M' && this.facing.equalsIgnoreCase("N")) {
                if (this.y + 1 <= grid.getRows() && this.y + 1 >= 0) {
                    this.y += 1;
                }
            } else if (instruction == 'M' && this.facing.equalsIgnoreCase("S")) {
                if (this.y - 1 <= grid.getRows() && this.y - 1 >= 0) {
                    this.y -= 1;
                }
            } else if (instruction == 'M' && this.facing.equalsIgnoreCase("E")) {
                if (this.x + 1 <= grid.getColumns() && this.x + 1 >= 0) {
                    this.x += 1;
                }
            } else if (instruction == 'M' && this.facing.equalsIgnoreCase("W")) {
                if (this.x - 1 <= grid.getColumns() && this.x - 1 >= 0) {
                    this.x -= 1;
                }
            }
        }
        return new Position(this.x, this.y, this.facing);
    }
}
