package structures;

public class Queue<E> {
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head = null, tail = null;
    private int size = 0;

    // Add elements to last waiting row
    public boolean offer(E item) {
        Node<E> node = new Node<>(item);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = tail;
        }
        size++;
        return true;
    }

    // Get and remove the first element in the queue
    public E poll() {
        if (head == null) return null;
        E data = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    // Returns the first element without removing
    public E peek() {
        return (head == null) ? null : head.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the number of elements in the queue
    public int size() {
        return size;
    }

    // Access element at index position
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}
