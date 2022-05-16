package com.company;

public class MyQueue<T> {
    private static class Node<U> {
        U data;
        Node<U> next;
    }
    Node<T> first, last;

    public void add(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        if (first == null) {
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
    }

    public int count() {
        Node<T> n = first;
        int count = 0;
        while (n != null) {
            ++count;
            n = n.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T get() {
        if  (first == null)
            return null;
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }
}
