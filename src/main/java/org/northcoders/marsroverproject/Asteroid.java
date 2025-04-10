package org.northcoders.marsroverproject;

import java.util.Random;

enum AsteroidSize {
    SMALL,
    MEDIUM,
    LARGE,
    PLANET_DESTROYER;

    @Override
    public String toString() {
        return switch (this) {
            case SMALL -> "small";
            case MEDIUM -> "medium-sized";
            case LARGE -> "large";
            case PLANET_DESTROYER -> "planet-destroying";
        };
    }
}
public class Asteroid {
    private final AsteroidSize size;
    private Position position;
    private Random random;
    public Asteroid(Random random) { // Constructor does not initialise position because the PlateauSize will constrain this
        this.random = random;
        int randomInt = random.nextInt(AsteroidSize.values().length);
        size = switch (randomInt) {
            case 0 -> AsteroidSize.SMALL;
            case 1 -> AsteroidSize.MEDIUM;
            case 2 -> AsteroidSize.LARGE;
            case 3 -> AsteroidSize.PLANET_DESTROYER;
            default -> throw new IllegalStateException("Unexpected value: " + randomInt);  // all AsteroidSize values covered by cases 1-3 so this exception should never be thrown
        };
    }

    public Asteroid(AsteroidSize size) {
        this.size = size;
    }

    /*tested*/public void assignRandomPositionWithinPlateauForAsteroid(PlateauSize gamePlateau) {
        // the number of columns determines the max X value
        // the number of rows determines the max Y value
        int x = random.nextInt(gamePlateau.columns() + 1);
        int y = random.nextInt(gamePlateau.rows() + 1);
        this.position = new Position(x, y);
    }
    // getters
    public Position getPosition() {
        return position;
    }
    public AsteroidSize getSize() {
        return size;
    }
    // setters
    public void setPosition(Position position) {
        this.position = position;
    }
}
