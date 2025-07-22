package structures;

public class Stack<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) { this.data = data; }
    }

    private Node<E> top = null;
    private int size = 0;

    public void push(E item) {
        Node<E> node = new Node<>(item);
        node.next = top;
        top = node;
        size++;
    }

    public E pop() {
        if (top == null) return null;
        E data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public E peek() {
        return top != null ? top.data : null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
