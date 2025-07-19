package structures.LinkedList;

/**
 * A simple singly linked list implementation.
 *
 * @param <E> the type of elements in this list
 */
public class LinkedList<E> implements AbstractLinkedList<E> {

    // ========= Inner Class for Node =========
    private class Node {
        private E element;
        private Node next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    // ========= Fields =========
    private Node head;
    private Node tail;
    private int size;

    // ========= Constructor =========
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // ========= Core Operations =========

    @Override
    public void addFirst(E element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        E removed = head.element;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return removed;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        E removed = tail.element;

        if (head == tail) {
            // Only one element
            head = tail = null;
        } else {
            // More than one element
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }

        size--;
        return removed;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.element;
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    // ========= Utility =========
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;

        while (current != null) {
            sb.append(current.element);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
