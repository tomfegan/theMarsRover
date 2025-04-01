package org.northcoders.marsroverproject;

public class Game {
    private PlateauSize plateau;
    private final User user;
    private Asteroid asteroid;

    public Game(User user, Asteroid asteroid) {
        this.user = user;
        this.asteroid = asteroid;
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
        // Generate the plateau with the Rover's starting position and print it out without square brackets and commas
        printPlateauOut(generateLiveGamePlateau());
        do {
            // User supplies directions and the Rover is moved accordingly
            user.getRover().getPosition().changePositionOnPlateau(user.supplyMovementInstructionsForTheRover(),
                    plateau);
            // Check if Rover is on boundary of plateau to warn player
            isRoverOnBoundary();
            // Assign a random position within the plateau to the asteroid
            asteroid.assignRandomPositionWithinPlateauForAsteroid(plateau);
            // Print Rover's new position and asteroid on the plateau to help user choose their next move
            printPlateauOut(generateLiveGamePlateau());

            if (didAsteroidHitRover()) {
                System.out.printf("GAME OVER %s! A %s asteroid hit your Rover at %d,%d and it is damaged beyond repair. %s scored %d%n",
                        user.getName().toUpperCase(), asteroid.getSize(), asteroid.getPosition().getX(), asteroid.getPosition().getY(), user.getName(), user.getScore());
                break;
            } else {
                user.setScore(10);
                System.out.printf("WARNING FOR %s: a %s asteroid hit the plateau at %d,%d and fortunately missed your Rover. The plateau has been cleaned up and you're free to continue. Your score is %d%n",
                        user.getName().toUpperCase(), asteroid.getSize(), asteroid.getPosition().getX(), asteroid.getPosition().getY(), user.getScore());
            }
        } while (!user.moveTheRoverAgain());

        System.out.printf("Thank you %s for playing. You scored %d%n", user.getName(), user.getScore());
    }

    /*tested*/
    public String[][] generateLiveGamePlateau() {
        String[][] gamePlateau = new String[plateau.rows() + 1][plateau.columns() + 1];

        for (int i = 0; i <= plateau.rows(); i++) { // i relates to y value
            for (int j = 0; j <= plateau.columns(); j++) { // j relates to x value
                if (user.getRover().getPosition() != null && asteroid.getPosition() != null &&
                        j == user.getRover().getPosition().getX() &&
                        i == user.getRover().getPosition().getY() &&
                        j == asteroid.getPosition().getX() &&
                        i == asteroid.getPosition().getY()) {

                    gamePlateau[i][j] = " ❌";

                } else if (user.getRover().getPosition() != null && j == user.getRover().getPosition().getX() && i == user.getRover().getPosition().getY()) {
                    switch (user.getRover().getPosition().getFacing()) {
                        case Direction.NORTH -> gamePlateau[i][j] = " △ ";
                        case Direction.EAST -> gamePlateau[i][j] = " ▷ ";
                        case Direction.SOUTH -> gamePlateau[i][j] = " ▽ ";
                        case Direction.WEST -> gamePlateau[i][j] = " ◁ ";
                    }
                } else if (asteroid.getPosition() != null && j == asteroid.getPosition().getX() && i == asteroid.getPosition().getY()) {
                    gamePlateau[i][j] = " ☄ ";
                } else {
                    gamePlateau[i][j] = " ◦ ";
                }
            }
        }
        return gamePlateau;
    }

    public void printPlateauOut(String[][] plateauArray) {
        for (int y = plateau.rows(); y >= 0; y--) {
            for (int x = 0; x <= plateau.columns(); x++) {
                if (x == plateau.columns()) {
                    System.out.print(" " + plateauArray[y][x] + " ");
                    System.out.println();
                } else {
                    System.out.print(" " + plateauArray[y][x] + " ");
                }
            }
        }
        System.out.println();

    }

    /*tested*/
    public boolean didAsteroidHitRover() {
        if (asteroid.getPosition() == null) {
            System.out.println("Asteroid position is null");
            return false;
        } else if (user.getRover().getPosition() == null) {
            System.out.println("Rover position is null");
            return false;
        } else {
            return user.getRover().getPosition().getX() == asteroid.getPosition().getX() &&
                    user.getRover().getPosition().getY() == asteroid.getPosition().getY();
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

