package org.example.Directory;

import org.example.Main.Entry;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDirectory implements Directory {
    private ArrayList<Entry> entriesList = new ArrayList<Entry>();

    @Override
    public void insertEntry(Entry entry) {
        entriesList.add(entry);
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        for(Entry entry : entriesList) {
            if(entry.getSurname() == surname) {
                entriesList.remove(entry);
                break;
            }
        }
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        for(Entry entry : entriesList) {
            if(entry.getExtension() == number) {
                entriesList.remove(entry);
                break;
            }
        }
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        for(Entry entry : entriesList) {
            if(entry.getSurname() == surname)
                entry.setExtension(newNumber);
        }
    }

    @Override
    public String lookupExtension(String surname) {
        String extension = null;

        for(Entry entry : entriesList) {
            if(entry.getSurname() == surname)
                extension = entry.getExtension();
        }

        return extension;
    }

    @Override
    public List<Entry> toArrayList() {
        return entriesList;
    }
}

