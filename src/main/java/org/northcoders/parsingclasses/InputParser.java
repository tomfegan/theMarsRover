package org.northcoders.parsingclasses;

import org.northcoders.marsroverproject.Position;

import java.util.Scanner;

public class InputParser { // This could become separate classes for each parse operation - this package is a  critical part of my Input Layer

    // musings: is this an adaptor/wrapper design pattern?

    /* more musings: should I use nested arrays for the plateau? For example, if user inputs 5 5:
           int[][][] plateau =
           {
                    { {0,5} , {1,5} , {2,5} , {3,5} , {4,5} , {5,5} } ,

                    { {0,4} , {1,4} , {2,4} , {3,4} , {4,5} , {5,5} } ,

                    { {0,3} , {1,3} , {2,3} , {3,3} , {4,3} , {5,3} } ,

                    { {0,2} , {1,2} , {2,2} , {3,2} , {4,2} , {5,2} } ,

                    { {0,1} , {1,1} , {2,1} , {3,1} , {4,1} , {5,1} } ,

                    { {0,0} , {1,0} , {2,0} , {3,0} , {4,0} , {5,0} }
            };   */

//    List<Integer> plateauGrid = new ArrayList<>();
//
//    for (int i = 0; i <= 5; i++) {
//        for (int j = 0; j <=5; j++) {
//            plateauGrid.add();
//        }
//    }

    private Scanner plateauInput;
    private Scanner startingPositionInput;
    private Scanner instructionsInput;

    public int[] parsePlateauSize(Scanner plateauInput) {
        // Should this method take the first user input as an argument and output the x and y co-ordinates in an int array?
        // I need to consider if re-sizing will be needed and therefore whether to use an ArrayList<Integer?


        return new int[]{-1,-1}; // temporary return
    }

    public Position parseStartingPosition(Scanner startingPositionInput) {
        // Should this method take the second user input as an argument and output a Position object?
        // Second input will be 5 5 N ->
        //                              I need to extract each character, convert the first 2 into ints and
        //                              check the third matches the enum CompassDirection
        // Do I need to parse the String input   the x and y co-ordinates in an int array?

        return new Position(); // temporary return
    }

    public Position parseInstructionInput(Scanner instructionsInput) {
        // Should this method take the third user input as an argument and output a new Position object with the position after the move?
        return new Position();
    }


}
