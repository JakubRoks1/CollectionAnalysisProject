package org.example.IO;

import org.example.Directory.Directory;
import org.example.Main.Entry;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Output {
    private String pathToCsv;
    private String pathToRaportTxt = "Report.txt";
    private ArrayList<Directory> directories;
    private Long[][][] times;

    public Output(ArrayList<Directory> directories, String pathToCsv, Long[][][] times) throws IOException {
        this.directories = directories;
        this.pathToCsv = pathToCsv;
        this.times = times;

        writeDataOnScreen();
        writeDataToFile();
        generatePerformanceReport();
    }

    private void writeDataOnScreen() {

        for(Directory dir : directories) {
            for (Entry e : dir.toArrayList()) {
                System.out.println(e.getSurname() + "," + e.getInitials() + "," + e.getExtension());
            }
            System.out.println("\n");
        }
    }

    private void writeDataToFile() throws IOException {
        FileWriter csvWriter = new FileWriter(pathToCsv);

        for(Directory dir : directories) {
            for (Entry e : dir.toArrayList()) {
                csvWriter.write(e.getSurname());
                csvWriter.write(",");
                csvWriter.write(e.getInitials());
                csvWriter.write(",");
                csvWriter.write(e.getExtension());
                csvWriter.write("\n");
            }
            csvWriter.write("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

    private void generatePerformanceReport() throws IOException {
        FileWriter writer = new FileWriter(pathToRaportTxt);
        String[] dirs = {"Array", "Array list", "Hash map"};
        String[] methodNames = {"insertEntry", "deleteEntryUsingName", "deleteEntryUsingExtension",
                "updateExtensionUsingName", "lookupExtension", "toArrayList"};

        for(int i = 0; i < times.length; i++) {
            writer.write(dirs[i] + ": \n");

            for(int j = 0; j < times[0].length; j++) {
                writer.write(methodNames[j] + ": ");
                writer.write("Minimum: " + findMinimum(times[i][j]) + "ns, ");
                writer.write("average: " + findAverage(times[i][j]) + "ns, ");
                writer.write("maximum: " + findMaximum(times[i][j]) + "ns.\n");
            }
            writer.write("\n");
        }

        writer.close();
    }

    private long findMinimum(Long t[]) {
        long minimum = t[0];

        for(Long l : t) {
            if(l < minimum)
                minimum = l;
        }

        return minimum;
    }

    private long findMaximum(Long t[]) {
        long maximum = t[0];

        for(Long l : t) {
            if(l > maximum)
                maximum = l;
        }

        return maximum;
    }

    private long findAverage(Long t[]) {
        long sum = 0;

        for(Long l : t) {
            sum += l;
        }

        return sum/t.length;
    }
}

