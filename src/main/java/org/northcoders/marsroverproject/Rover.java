package org.northcoders.marsroverproject;

public class Rover {
    private Position position;
    public Rover(Position position) {
        this.position = position;
    }
    public void moveRover() {
        System.out.println("After moving, the " + position.toString());
    }
}

