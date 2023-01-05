package com.example.bakinginformationsystem;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.io.Serializable;

//to be done
public class GenList<object> implements Serializable {
    private class Node implements Serializable {
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

    public int getIndexOf(object data) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    //delete specific object from list by passing an object and searching for it within the list deleting if present doing nothing if not.
    public boolean delete(object data) {
        if (isEmpty()) {
            return false;
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        size--;
        return true;
    }

    //deletes all elements from the linked list
    public void clear() {
        head = null;
        size = 0;
    }

    public void addFirst(object data) {
        head = new Node(data, head);
        size++;
    }

    public void addLast(object data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data, null);
            size++;
        }
    }




    public object find(object data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void iterate(ListView<object> specificListView) {
        Node current = head;
        while (current != null) {
            specificListView.getItems().add(current.data);
            current = current.next;
        }
    }


    public void iterateObjecttoString(ListView<String> specificListView) {
        Node current = head;
        while (current != null) {
            specificListView.getItems().add(current.data.toString());
            current = current.next;
        }
    }

    public void addAll(ListView<object> listView) {
        ObservableList<object> items = listView.getItems();
        for (object item : items) {
            addLast(item);
        }
    }

    public void addAllElementsToListFromListAsString(GenList<String> otherList) {
        Node current = head;
        while (current != null) {
            otherList.addLast(current.data.toString());
            current = current.next;
        }
    }

    public void addAllToChoiceBox(ChoiceBox<object> choiceBox) {
        Node current = head;
        while (current != null) {
            choiceBox.getItems().add(current.data);
            current = current.next;
        }
    }


    public void search(String query, ListView<String> listView) {
        listView.getItems().clear();
        Node current = head;
        while (current != null) {
            if (current.data.toString().contains(query)) {
                listView.getItems().add(current.data.toString());
            }
            current = current.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append("\n");
            }
            current = current.next;
        }
        sb.append("\n");
        return sb.toString();
    }

    public object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void setIndex(int index, object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }
}
