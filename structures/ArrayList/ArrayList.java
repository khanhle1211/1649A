package structures.ArrayList;

/**
 * A basic implementation of a dynamic array list (similar to Java's ArrayList).
 *
 * @param <E> the type of elements in this list
 */
public class ArrayList<E> implements AbstractList<E> {
    private E[] elements;
    private int nextIndex;

    // Default initial capacity
    private static final int INITIAL_CAPACITY = 3;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.elements = (E[]) new Object[INITIAL_CAPACITY];
        this.nextIndex = 0;
    }

    @Override
    public boolean add(E element) {
        ensureCapacity();
        elements[nextIndex++] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > nextIndex) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ensureCapacity();

        // Shift elements to the right
        for (int i = nextIndex; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        nextIndex++;
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removed = elements[index];

        // Shift elements to the left
        for (int i = index; i < nextIndex - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--nextIndex] = null; // Avoid memory leak
        shrinkCapacity();
        return removed;
    }

    @Override
    public int size() {
        return nextIndex;
    }

    @Override
    public boolean isEmpty() {
        return nextIndex == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < nextIndex; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nextIndex; i++) {
            sb.append(elements[i]);
            if (i < nextIndex - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // ========== PRIVATE UTILS ==========

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (nextIndex == elements.length) {
            E[] bigger = (E[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, bigger, 0, elements.length);
            elements = bigger;
        }
    }

    @SuppressWarnings("unchecked")
    private void shrinkCapacity() {
        if (nextIndex < elements.length / 3 && elements.length > INITIAL_CAPACITY) {
            E[] smaller = (E[]) new Object[elements.length / 2];
            System.arraycopy(elements, 0, smaller, 0, nextIndex);
            elements = smaller;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= nextIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }


    public interface AbstractList<E> {
        boolean add(E element);

        boolean add(int index, E element);

        E get(int index);

        E set(int index, E element);

        E remove(int index);

        int size();

        boolean contains(E element);

        int indexOf(E element);

        boolean isEmpty();
    }
}

