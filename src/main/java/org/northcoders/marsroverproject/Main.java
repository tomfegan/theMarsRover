package org.northcoders.marsroverproject;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.print("Enter number of rows: ");
        Scanner userInput = new Scanner(System.in);
        int rows = userInput.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = userInput.nextInt();
        userInput.close();

//        int rows = 2;
//        int columns = 2;
        List<List<List<Integer>>> gridOfCoordinates = new ArrayList<>();

        for (int y = rows; y >= 0; y--) {
            List<List<Integer>> rowOfCoordinates = new ArrayList<>();
            for (int x = 0; x <= columns; x++) {
                List<Integer> singleCoordinate = new ArrayList<>();
                singleCoordinate.add(x);
                singleCoordinate.add(y);
                rowOfCoordinates.add(singleCoordinate);
//                System.out.println("Loop " + x + " outputs" + rowOfCoordinates);
            }
//            gridOfCoordinates.add(rowOfCoordinates);
//            System.out.println("one run of loop complete");
            gridOfCoordinates.add(rowOfCoordinates);

        }
//        gridOfCoordinates.add(rowOfCoordinates);
        System.out.println(gridOfCoordinates);
    }
}
// [
//
// [ [0, 1], [1, 1] ],
// [ [0, 0], [1, 0]]
//
// ]


//    }
//
//
//}