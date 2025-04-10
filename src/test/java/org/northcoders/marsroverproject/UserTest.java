package org.northcoders.marsroverproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Scanner;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserTest {
    @Mock
    Scanner mockScanner;
    @InjectMocks
    User testUser;

    @Test
    @DisplayName("(1) Method being tested = specifyPlateauSize() -> also indirectly testing specifyPlateauBoundaries()")
    void testThatTheSpecifyPlateauSizeFromUserMethodReturnsAPlateauSize3X3WhenUserEnters3ForRowsAndColumns() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.nextLine()).thenReturn("3").thenReturn("3");
        // Act and Assert 1
        Assertions.assertEquals(new PlateauSize(3,3).toString(),
                testUser.specifyPlateauSize().toString());
    }
    @Test
    @DisplayName("(2) Method being tested = specifyPlateauSize() -> also indirectly testing specifyPlateauBoundaries()")
    void testThatTheSpecifyPlateauSizeFromUserMethodReturnsAPlateauSize5X5WhenUserFirstEntersNonPositiveIntegersForRowsAndColumnsAndThenEnters5ForBoth() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.nextLine()).thenReturn("a").thenReturn("5").thenReturn("-122").thenReturn("5");
        // Act and Assert 1
        Assertions.assertEquals(new PlateauSize(5,5).toString(),
                testUser.specifyPlateauSize().toString());
    }
    @Test
    @DisplayName("(1) Method being tested = moveTheRoverAgain()")
    void testThatTheMoveTheRoverAgainMethodReturnsFalseWhenUserEntersQIgnoreCaseAsFirstCharacter() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.next()).thenReturn("q");
        // Act and Assert 1
        Assertions.assertFalse(testUser.moveTheRoverAgain());

        // Arrange 2 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.next()).thenReturn("Q");
        // Act and Assert 2
        Assertions.assertFalse(testUser.moveTheRoverAgain());

        // Arrange 3 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.next()).thenReturn("quit");
        // Act and Assert 3
        Assertions.assertFalse(testUser.moveTheRoverAgain());

        // Arrange 4 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.next()).thenReturn("Quit");
        // Act and Assert 4
        Assertions.assertFalse(testUser.moveTheRoverAgain());
    }
    @Test
    @DisplayName("(2) Method being tested = moveTheRoverAgain()")
    void testThatTheMoveTheRoverAgainMethodReturnsTrueWhenUserEntersAnyOtherCharacterThanQ() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.next()).thenReturn("@");
        // Act and Assert 1
        Assertions.assertTrue(testUser.moveTheRoverAgain());

        // Arrange 2 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.next()).thenReturn("adasdcdsa");
        // Act and Assert 2
        Assertions.assertTrue(testUser.moveTheRoverAgain());

        // Arrange 3 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.next()).thenReturn("1234");
        // Act and Assert 3
        Assertions.assertTrue(testUser.moveTheRoverAgain());

        // Arrange 4 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.next()).thenReturn("-77");
        // Act and Assert 4
        Assertions.assertTrue(testUser.moveTheRoverAgain());
    }
    @Test
    @DisplayName("(1) Method being tested = supplyMovementInstructionsForTheRover()")
    void testThatTheSupplyMovementInstructionsForTheRoverMethodOnlyAcceptsValidInstructionsFromUserAndReturnsThemAsACharArray() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        when(mockScanner.next()).thenReturn("@dfmr").thenReturn("23244").thenReturn("mmRRLmmm");
        // Act and Assert 1
        Assertions.assertEquals(Arrays.toString(new char[]{'M', 'M', 'R', 'R', 'L', 'M', 'M', 'M'}),
                Arrays.toString(testUser.supplyMovementInstructionsForTheRover()));
    }
    @Test
    @DisplayName("(1) Method being tested = chooseAValidStartingPositionForRoverOnPlateau()")
    void testThatTheChooseAValidStartingPositionForRoverOnPlateauAcceptsAPositionWithinTheTestPlateauAndKeepsAskingTheUserTillTheyEnterAValidPosition() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        PlateauSize testPlateau = new PlateauSize(7,7);

        when(mockScanner.nextLine())
                .thenReturn("null")
                .thenReturn("fkghb7865@njn")
                .thenReturn("10")
                .thenReturn("-1")
                .thenReturn("5");

        when(mockScanner.next())
                .thenReturn("null")
                .thenReturn("down")
                .thenReturn("up")
                .thenReturn("left")
                .thenReturn("right")
                .thenReturn("1235156")
                .thenReturn("@£$%")
                .thenReturn("East")
                .thenReturn("E");
        // Act and Assert 1
        Assertions.assertEquals(new Position(5, 5, Direction.EAST).toString(),
                testUser.chooseAValidStartingPositionForRoverOnPlateau(testPlateau).toString());

    }
    @Test
    @DisplayName("(1) Method being tested = chooseAValidStartingPositionForRoverOnPlateau()")
    void testThatTheChooseAValidStartingPositionForRoverOnPlateauReturnsNullWhenThePassedPlateauSizeIsNull() {
        // Arrange, Act and Assert
        Assertions.assertNull(testUser.chooseAValidStartingPositionForRoverOnPlateau(null));
    }

}