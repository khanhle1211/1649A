package algorithms;

import model.Book;
import structures.ArrayList.ArrayList;

public class Sorting {

    // Insertion Sort
    public static void insertionSort(ArrayList<Book> books) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            while (j >= 0 && books.get(j).title.compareTo(key.title) > 0) {
                books.set(j + 1, books.get(j));
                j--;
            }
            books.set(j + 1, key);
        }
    }

    // Selection Sort
    public static void selectionSort(ArrayList<Book> books) {
        for (int i = 0; i < books.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < books.size(); j++) {
                if (books.get(j).title.compareTo(books.get(minIndex).title) < 0) {
                    minIndex = j;
                }
            }
            Book temp = books.get(i);
            books.set(i, books.get(minIndex));
            books.set(minIndex, temp);
        }
    }

    // Quick Sort
    public static void quickSort(ArrayList<Book> books) {
        quickSortHelper(books, 0, books.size() - 1);
    }

    private static void quickSortHelper(ArrayList<Book> books, int low, int high) {
        if (low < high) {
            int pi = partition(books, low, high);
            quickSortHelper(books, low, pi - 1);
            quickSortHelper(books, pi + 1, high);
        }
    }

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
