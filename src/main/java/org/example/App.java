package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileW fileWriter = new FileW();
        try (InputStream input = new FileInputStream("C:/CityGame/game.properties")) {
            prop.load(input);
        } catch (IOException e) {
            System.out.println("Can't find properties");
            throw new RuntimeException(e);
        }
        System.out.println("Welcome to the game of the Cities");
        Scanner scanner = new Scanner(System.in);
        Player firstPlayer = new Player(scanner, prop);
        fileWriter.setFirstPlayerName(firstPlayer.getName());
        System.out.println("Hello first player! Your name is: " + firstPlayer.getName());
        Player secondPlayer = new Player(scanner, prop);
        fileWriter.setSecondPlayerName(secondPlayer.getName());
        System.out.println("Hello second player! Your name is: " + secondPlayer.getName());
        Player[] players = {firstPlayer, secondPlayer};
        try {
            ProcessGame.process(scanner, players, prop, fileWriter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        fileWriter.saveGameResults();
    }
}
