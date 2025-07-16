package algorithms;

import model.Book;

public class Sorting {
    public static void insertionSort(Book[] books) {
        for (int i = 1; i < books.length; i++) {
            Book key = books[i];
            int j = i - 1;
            while (j >= 0 && books[j].title.compareTo(key.title) > 0) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
        }
    }

    public static void selectionSort(Book[] books) {
        for (int i = 0; i < books.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < books.length; j++) {
                if (books[j].title.compareTo(books[minIndex].title) < 0) {
                    minIndex = j;
                }
            }
            Book temp = books[i];
            books[i] = books[minIndex];
            books[minIndex] = temp;
        }
    }

    public static void quickSort(Book[] books, int low, int high) {
        if (low < high) {
            int pi = partition(books, low, high);
            quickSort(books, low, pi - 1);
            quickSort(books, pi + 1, high);
        }
    }

    private static int partition(Book[] books, int low, int high) {
        Book pivot = books[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (books[j].title.compareTo(pivot.title) <= 0) {
                i++;
                Book temp = books[i];
                books[i] = books[j];
                books[j] = temp;
            }
        }
        Book temp = books[i + 1];
        books[i + 1] = books[high];
        books[high] = temp;
        return i + 1;
    }
}