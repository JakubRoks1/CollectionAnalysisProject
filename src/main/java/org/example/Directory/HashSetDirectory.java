package org.example.Directory;


import org.example.Main.Entry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSetDirectory implements Directory {
    HashSet<Entry> entriesSet = new HashSet<Entry>();

    @Override
    public void insertEntry(Entry entry) {
        entriesSet.add(entry);
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        for(Entry entry : entriesSet) {
            if(entry.getSurname() == surname)
                entriesSet.remove(entry);
        }
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        for(Entry entry : entriesSet) {
            if(entry.getExtension() == number)
                entriesSet.remove(entry);
        }
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        for(Entry entry : entriesSet) {
            if(entry.getSurname() == surname)
                entry.setExtension(newNumber);
        }
    }

    @Override
    public String lookupExtension(String surname) {
        String extension = null;

        for(Entry entry : entriesSet) {
            if(entry.getSurname() == surname)
                extension = entry.getExtension();
        }

        return extension;
    }

    @Override
    public List<Entry> toArrayList() {
        List<Entry> listDir = new ArrayList<Entry>(entriesSet);
        return listDir;
    }
}
