package org.northcoders.marsroverproject;

public class Rover {
    Position position;

    public Rover(Position position) {
        this.position = position;
    }

//    public Position getPosition() {
//        return position;
//    }
//
//    public void setPosition(Position position) {
//        this.position = position;
//    }

    public Position moveRover(Position proposedPosition) {
        return position = proposedPosition;
    }

    public Position getPosition() {
        return position;
    }
}

