package main;

import model.Book;
import model.Order;
import structures.Queue;
import structures.ArrayList.ArrayList;
import algorithms.Sorting;
import algorithms.Searching;

import java.util.Scanner;

public class Main {
    private static ArrayList<Book> bookLibrary = new ArrayList<>();

    private static void initializeLibrary() {
        bookLibrary.add(new Book("Clean Code", "Robert C. Martin", 5));
        bookLibrary.add(new Book("Effective Java", "Joshua Bloch", 3));
        bookLibrary.add(new Book("Design Patterns", "Erich Gamma", 4));
        bookLibrary.add(new Book("The Pragmatic Programmer", "Andy Hunt", 2));
        bookLibrary.add(new Book("Intro to Algorithms", "Thomas H. Cormen", 6));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Order> orderQueue = new Queue<>();
        ArrayList<Book> lastProcessedBooks = null;
        initializeLibrary();

        while (true) {
            System.out.println("\n=== Online Bookstore System ===");
            System.out.println("1. Place New Order");
            System.out.println("2. Process All Orders");
            System.out.println("3. Search Book");
            System.out.println("4. Exit System");
            System.out.println("5. View Book Library");
            System.out.println("6. Benchmark Sorting Performance");
            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Shipping Address: ");
                    String address = scanner.nextLine();

                    System.out.println("\n\ud83d\udcda Available Books:");
                    for (int i = 0; i < bookLibrary.size(); i++) {
                        System.out.println((i + 1) + ". " + bookLibrary.get(i));
                    }

                    System.out.print("Number of books to order: ");
                    int count = scanner.nextInt();
                    scanner.nextLine();

                    ArrayList<Book> books = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter book number to add (1–" + bookLibrary.size() + "): ");
                        int bookIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (bookIndex >= 1 && bookIndex <= bookLibrary.size()) {
                            Book selectedBook = bookLibrary.get(bookIndex - 1);

                            System.out.print("Enter quantity (Available: " + selectedBook.quantity + "): ");
                            int qty = scanner.nextInt();
                            scanner.nextLine();

                            if (qty > 0 && qty <= selectedBook.quantity) {
                                books.add(new Book(selectedBook.title, selectedBook.author, qty));
                                selectedBook.quantity -= qty;
                            } else {
                                System.out.println("\u274c Invalid quantity. Try again.");
                                i--;
                            }
                        } else {
                            System.out.println("\u274c Invalid book number. Try again.");
                            i--;
                        }
                    }

                    orderQueue.enqueue(new Order(name, address, books));
                    System.out.println("\u2705 Order placed successfully!");
                }

                case 2 -> {
                    if (orderQueue.isEmpty()) {
                        System.out.println("\u26a0\ufe0f No orders to process.");
                    } else {
                        for (int i = 0; i < orderQueue.size(); i++) {
                            Order order = orderQueue.get(i);
                            System.out.println("======================================");
                            System.out.println("\ud83d\udce6 Processing Order for " + order.customerName + ":");
                            System.out.println(order);

                            System.out.println("\n\ud83d\udcda Books before sorting:");
                            for (int j = 0; j < order.books.size(); j++) {
                                System.out.println(" - " + order.books.get(j));
                            }

                            System.out.println("\n\ud83d\udd00 [Insertion Sort] Sorting books by title...");
                            long start = System.nanoTime();
                            Sorting.insertionSort(order.books);
                            long end = System.nanoTime();
                            long duration = (end - start) / 1_000_000;

                            for (int j = 0; j < order.books.size(); j++) {
                                System.out.println(" - " + order.books.get(j));
                            }
                            System.out.println("\u2705 Sorting done in " + duration + " ms.");

                            lastProcessedBooks = order.books;

                            System.out.println("======================================\n");
                        }
                        System.out.println("\u2705 All orders processed.");
                    }
                }

                case 3 -> {
                    if (lastProcessedBooks == null || lastProcessedBooks.isEmpty()) {
                        System.out.println("\u26a0\ufe0f No processed books to search. Please process orders first.");
                        continue;
                    }

                    System.out.println("Choose search method:");
                    System.out.println("1. Linear Search");
                    System.out.println("2. Binary Search");
                    System.out.print("Enter your choice (1-2): ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("\ud83d\udd0d Enter book title to search: ");
                    String searchTitle = scanner.nextLine();

                    if (searchChoice == 1) {
                        Searching.linearSearch(lastProcessedBooks, searchTitle);
                    } else if (searchChoice == 2) {
                        Searching.binarySearchAll(lastProcessedBooks, searchTitle);
                    } else {
                        System.out.println("\u274c Invalid search choice.");
                    }
                }

                case 4 -> {
                    System.out.println("\ud83d\udc4b Exiting system. Goodbye!");
                    scanner.close();
                    return;
                }

                case 5 -> {
                    System.out.println("\n\ud83d\udcda Library of Available Books:");
                    for (int i = 0; i < bookLibrary.size(); i++) {
                        System.out.println((i + 1) + ". " + bookLibrary.get(i));
                    }
                }

                case 6 -> {
                    ArrayList<Book> smallList = new ArrayList<>();
                    smallList.add(new Book("C", "Author1", 1));
                    smallList.add(new Book("A", "Author2", 1));
                    smallList.add(new Book("B", "Author3", 1));

                    ArrayList<Book> largeList = new ArrayList<>();
                    for (int i = 1000; i >= 1; i--) {
                        largeList.add(new Book("Book " + i, "Author" + i, i));
                    }

                    System.out.println("\n\u26a1 Measuring performance of Insertion Sort...");

                    long startSmall = System.nanoTime();
                    Sorting.insertionSort(smallList);
                    long endSmall = System.nanoTime();
                    long timeSmall = (endSmall - startSmall) / 1_000_000;

                    long startLarge = System.nanoTime();
                    Sorting.insertionSort(largeList);
                    long endLarge = System.nanoTime();
                    long timeLarge = (endLarge - startLarge) / 1_000_000;

                    System.out.println("\ud83d\udccf Execution Time:");
                    System.out.println(" - Small list (3 items): " + timeSmall + " ms");
                    System.out.println(" - Large list (1000 items): " + timeLarge + " ms");
                }

                default -> System.out.println("\u274c Invalid choice. Try again.");
            }
        }
    }
}
