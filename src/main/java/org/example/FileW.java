package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class FileW {
    private String firstPlayerName;
    private String secondPlayerName;
    private Set<String> cities;


    public void setFirstPlayerName(String firstPlayerName) {
        this.firstPlayerName = firstPlayerName;
    }

    public void setSecondPlayerName(String secondPlayerName) {
        this.secondPlayerName = secondPlayerName;
    }

    public void setCities(Set<String> cities) {
        this.cities = cities;
    }

    public void saveGameResults() throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
        Date date = new Date();

        String reportFileName = String.format("Game-result-%s-%s-%s.txt", firstPlayerName, secondPlayerName, sdf.format(date));
        File newFile = new File(String.format("%s", reportFileName));
        if (newFile.createNewFile()) {
            try {
                FileWriter myWriter = new FileWriter(newFile, true);
                if (cities != null) {
                    for (String writeCities : cities) {
                        myWriter.append(writeCities + "\n");
                    }
                }

                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        System.out.println("The file is successfully created. The path to this file is: " + newFile.getAbsolutePath());
    }
}

