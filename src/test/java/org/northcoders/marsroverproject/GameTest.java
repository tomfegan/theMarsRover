package org.northcoders.marsroverproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {
    @Mock
    Random mockedRandom;
    @Mock
    Scanner mockScanner;

    @InjectMocks
    Asteroid testAsteroid = new Asteroid(AsteroidSize.MEDIUM);
    @InjectMocks
    User testUser;

    @Test
    @DisplayName("(1) Method being tested = didAsteroidHitRover()")
    void testThatTheDidAsteroidHitRoverMethodReturnsTrueWhenTheRoverAndAsteroidShareTheSameXYPosition() {
        Game testGame = new Game(testUser);
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(0,0,Direction.NORTH));
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(0,0));
        // Act and Assert 1
        Assertions.assertTrue(testGame.didAsteroidHitRover());

        // Arrange 2 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(3,1,Direction.NORTH));
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(3,1));
        // Act and Assert 2
        Assertions.assertTrue(testGame.didAsteroidHitRover());

        // Arrange 3 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(7,-1,Direction.NORTH));
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(7,-1));
        // Act and Assert 3
        Assertions.assertTrue(testGame.didAsteroidHitRover());
    }

    @Test
    @DisplayName("(2) Method being tested = didAsteroidHitRover()")
    void testThatTheDidAsteroidHitRoverMethodReturnsFalseWhenTheRoverAndAsteroidHaveDifferentXYPositions() {
        Game testGame = new Game(testUser);

        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(3,1,Direction.NORTH));
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(3,2));
        // Act and Assert 1
        Assertions.assertFalse(testGame.didAsteroidHitRover());

        // Arrange 2 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(7,7,Direction.NORTH));
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(7,6));
        // Act and Assert 2
        Assertions.assertFalse(testGame.didAsteroidHitRover());

        // Arrange 3 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(0,0,Direction.NORTH));
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(4,0));
        // Act and Assert 3
        Assertions.assertFalse(testGame.didAsteroidHitRover());
    }

    @Test
    @DisplayName("(3) Method being tested = didAsteroidHitRover()")
    void testThatTheDidAsteroidHitRoverMethodReturnsFalseWhenTheAsteroidPositionIsNull() {
        /* The Asteroid position is null in this test because the constructor does not
        initialise it and setPosition() has not been called */

        // Arrange - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        testUser.getRover().setPosition(new Position(7,7,Direction.NORTH));
        testGame.addAsteroidToList(testAsteroid); // add an asteroid--no position--so the asteroid list is not empty
        // Act and Assert
        Assertions.assertFalse(testGame.didAsteroidHitRover());
    }

    @Test
    @DisplayName("(4) Method being tested = didAsteroidHitRover()")
    void testThatTheDidAsteroidHitRoverMethodReturnsFalseWhenTheRoverPositionIsNull() {
        // Arrange - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        testUser.getRover().setPosition(null);
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(3,2));
        // Act and Assert
        Assertions.assertFalse(testGame.didAsteroidHitRover());
    }

    @Test
    @DisplayName("(5) Method being tested = didAsteroidHitRover()")
    void testThatTheDidAsteroidHitRoverMethodReturnsFalseWhenTheAsteroidListIsEmpty() {
        // Arrange - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        testUser.getRover().setPosition(new Position(7,7,Direction.NORTH));
        // Act and Assert
        Assertions.assertFalse(testGame.didAsteroidHitRover());
    }

    @Test
    @DisplayName("(1) Method being tested = generateLiveGamePlateau()")
    void testThatThePlateauReturnedByTheGenerateLiveGamePlateauMethodDoesNotContainAnAsteroidIfItsPositionIsNull() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        when(mockScanner.nextLine()).thenReturn("3").thenReturn("4");
        testGame.setPlateau(testUser.specifyPlateauSize());
        testUser.getRover().setPosition(new Position(1,2,Direction.NORTH));
        // Act 1
        String[][] result = testGame.generateLiveGamePlateau();
        boolean doesPlateauContainAsteroid = false;
        for (String[] strings : result) {
            for (String string : strings) {
                if (Objects.equals(string, " ☄ ") ||
                        Objects.equals(string, " ❌")) {
                    doesPlateauContainAsteroid = true;
                    break;
                }
            }
        }
        // Assert 1
        Assertions.assertFalse(doesPlateauContainAsteroid);
    }

    @Test
    @DisplayName("(2) Method being tested = generateLiveGamePlateau()")
    void testThatThePlateauReturnedByTheGenerateLiveGamePlateauMethodDoesNotContainARoverIfItsPositionIsNull() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        when(mockScanner.nextLine()).thenReturn("3").thenReturn("4");
        testGame.setPlateau(testUser.specifyPlateauSize());
        testUser.getRover().setPosition(null);
        // Act 1
        String[][] result = testGame.generateLiveGamePlateau();
        boolean doesPlateauContainRover = false;
        for (String[] strings : result) {
            for (String string : strings) {
                if (Objects.equals(string, " △ ") ||
                        Objects.equals(string, " ▷ ") ||
                        Objects.equals(string, " ▽ ") ||
                        Objects.equals(string, " ◁ ")) {
                    doesPlateauContainRover = true;
                    break;
                }
            }
        }
        // Assert 1
        Assertions.assertFalse(doesPlateauContainRover);
    }

    @Test
    @DisplayName("(3) Method being tested = generateLiveGamePlateau()")
    void testThatTheGenerateLiveGamePlateauMethodReturnsRedCrossWhenRoverAndAsteroidShareTheSamePositionOnThePlateau() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        when(mockScanner.nextLine()).thenReturn("3").thenReturn("4");
        testGame.setPlateau(testUser.specifyPlateauSize());
        testUser.getRover().setPosition(new Position(1,2,Direction.NORTH));
        testAsteroid.setPosition(new Position(1,2));
        testGame.addAsteroidToList(testAsteroid);
        // Act 1
        String[][] result = testGame.generateLiveGamePlateau();
        // Assert 1
        Assertions.assertEquals(" ❌", result[2][1]);
    }

    @Test
    @DisplayName("(4) Method being tested = generateLiveGamePlateau()")
    void testThatTheGenerateLiveGamePlateauMethodReturnsAnAsteroidAndAnUpArrowWhenRoverAndAsteroidOccupyDifferentPositionsOnThePlateauAndRoverIsFacingNorth() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        when(mockScanner.nextLine()).thenReturn("5").thenReturn("4");
        testGame.setPlateau(testUser.specifyPlateauSize());
        testUser.getRover().setPosition(new Position(3,0,Direction.NORTH));
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(0,4));
        // Act 1
        String[][] result = testGame.generateLiveGamePlateau();
        // Assert 1
        Assertions.assertEquals(" △ ", result[0][3]);
        Assertions.assertEquals(" ☄ ", result[4][0]);
    }

    @Test
    @DisplayName("(5) Method being tested = generateLiveGamePlateau()")
    void testThatTheGenerateLiveGamePlateauMethodReturnsAnAsteroidAndADownArrowWhenRoverAndAsteroidOccupyDifferentPositionsOnThePlateauAndRoverIsFacingSouth() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        when(mockScanner.nextLine()).thenReturn("5").thenReturn("4");
        testGame.setPlateau(testUser.specifyPlateauSize());
        testUser.getRover().setPosition(new Position(1,4,Direction.SOUTH));
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(3,0));
        // Act 1
        String[][] result = testGame.generateLiveGamePlateau();
        // Assert 1
        Assertions.assertEquals(" ▽ ", result[4][1]);
        Assertions.assertEquals(" ☄ ", result[0][3]);
    }

    @Test
    @DisplayName("(6) Method being tested = generateLiveGamePlateau()")
    void testThatTheGenerateLiveGamePlateauMethodReturnsAnAsteroidAndALeftArrowWhenRoverAndAsteroidOccupyDifferentPositionsOnThePlateauAndRoverIsFacingWest() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        when(mockScanner.nextLine()).thenReturn("8").thenReturn("4"); // 8 = rows (y) and 4 = columns (x)
        testGame.setPlateau(testUser.specifyPlateauSize());
        testUser.getRover().setPosition(new Position(4,8,Direction.WEST));
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(0,8));
        // Act 1
        String[][] result = testGame.generateLiveGamePlateau();
        // Assert 1
        Assertions.assertEquals(" ◁ ", result[8][4]);
        Assertions.assertEquals(" ☄ ", result[8][0]);
    }

    @Test
    @DisplayName("(7) Method being tested = generateLiveGamePlateau()")
    void testThatTheGenerateLiveGamePlateauMethodReturnsAnAsteroidAndARightArrowWhenRoverAndAsteroidOccupyDifferentPositionsOnThePlateauAndRoverIsFacingEast() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        when(mockScanner.nextLine()).thenReturn("3").thenReturn("6"); // 3 = rows (y) and 6 = columns (x)
        testGame.setPlateau(testUser.specifyPlateauSize());
        testUser.getRover().setPosition(new Position(6,3,Direction.EAST));
        testGame.addAsteroidToList(testAsteroid);
        testAsteroid.setPosition(new Position(2,3));
        // Act 1
        String[][] result = testGame.generateLiveGamePlateau();
        // Assert 1
        Assertions.assertEquals(" ▷ ", result[3][6]);
        Assertions.assertEquals(" ☄ ", result[3][2]);
    }

    @Test
    @DisplayName("(8) Method being tested = generateLiveGamePlateau()")
    void testThatThePlateauReturnedByTheGenerateLiveGamePlateauMethodOnlyContainsXWhenAsteroidSizeIsPlanetDestroyer() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        when(mockScanner.nextLine()).thenReturn("3").thenReturn("4");
        testGame.setPlateau(testUser.specifyPlateauSize());
        testUser.getRover().setPosition(new Position(1,2,Direction.NORTH));

        Asteroid testPlanetDestroyer = new Asteroid(AsteroidSize.PLANET_DESTROYER);
        testGame.addAsteroidToList(testPlanetDestroyer);
        // Act 1
        String[][] result = testGame.generateLiveGamePlateau();
        boolean doesPlateauOnlyContainCrosses = false;

        for (String[] strings : result) {
            for (String string : strings) {
                if (Objects.equals(string, " ❌")) {
                    doesPlateauOnlyContainCrosses = true;
                } else {
                    doesPlateauOnlyContainCrosses = false;
                    break;
                }
            }
        }
        // Assert 1
        Assertions.assertTrue(doesPlateauOnlyContainCrosses);
    }

    @Test
    @DisplayName("(9) Method being tested = generateLiveGamePlateau()")
    void testThatThePlateauReturnedByTheGenerateLiveGamePlateauMethodDoesNotOnlyContainXsWhenAsteroidSizeIsNotPlanetDestroyer() {
        // Arrange - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        Game testGame = new Game(testUser);
        when(mockScanner.nextLine()).thenReturn("3").thenReturn("4");
        testGame.setPlateau(testUser.specifyPlateauSize());
        testUser.getRover().setPosition(new Position(1,2,Direction.NORTH));

        // Arrange 1 - small asteroid
        Asteroid testSmallAsteroid = new Asteroid(AsteroidSize.SMALL);
        testGame.addAsteroidToList(testSmallAsteroid);
        // Act 1 - small asteroid
        String[][] resultForSmallAsteroid = testGame.generateLiveGamePlateau();
        boolean doesPlateauOnlyContainCrossesWhenAsteroidIsSmall = false;
        for (String[] strings : resultForSmallAsteroid) {
            for (String string : strings) {
                if (Objects.equals(string, " ❌")) {
                    doesPlateauOnlyContainCrossesWhenAsteroidIsSmall = true;
                } else {
                    doesPlateauOnlyContainCrossesWhenAsteroidIsSmall = false;
                    break;
                }
            }
        }
        // Assert 1 - small asteroid
        Assertions.assertFalse(doesPlateauOnlyContainCrossesWhenAsteroidIsSmall);


        // Arrange 2 - medium asteroid
        testGame.addAsteroidToList(testAsteroid);
        // Act 2 - medium asteroid
        String[][] resultForMediumAsteroid = testGame.generateLiveGamePlateau();
        boolean doesPlateauOnlyContainCrossesWhenAsteroidIsMedium = false;
        for (String[] strings : resultForMediumAsteroid) {
            for (String string : strings) {
                if (Objects.equals(string, " ❌")) {
                    doesPlateauOnlyContainCrossesWhenAsteroidIsMedium = true;
                } else {
                    doesPlateauOnlyContainCrossesWhenAsteroidIsMedium = false;
                    break;
                }
            }
        }
        // Assert 2 - medium asteroid
        Assertions.assertFalse(doesPlateauOnlyContainCrossesWhenAsteroidIsMedium);


        // Arrange 3 - large asteroid
        Asteroid testLargeAsteroid = new Asteroid(AsteroidSize.LARGE);
        testGame.addAsteroidToList(testLargeAsteroid);
        // Act 3 - large asteroid
        String[][] resultForLargeAsteroid = testGame.generateLiveGamePlateau();
        boolean doesPlateauOnlyContainCrossesWhenAsteroidIsLarge = false;
        for (String[] strings : resultForLargeAsteroid) {
            for (String string : strings) {
                if (Objects.equals(string, " ❌")) {
                    doesPlateauOnlyContainCrossesWhenAsteroidIsLarge = true;
                } else {
                    doesPlateauOnlyContainCrossesWhenAsteroidIsLarge = false;
                    break;
                }
            }
        }
        // Assert 3 - large asteroid
        Assertions.assertFalse(doesPlateauOnlyContainCrossesWhenAsteroidIsLarge);
    }

    @Test
    @DisplayName("(1) Method being tested = isRoverOnBoundary()")
    void testThatTheIsRoverOnBoundaryMethodReturnsFalseWhenTheRoverPositionIsNull() {
        Game testGame = new Game(testUser);
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(null);
        when(mockScanner.nextLine()).thenReturn("2").thenReturn("3");
        testGame.setPlateau(testUser.specifyPlateauSize());
        // Act and Assert 1
        Assertions.assertFalse(testGame.isRoverOnBoundary());
    }

    @Test
    @DisplayName("(2) Method being tested = isRoverOnBoundary()")
    void testThatTheIsRoverOnBoundaryMethodReturnsFalseWhenThePlateauSizeIsNull() {
        Game testGame = new Game(testUser);
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(0,0,Direction.NORTH));
        testGame.setPlateau(null);
        // Act and Assert 1
        Assertions.assertFalse(testGame.isRoverOnBoundary());
    }

    @Test
    @DisplayName("(3) Method being tested = isRoverOnBoundary()")
    void testThatTheIsRoverOnBoundaryMethodReturnsFalseWhenTheRoverIsNotPositionedOnThePlateauPerimeter() {
        Game testGame = new Game(testUser);
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(1,1,Direction.NORTH));

        when(mockScanner.nextLine()).thenReturn("2");
        testGame.setPlateau(testUser.specifyPlateauSize());
        // Act and Assert 1
        Assertions.assertFalse(testGame.isRoverOnBoundary());
    }

    @Test
    @DisplayName("(4) Method being tested = isRoverOnBoundary()")
    void testThatTheIsRoverOnBoundaryMethodReturnsTrueWhenTheRoverIsPositionedOnThePlateauPerimeter() {
        Game testGame = new Game(testUser);
        when(mockScanner.nextLine()).thenReturn("2");
        testGame.setPlateau(testUser.specifyPlateauSize());

        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(0,0,Direction.NORTH));
        // Act and Assert 1
        Assertions.assertTrue(testGame.isRoverOnBoundary());

        // Arrange 2 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(0,1,Direction.NORTH));
        // Act and Assert 2
        Assertions.assertTrue(testGame.isRoverOnBoundary());

        // Arrange 3 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(0,2,Direction.NORTH));
        // Act and Assert 3
        Assertions.assertTrue(testGame.isRoverOnBoundary());

        // Arrange 4 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(1,0,Direction.NORTH));
        // Act and Assert 4
        Assertions.assertTrue(testGame.isRoverOnBoundary());

        // Arrange 5 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(1,2,Direction.NORTH));
        // Act and Assert 5
        Assertions.assertTrue(testGame.isRoverOnBoundary());

        // Arrange 6 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(2,0,Direction.NORTH));
        // Act and Assert 6
        Assertions.assertTrue(testGame.isRoverOnBoundary());

        // Arrange 7 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(2,1,Direction.NORTH));
        // Act and Assert 7
        Assertions.assertTrue(testGame.isRoverOnBoundary());

        // Arrange 7 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testUser.getRover().setPosition(new Position(2,2,Direction.NORTH));
        // Act and Assert 7
        Assertions.assertTrue(testGame.isRoverOnBoundary());
    }

}