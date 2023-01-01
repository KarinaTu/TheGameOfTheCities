package org.example;

import java.util.Properties;
import java.util.Scanner;

public class CityNameController {
    public static String cityNameController(Scanner scanner, Player player, Properties properties) throws Exception {
        String city = null;
        boolean isCityNameCorrect = false;
        while (!isCityNameCorrect) {
            System.out.println("Please enter the name of the city");
            city = scanner.nextLine();
            if (city.length() < Integer.parseInt(properties.getProperty("cityName.minLength")) || city.length() > Integer.parseInt(properties.getProperty("cityName.maxLength"))) {
                System.out.println("The name of the city must contain min 2 and max 15 elements");
                player.setMistakeInCityNameFormatCounter();
            } else if (!city.matches("^[a-zA-Z]*$")) {
                System.out.println("The name of the city must contain only letters");
                player.setMistakeInCityNameFormatCounter();
            } else {
                isCityNameCorrect = true;
            }
        }

        return city;
    }
}
