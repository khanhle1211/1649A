package structures;

public class Queue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head = null, tail = null;
    private int size = 0;

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = tail;
        size++;
    }

    public T dequeue() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}