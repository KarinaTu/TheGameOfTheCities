package org.example;

import org.jetbrains.annotations.NotNull;
import java.util.*;

public class ProcessGame {
    public static void process(Scanner scanner, Player[] players, Properties properties, FileW fileWriter) throws Exception {
        int currentPlayerIndex = getRandomIndex(players);
        Set<String> cities = new HashSet<>();
        while (true) {
            Player player = players[currentPlayerIndex];
            System.out.println("The current player will be: " + player.getName());

            boolean isCityNameCorrect = false;
            while (!isCityNameCorrect) {
                City inputtedCity = new City(CityNameController.cityNameController(scanner, player, properties));
                String[] citiesArray = cities.toArray(new String[cities.size()]);
                try {
                    City lastCity = new City(citiesArray[citiesArray.length - 1]);
                    if (lastCity.getSecondChar() != inputtedCity.getFirstChar()) {
                        System.out.println("The first letter of your city doesn't match the last letter of the previous city. Please try again.");
                        player.setCityMismatchCounter();
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {}

                if (!cities.add(inputtedCity.getName())) {
                    System.out.println("This city already exists. Please choose and write another city.");
                    player.setAlreadyExistingCityCounter();
                    continue;
                } else {
                    fileWriter.setCities(cities);
                }
                isCityNameCorrect = true;
            }

            if (currentPlayerIndex == 1) {
                currentPlayerIndex--;
            } else {
                currentPlayerIndex++;
            }
        }
    }
    public static int getRandomIndex(Player @NotNull [] array) {
        return new Random().nextInt(array.length);
    }
}
