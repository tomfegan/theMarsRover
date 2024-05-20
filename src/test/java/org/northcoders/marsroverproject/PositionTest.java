package org.northcoders.marsroverproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    void changePositionOnGrid() {
//        Position testPosition = new Position(0,0,"N");
//        assertEquals(new Position(1, 0, "E"), testPosition.changePositionOnGrid(new char[]{'r', 'M'},
//                         new PlateauSize(2,2)));

        assertAll(() -> Position testPosition1 = new Position(0, 0, "N");

                () -> assertEquals(1, testPosition1.changePositionOnGrid(new char[]{'r', 'M'},
                        new PlateauSize(2, 2)).getX()); // 1,0,E

//                    Position testPosition2 = new Position(0, 0, "N");
        () -> assertEquals(0, testPosition1.changePositionOnGrid(new char[]{'r', 'M'},
                new PlateauSize(2, 2)).getY()); // 1,0,E

//                    Position testPosition3 = new Position(0, 0, "N");
        () -> assertEquals("E", testPosition1.changePositionOnGrid(new char[]{'r', 'M'},
                new PlateauSize(2, 2)).getFacing()); // 1,0,E

                );
//        Position testPosition2 = new Position(0,0,"N");
//        assertEquals(new Position(1, 0, "E"), testPosition1.changePositionOnGrid(new char[]{'r', 'M'},
//                new PlateauSize(2,2)));
//
//        Position testPosition3 = new Position(0,0,"N");
//        assertEquals(new Position(1, 0, "E"), testPosition1.changePositionOnGrid(new char[]{'r', 'M'},
//                new PlateauSize(2,2)));

    }

}