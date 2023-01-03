package com.example.bakinginformationsystem;

public class HashMap {

    private static class Entry {
        final int key;
        String value;
        Entry next;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry[] entries;
    private int size;

    public HashMap(int capacity) {
        this.entries = new Entry[capacity];
        this.size = 0;
    }

    public void putHash(int key, String value) {
        int index = hash(key);
        Entry entry = new Entry(key, value);
        entry.next = entries[index];
        entries[index] = entry;
        size++;
    }

    public String getHash(int key) {
        int index = hash(key);
        Entry current = entries[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void removeHash(int key) {
        int index = hash(key);
        Entry current = entries[index];
        if (current == null) {
            return;
        }
        if (current.key == key) {
            entries[index] = current.next;
            size--;
            return;
        }
        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public int sizeHash() {
        return size;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
