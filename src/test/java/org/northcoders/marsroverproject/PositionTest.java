package org.northcoders.marsroverproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("(1) Method being tested = changePositionOnPlateau()")
    void testThatTheChangePositionOnPlateauMethodFollowsValidInstructionsAndUpdatesTheXYAndFacingFieldsForThePosition() {
        // Arrange 1
        char[] testMoveInstructions1 = {'L','M','R','M','L'};
        PlateauSize testPlateau = new PlateauSize(5,5);
        Position testPosition = new Position(2,2,Direction.NORTH);
        // Act 1
        testPosition.changePositionOnPlateau(testMoveInstructions1, testPlateau);
        // Assert 1
        Assertions.assertEquals(new Position(1,3,Direction.WEST).toString(),
                testPosition.toString());

        // Arrange 2
        char[] testMoveInstructions2 = {'M','M','M','R'};
        testPlateau = new PlateauSize(5,5);
        testPosition = new Position(1,5,Direction.EAST);
        // Act 2
        testPosition.changePositionOnPlateau(testMoveInstructions2, testPlateau);
        // Assert 2
        Assertions.assertEquals(new Position(4,5,Direction.SOUTH).toString(),
                testPosition.toString());

        // Arrange 3
        char[] testMoveInstructions3 = {'M','M','R', 'R', 'M'};
        testPlateau = new PlateauSize(5,5);
        testPosition = new Position(4,1,Direction.WEST);
        // Act 3
        testPosition.changePositionOnPlateau(testMoveInstructions3, testPlateau);
        // Assert 3
        Assertions.assertEquals(new Position(3,1,Direction.EAST).toString(),
                testPosition.toString());

        // Arrange 4
        char[] testMoveInstructions4 = {'L','M','L','M','M','M'};
        testPlateau = new PlateauSize(5,5);
        testPosition = new Position(0,0,Direction.SOUTH);
        // Act 4
        testPosition.changePositionOnPlateau(testMoveInstructions4, testPlateau);
        // Assert 4
        Assertions.assertEquals(new Position(1,3,Direction.NORTH).toString(),
                testPosition.toString());
    }

    @Test
    @DisplayName("(2) Method being tested = changePositionOnPlateau()")
    void testThatTheChangePositionOnPlateauMethodFollowsValidInstructionsAndUpdatesTheXYAndFacingFieldsForThePositionButRemainsWithinThePlateau() {
        // Arrange 1
        char [] testMoveInstructions1 = {'M','M','M','M','M','R'};
        PlateauSize testPlateau = new PlateauSize(5,5);
        Position testPosition = new Position(1,5,Direction.EAST);
        // Act 1
        testPosition.changePositionOnPlateau(testMoveInstructions1, testPlateau);
        // Assert 1
        Assertions.assertEquals(new Position(5,5,Direction.SOUTH).toString(),
                testPosition.toString());

        // Arrange 2
        char[] testMoveInstructions2 = {'M','M','M','M','M','R'};
        testPlateau = new PlateauSize(5,5);
        testPosition = new Position(3,2,Direction.SOUTH);
        // Act 2
        testPosition.changePositionOnPlateau(testMoveInstructions2, testPlateau);
        // Assert 2
        Assertions.assertEquals(new Position(3,0,Direction.WEST).toString(),
                testPosition.toString());

        // Arrange 3
        char[] testMoveInstructions3 = {'L','M','M','M','R'};
        testPlateau = new PlateauSize(5,5);
        testPosition = new Position(2,3,Direction.NORTH);
        // Act 3
        testPosition.changePositionOnPlateau(testMoveInstructions3, testPlateau);
        // Assert 3
        Assertions.assertEquals(new Position(0,3,Direction.NORTH).toString(),
                testPosition.toString());

        // Arrange 4
        char[] testMoveInstructions4 = {'L','M','R', 'M'};
        testPlateau = new PlateauSize(5,5);
        testPosition = new Position(0,5,Direction.WEST);
        // Act 4
        testPosition.changePositionOnPlateau(testMoveInstructions4, testPlateau);
        // Assert 4
        Assertions.assertEquals(new Position(0,4,Direction.WEST).toString(),
                testPosition.toString());
    }

    @Test
    @DisplayName("(3) Method being tested = changePositionOnPlateau()")
    void testThatTheChangePositionOnPlateauMethodDoesNotChangePositionIfInstructionsAreNotValid() {
        // Arrange 1
        char[] testMoveInstructions = {'l','T','H','N','m','r','A'};
        PlateauSize testPlateau = new PlateauSize(5,5);
        Position testPosition = new Position(2,2,Direction.NORTH);
        // Act 1
        testPosition.changePositionOnPlateau(testMoveInstructions, testPlateau);
        // Assert 1
        Assertions.assertEquals(new Position(2,2,Direction.NORTH).toString(),
                testPosition.toString());
    }

    @Test
    @DisplayName("(4) Method being tested = changePositionOnPlateau()")
    void testThatTheChangePositionOnPlateauMethodDoesNotChangePositionIfInstructionsAreNull() {
        // Arrange 1
        char[] nullTestMoveInstructions = null;
        PlateauSize testPlateau = new PlateauSize(5,5);
        Position testPosition = new Position(2,2,Direction.NORTH);
        // Act 1
        testPosition.changePositionOnPlateau(nullTestMoveInstructions, testPlateau);
        // Assert 1
        Assertions.assertEquals(new Position(2,2,Direction.NORTH).toString(),
                testPosition.toString());
    }

    @Test
    @DisplayName("(5) Method being tested = changePositionOnPlateau()")
    void testThatTheChangePositionOnPlateauMethodDoesNotChangePositionIfPlateauSizeIsNull() {
        // Arrange 1
        char[] testMoveInstructions1 = {'l','T','H','N','m','r','A'};
        Position testPosition = new Position(2,2,Direction.NORTH);
        // Act 1
        testPosition.changePositionOnPlateau(testMoveInstructions1, null);
        // Assert 1
        Assertions.assertEquals(new Position(2,2,Direction.NORTH).toString(),
                testPosition.toString());
    }



}