package algorithms;

import model.Book;
import structures.ArrayList.ArrayList;

public class Sorting {

    // Public method: used to call Quick Sort directly
    public static void sort(ArrayList<Book> books) {
        quickSort(books, 0, books.size() - 1);
    }

    // Quick Sort logic (internal)
    private static void quickSort(ArrayList<Book> books, int low, int high) {
        if (low < high) {
            int pi = partition(books, low, high);
            quickSort(books, low, pi - 1);
            quickSort(books, pi + 1, high);
        }
    }

    // Partition function
    private static int partition(ArrayList<Book> books, int low, int high) {
        Book pivot = books.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (books.get(j).title.compareTo(pivot.title) <= 0) {
                i++;
                Book temp = books.get(i);
                books.set(i, books.get(j));
                books.set(j, temp);
            }
        }

        Book temp = books.get(i + 1);
        books.set(i + 1, books.get(high));
        books.set(high, temp);

        return i + 1;
    }
}
