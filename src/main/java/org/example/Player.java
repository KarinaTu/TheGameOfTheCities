package org.example;

import java.util.Properties;
import java.util.Scanner;

public class Player {
    private String name;
    private int mistakeInCityNameFormatCounter = 0;
    private int cityMismatchCounter = 0;
    private int alreadyExistingCityCounter = 0;

    public Player(Scanner scanner, Properties properties) {
        boolean isPlayerNameCorrect = false;
        while (!isPlayerNameCorrect) {
            System.out.println("Please enter the name of the player");
            this.name = scanner.nextLine();
            if (this.name.length() < Integer.parseInt(properties.getProperty("playerName.minLength")) || this.name.length() > Integer.parseInt(properties.getProperty("playerName.maxLength"))) {
                System.out.println("Your name must contain min 2 and max 12 elements");
            } else if (!this.name.matches("^[a-zA-Z]*$")) {
                System.out.println("Your name must contain only letters");
            } else {
                isPlayerNameCorrect = true;
            }
        }
    }

    public String getName() {
        return name;
    }
    public void setCityMismatchCounter() throws Exception {
        cityMismatchCounter++;
        this.isPlayerFailed();
    }
    public void setAlreadyExistingCityCounter() throws Exception {
        alreadyExistingCityCounter++;
        this.isPlayerFailed();
    }
    public void setMistakeInCityNameFormatCounter() throws Exception {
        mistakeInCityNameFormatCounter++;
        this.isPlayerFailed();
    }
    private void isPlayerFailed() throws Exception {
        if ((cityMismatchCounter + alreadyExistingCityCounter) >= 3) {
            throw new Exception("Game over for " + name + ". Over 3 tries. You entered city " + cityMismatchCounter + " times with the wrong first letter and tried " + alreadyExistingCityCounter + " times to add already existing city.");
        } else if (mistakeInCityNameFormatCounter >= 5) {
            throw new Exception("Game over for " + name + ". Over 5 mistakes in the city name.");
        }
    }
}
