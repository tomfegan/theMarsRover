package org.northcoders.marsroverproject;

public class Rover {
    private Position position;
    public Rover() {
    }
    public Rover(Position position) {
        this.position = position;
    }
    // setter
    public void setPosition(Position position) {
        this.position = position;
    }
    // getter
    public Position getPosition() {
        return position;
    }
    public void boundaryAlert() {
        System.out.println("Alert! Rover is on the boundary");
    }

}

