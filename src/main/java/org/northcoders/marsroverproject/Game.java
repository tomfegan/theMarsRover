package org.northcoders.marsroverproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private PlateauSize plateau;
    private final User user;
    private List<Asteroid> asteroids;
    private int gameNumber;

    public Game(User user) {
        this.user = user;
        asteroids = new ArrayList<>(20);
        gameNumber = 0;
    }

    public void addAsteroidToList(Asteroid asteroid) {
        asteroids.add(asteroid);
    }

    public void playGame() {
        // Welcome user to the game
        System.out.printf("Welcome %s%n", user.getName());
        // User decides on the size of the plateau
        plateau = user.specifyPlateauSize();
        // User places Rover within the plateau
        user.getRover().setPosition(user.chooseAValidStartingPositionForRoverOnPlateau(plateau));
        // Check if Rover is on boundary of plateau to warn player
        isRoverOnBoundary();
        // Generate and print the plateau with the Rover's starting position
        printPlateauOutFromStringBuilder(generateLiveGamePlateauAsStringBuilder());
        do {
            // User supplies directions and the Rover is moved accordingly
            user.getRover().getPosition().changePositionOnPlateau(user.supplyMovementInstructionsForTheRover(),
                    plateau);
            // Check if Rover is on boundary of plateau to warn player
            isRoverOnBoundary();
            // Create a new asteroid with a random size and randomly assign its position within the plateau-add the asteroid to asteroids list
            Asteroid newAsteroid = new Asteroid(new Random());
            addAsteroidToList(newAsteroid);
            asteroids.get(gameNumber).assignRandomPositionWithinPlateauForAsteroid(plateau);

            if (asteroids.get(gameNumber).getSize().equals(AsteroidSize.PLANET_DESTROYER)) {
                System.out.printf("GAME OVER %s! A %s asteroid destroyed Mars and your Rover, along with everything else, is floating through time and space. %s scored %d%n",
                        user.getName().toUpperCase(), asteroids.get(gameNumber).getSize(), user.getName(), user.getScore());
                printPlateauOutFromStringBuilder(generateLiveGamePlateauAsStringBuilder());
                break;
            } else if (didAsteroidHitRover()) {
                System.out.printf("GAME OVER %s! A %s asteroid hit your Rover at %d,%d and it is damaged beyond repair. %s scored %d%n",
                        user.getName().toUpperCase(), asteroids.get(gameNumber).getSize(), asteroids.get(gameNumber).getPosition().getX(), asteroids.get(gameNumber).getPosition().getY(), user.getName(), user.getScore());
                printPlateauOutFromStringBuilder(generateLiveGamePlateauAsStringBuilder());
                break;
            } else {
                user.setScore(10);
                System.out.printf("WARNING FOR %s: a %s asteroid hit the plateau at %d,%d and fortunately missed your Rover. The plateau has been cleaned up and you're free to continue. Your score is %d%n",
                        user.getName().toUpperCase(), asteroids.get(gameNumber).getSize(), asteroids.get(gameNumber).getPosition().getX(), asteroids.get(gameNumber).getPosition().getY(), user.getScore());
                // Print Rover's new position and asteroid on the plateau to help user choose their next move
                printPlateauOutFromStringBuilder(generateLiveGamePlateauAsStringBuilder());
                gameNumber++;
            }
        } while (user.moveTheRoverAgain());
        // Thank player and give their final score along with a list of asteroids
        System.out.printf("Thank you %s for playing. You scored %d%n", user.getName(), user.getScore());
        for (int i = 0; i < asteroids.size(); i++) {
            System.out.printf("Asteroid %d: %s", i + 1, asteroids.get(i).toString());
        }
    }

    /*tested*/public StringBuilder[] generateLiveGamePlateauAsStringBuilder() {
        StringBuilder[] gamePlateau = new StringBuilder[plateau.rows() + 1];

        for (int i = 0; i <= plateau.rows(); i++) { // i relates to y value
            StringBuilder arrayRow = new StringBuilder();
            for (int j = 0; j <= plateau.columns(); j++) { // j relates to x value
                gamePlateau[i] = arrayRow;
                if (!asteroids.isEmpty() && asteroids.get(gameNumber).getSize().equals(AsteroidSize.PLANET_DESTROYER)) {
                    arrayRow.append("❌");
                } else if (!asteroids.isEmpty() && user.getRover().getPosition() != null && asteroids.get(gameNumber).getPosition() != null &&
                        j == user.getRover().getPosition().getX() &&
                        i == user.getRover().getPosition().getY() &&
                        j == asteroids.get(gameNumber).getPosition().getX() &&
                        i == asteroids.get(gameNumber).getPosition().getY()) {

                    arrayRow.append("❌");

                } else if (user.getRover().getPosition() != null && j == user.getRover().getPosition().getX() && i == user.getRover().getPosition().getY()) {
                    switch (user.getRover().getPosition().getFacing()) {
                        case Direction.NORTH -> arrayRow.append("△");
                        case Direction.EAST -> arrayRow.append("▷");
                        case Direction.SOUTH -> arrayRow.append("▽");
                        case Direction.WEST -> arrayRow.append("◁");
                    }
                } else if (!asteroids.isEmpty() && asteroids.get(gameNumber).getPosition() != null && j == asteroids.get(gameNumber).getPosition().getX() && i == asteroids.get(gameNumber).getPosition().getY()) {
                    arrayRow.append("☄");
                } else {
                    arrayRow.append("◦");
                }
            }
        }
        return gamePlateau;
    }

    public void printPlateauOutFromStringBuilder(StringBuilder[] plateauArray) {
        for (int x = plateau.rows(); x >= 0; x--) {
            System.out.print(" " + plateauArray[x] + " ");
            System.out.println();
        }
    }

    /*tested*/public boolean didAsteroidHitRover() {
        if (asteroids.isEmpty()) {
            System.out.println("There are no asteroids so the Rover has not been hit");
            return false;
        } else if (asteroids.get(gameNumber).getPosition() == null) {
            System.out.println("Asteroid position is null");
            return false;
        } else if (user.getRover().getPosition() == null) {
            System.out.println("Rover position is null");
            return false;
        } else {
            return user.getRover().getPosition().getX() == asteroids.get(gameNumber).getPosition().getX() &&
                    user.getRover().getPosition().getY() == asteroids.get(gameNumber).getPosition().getY();
        }
    }

    /*tested*/
    public boolean isRoverOnBoundary() {
        boolean result = false;
        if (user.getRover().getPosition() == null) {
            System.out.println("Rover position is null");
            return result;
        } else if (plateau == null) {
            System.out.println("Plateau size is null");
            return result;
        } else if (user.getRover().getPosition().getX() == plateau.columns() || user.getRover().getPosition().getX() == 0 ||
                user.getRover().getPosition().getY() == plateau.rows() || user.getRover().getPosition().getY() == 0) {
            user.getRover().boundaryAlert();
            result = true;
        }
        return result;
    }

    // getters
    public PlateauSize getPlateau() {
        return plateau;
    }

    // setters
    public void setPlateau(PlateauSize plateau) {
        this.plateau = plateau;
    }
}

