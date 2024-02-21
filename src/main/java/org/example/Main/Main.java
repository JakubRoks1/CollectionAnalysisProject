package org.example.Main;

import org.example.Directory.ArrayDirectory;
import org.example.Directory.ArrayListDirectory;
import org.example.Directory.Directory;
import org.example.Directory.HashMapDirectory;
import org.example.IO.Input;
import org.example.IO.Output;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    private static String pathToCsvFileReading = "test_data_unique.csv";
    private static String pathToCsvFileWriting = "test1Input.csv";
    private static final int numberOfTests = 1000;

    public static void main(String args[]) throws IOException {
        Directory arrayDirectory = new ArrayDirectory();
        Directory arrayListDirectory = new ArrayListDirectory();
        Directory hashMapDirectory = new HashMapDirectory();

        ArrayList<Directory> directories = new ArrayList<Directory>();
        directories.add(arrayDirectory);
        directories.add(arrayListDirectory);
        directories.add(hashMapDirectory);

        Long[][][] times = new Long[directories.size()][6][numberOfTests]; //[Directory][Method][NumberOfTests] e.g[ArrayDirectory][Inserting][1000]
        Input input = new Input(directories, pathToCsvFileReading);
        testPerformance(times, directories);
        Output output = new Output(directories, pathToCsvFileWriting, times);
    }

    private static void testPerformance(Long[][][] times, ArrayList<Directory> directories) {
        StopWatch stopWatch = new StopWatch();

        for(int i = 0; i < times.length; i++) {
            for(int j = 0; j < times[0].length; j++) {

                switch (j) {
                    case 0:
                        for (int k = 0; k < numberOfTests; k++) {
                            Entry entry = new Entry("Test", "T", "12345");
                            stopWatch.start();
                            directories.get(i).insertEntry(entry);
                            stopWatch.stop();
                            times[i][j][k] = stopWatch.getElapsedTime();
                            stopWatch.reset();
                            directories.get(i).deleteEntryUsingName("Test");
                        }
                        break;
                    case 1:
                        for (int k = 0; k < numberOfTests; k++) {
                            Entry entry = new Entry("Test", "T", "12345");
                            directories.get(i).insertEntry(entry);
                            stopWatch.start();
                            directories.get(i).deleteEntryUsingName("Test");
                            stopWatch.stop();
                            times[i][j][k] = stopWatch.getElapsedTime();
                            stopWatch.reset();
                        }
                        break;
                    case 2:
                        for (int k = 0; k < numberOfTests; k++) {
                            Entry entry = new Entry("Test", "T", "12345");
                            directories.get(i).insertEntry(entry);
                            stopWatch.start();
                            directories.get(i).deleteEntryUsingExtension("12345");
                            stopWatch.stop();
                            times[i][j][k] = stopWatch.getElapsedTime();
                            stopWatch.reset();
                        }
                        break;
                    case 3:
                        for (int k = 0; k < numberOfTests; k++) {
                            Entry entry = new Entry("Test", "T", "12345");
                            directories.get(i).insertEntry(entry);
                            stopWatch.start();
                            directories.get(i).updateExtensionUsingName("Test", "12346");
                            stopWatch.stop();
                            directories.get(i).deleteEntryUsingName("Test");
                            times[i][j][k] = stopWatch.getElapsedTime();
                            stopWatch.reset();
                        }
                        break;
                    case 4:
                        for (int k = 0; k < numberOfTests; k++) {
                            Entry entry = new Entry("Test", "T", "12345");
                            directories.get(i).insertEntry(entry);
                            stopWatch.start();
                            directories.get(i).lookupExtension("Test");
                            stopWatch.stop();
                            times[i][j][k] = stopWatch.getElapsedTime();
                            stopWatch.reset();
                            directories.get(i).deleteEntryUsingName("Test");
                        }
                        break;
                    case 5:
                        for (int k = 0; k < numberOfTests; k++) {
                            stopWatch.start();
                            directories.get(i).toArrayList();
                            stopWatch.stop();
                            times[i][j][k] = stopWatch.getElapsedTime();
                            stopWatch.reset();
                        }
                        break;
                }
            }
        }
    }
}