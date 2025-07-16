package structures;

public class Stack<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> top = null;
    private int size = 0;

    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (top == null) return null;
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        return top != null ? top.data : null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}