package org.northcoders.marsroverproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User("Sam", new Scanner(System.in));
        Game game = new Game(user);
        game.playGame();
    }

}
