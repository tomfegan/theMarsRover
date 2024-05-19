package org.northcoders.marsroverproject;

public class Rover {
    Position position;
    public Rover(Position position) {
        this.position = position;
    }
    public Position moveRover(Position proposedPosition) {
        return position = proposedPosition;
    }
}

