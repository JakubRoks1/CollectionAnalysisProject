package org.example.Directory;

import java.util.ArrayList;
import java.util.List;
import org.example.Main.Entry;
 public class ArrayDirectory implements  Directory {
        private Entry entries[];

        @Override
        public void insertEntry(Entry entry) {
            if(entries == null) {
                entries = new Entry[1];
                entries[0] = entry;
            }
            else {
                Entry[] dir2 = new Entry[entries.length + 1];

                for(int i = 0; i < entries.length; i++)
                    dir2[i] = entries[i];
                dir2[dir2.length - 1] = entry;

                entries = dir2;
            }
        }

        @Override
        public void deleteEntryUsingName(String surname) {
            if(entries != null) {
                Entry[] dir2 = new Entry[entries.length - 1];

                for(int i = 0, j = 0; i < entries.length; i++) {
                    if(entries[i].getSurname() == surname)
                        continue;

                    dir2[j] = entries[i];
                    j++;
                }

                entries = dir2;
            }
        }

        @Override
        public void deleteEntryUsingExtension(String number) {
            if(entries != null) {
                Entry[] dir2 = new Entry[entries.length - 1];

                for(int i = 0, j = 0; i < entries.length; i++) {
                    if(entries[i].getExtension() == number)
                        continue;

                    dir2[j] = entries[i];
                    j++;
                }

                entries = dir2;
            }
        }

        @Override
        public void updateExtensionUsingName(String surname, String newNumber) {
            if(entries != null) {
                for(Entry entry : entries) {
                    if(entry.getSurname() == surname)
                        entry.setExtension(newNumber);
                }
            }
        }

        @Override
        public String lookupExtension(String surname) {
            String extension = null;

            if(entries != null) {
                for(Entry entry : entries) {
                    if(entry.getSurname() == surname)
                        extension = entry.getExtension();
                }
            }

            return extension;
        }

        @Override
        public List<Entry> toArrayList() {
            ArrayList<Entry> dirList = new ArrayList<Entry>();

            for(Entry entry : entries)
                dirList.add(entry);

            return dirList;
        }
}
