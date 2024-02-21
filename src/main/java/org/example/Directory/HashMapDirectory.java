package org.example.Directory;

import org.example.Main.Entry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class HashMapDirectory implements Directory {
    HashMap<String, String> entriesMap1 = new HashMap<>();
    HashMap<String, String> entriesMap2 = new HashMap<>();

    @Override
    public void insertEntry(Entry entry) {
        entriesMap1.put(entry.getSurname(), entry.getInitials());
        entriesMap2.put(entry.getSurname(), entry.getExtension());
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        entriesMap1.remove(surname);
        entriesMap2.remove(surname);
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        entriesMap2.values().remove(number);
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        entriesMap2.replace(surname, newNumber);
    }

    @Override
    public String lookupExtension(String surname) {
        return entriesMap2.get(surname);
    }

    @Override
    public List<Entry> toArrayList() {
        ArrayList<Entry> entries = new ArrayList<Entry>();

        Collection<String> surnames = entriesMap2.keySet();
        Collection<String> initials = entriesMap1.values();
        Collection<String> extensions = entriesMap2.values();
        ArrayList<String> listOfSurnames = new ArrayList<String>(surnames);
        ArrayList<String> listOfinitials = new ArrayList<String>(initials);
        ArrayList<String> listOfextensions = new ArrayList<String>(extensions);

        for(int i = 0; i < surnames.size(); i++) {
            entries.add(new Entry(listOfSurnames.get(i), listOfinitials.get(i), listOfextensions.get(i)));
        }

        return entries;
    }
}
