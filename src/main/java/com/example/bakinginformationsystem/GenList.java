package com.example.bakinginformationsystem;

import java.util.NoSuchElementException;

//to be done
public class GenList<object> {
    private class Node {
        private object data;
        private Node next;

        public Node(object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public GenList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(object data) {
        head = new Node(data, head);
        size++;
    }

    public object getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        object data = head.data;
        head = head.next;
        size--;
        return data;
    }

    //possibly more methods needed here WIP.
}
