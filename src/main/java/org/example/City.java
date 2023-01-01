package org.example;

public class City {
    private String name;
    private char firstChar;
    private char secondChar;

    public City(String name) {
        this.name = name;
        this.findCityFirstAndLastChar();
    }
    public String getName() {
        return name.toLowerCase();
    }
    public char getFirstChar() {
        return Character.toLowerCase(firstChar);
    }
    public char getSecondChar() {
        return Character.toLowerCase(secondChar);
    }
    private void findCityFirstAndLastChar() {
        char[] cityNameArray = new char[name.length()];
        for (int i = 0; i < name.length(); i++) {
            cityNameArray[i] = name.charAt(i);
        }

        firstChar = cityNameArray[0];
        secondChar = cityNameArray[cityNameArray.length - 1];
    }
}
