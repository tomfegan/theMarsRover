package org.northcoders.marsroverproject;

public class Rover {
    private Position position;
    public Rover(Position position) {
        this.position = position;
    }
    public void moveRover() {
        System.out.println("After moving, the " + position.toString());
    }

//    @Override
//    public String toString() {
//        return String.format("Rover currently at %d,%d and facing %s%n", position.getX(),position.getY(), position.getFacing());
//    }
}

