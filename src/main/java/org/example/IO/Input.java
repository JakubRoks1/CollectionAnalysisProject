package org.example.IO;

import org.example.Directory.Directory;
import org.example.Main.Entry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Input {
    private String pathToCsv;
    private final String pathToReport = "Report.txt";
    private ArrayList<Directory> directories;

    public Input(ArrayList<Directory> directories, String pathToCsv) throws IOException {
        this.directories = directories;
        this.pathToCsv = pathToCsv;
        readData();
    }

    private void readData() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        String row;

        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");

            for(Directory dir : directories) {
                dir.insertEntry(new Entry(data[0], data[1], data[2]));
            }
        }

        csvReader.close();
    }
}

