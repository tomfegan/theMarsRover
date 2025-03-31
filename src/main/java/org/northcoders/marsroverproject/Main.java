package org.northcoders.marsroverproject;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User("Sam", new Scanner(System.in));
        Asteroid asteroid = new Asteroid(new Random());
        Game game = new Game(user, asteroid);
        game.playGame();
    }

}
