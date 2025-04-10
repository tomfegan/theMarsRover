package org.northcoders.marsroverproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsteroidTest {

    @Mock
    Random mockedRandom;

    @InjectMocks
    Asteroid testAsteroid = new Asteroid(AsteroidSize.MEDIUM);

    @Test
    @DisplayName("(1) Method being tested = assignRandomPositionWithinPlateauForAsteroid")
    void testThatTheAssignRandomPositionWithinPlateauForAsteroidMethodSetsARandomPositionForAsteroidInstance() {
        // Arrange 1 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        PlateauSize testPlateau = new PlateauSize(3,3);
        when(mockedRandom.nextInt(4)).thenReturn(2).thenReturn(1);
        // Act 1
        testAsteroid.assignRandomPositionWithinPlateauForAsteroid(testPlateau);
        // Assert 1
        Assertions.assertEquals(new Position(2,1).toString(), testAsteroid.getPosition().toString());

        // Arrange 2 - @ExtendWith(MockitoExtension.class), @Mock and @InjectMocks
        testPlateau = new PlateauSize(0,0);
        when(mockedRandom.nextInt(1)).thenReturn(0).thenReturn(1);
        // Act 2
        testAsteroid.assignRandomPositionWithinPlateauForAsteroid(testPlateau);
        // Assert 2
        Assertions.assertEquals(new Position(0,1).toString(), testAsteroid.getPosition().toString());
    }
}