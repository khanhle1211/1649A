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
        bookLibrary.add(new Book("Clean Code", "Author of Clean Code", 5));
        bookLibrary.add(new Book("Effective Java", "Author of Effective Java", 5));
        bookLibrary.add(new Book("Design Patterns", "Author of Design Patterns", 9));
        bookLibrary.add(new Book("The Pragmatic Programmer", "Author of The Pragmatic Programmer", 7));
        bookLibrary.add(new Book("Intro to Algorithms", "Author of Intro to Algorithms", 10));
        bookLibrary.add(new Book("Code Complete", "Author of Code Complete", 5));
        bookLibrary.add(new Book("Refactoring", "Author of Refactoring", 1));
        bookLibrary.add(new Book("Java Concurrency in Practice", "Author of Java Concurrency in Practice", 6));
        bookLibrary.add(new Book("Patterns of Enterprise Application Architecture", "Author of Patterns of Enterprise Application Architecture", 7));
        bookLibrary.add(new Book("Domain-Driven Design", "Author of Domain-Driven Design", 9));
        bookLibrary.add(new Book("Structure and Interpretation of Computer Programs", "Author of SICP", 2));
        bookLibrary.add(new Book("Working Effectively with Legacy Code", "Author of Legacy Code", 3));
        bookLibrary.add(new Book("Head First Design Patterns", "Author of HF Design", 6));
        bookLibrary.add(new Book("Soft Skills", "Author of Soft Skills", 3));
        bookLibrary.add(new Book("The Art of Computer Programming", "Knuth", 2));
        bookLibrary.add(new Book("Modern Operating Systems", "Author of MOS", 4));
        bookLibrary.add(new Book("Computer Networks", "Author of CN", 3));
        bookLibrary.add(new Book("Operating System Concepts", "Author of OSC", 10));
        bookLibrary.add(new Book("AI: A Modern Approach", "Author of AI", 7));
        bookLibrary.add(new Book("Data Mining Concepts", "Author of DMC", 3));
        bookLibrary.add(new Book("Database System Concepts", "Author of DB", 4));
        bookLibrary.add(new Book("Theory of Computation", "Author of TOC", 3));
        bookLibrary.add(new Book("The Mythical Man-Month", "Author of MMM", 7));
        bookLibrary.add(new Book("Don't Make Me Think", "Author of DMMT", 2));
        bookLibrary.add(new Book("The Clean Coder", "Author of TCC", 4));
        bookLibrary.add(new Book("Intro to ML", "Author of IML", 6));
        bookLibrary.add(new Book("You Don't Know JS", "Author of YDKJS", 8));
        bookLibrary.add(new Book("Eloquent JavaScript", "Author of EJ", 4));
        bookLibrary.add(new Book("JS: The Good Parts", "Author of JS TGP", 2));
        bookLibrary.add(new Book("Python Crash Course", "Author of PCC", 6));
        bookLibrary.add(new Book("Fluent Python", "Author of FP", 5));
        bookLibrary.add(new Book("Learning Python", "Author of LP", 3));
        bookLibrary.add(new Book("Automate the Boring Stuff", "Author of ABSP", 9));
        bookLibrary.add(new Book("Grokking Algorithms", "Author of GA", 2));
        bookLibrary.add(new Book("Cracking the Coding Interview", "Author of CTCI", 4));
        bookLibrary.add(new Book("Algorithms (Sedgewick)", "Sedgewick", 6));
        bookLibrary.add(new Book("Computer Org & Design", "Author of COD", 3));
        bookLibrary.add(new Book("Compilers: Dragon Book", "Author of CDT", 4));
        bookLibrary.add(new Book("C Programming Language", "K&R", 5));
        bookLibrary.add(new Book("Programming Pearls", "Author of PP", 1));
        bookLibrary.add(new Book("Info Retrieval", "Author of IR", 2));
        bookLibrary.add(new Book("Agile Software Dev", "Author of ASD", 7));
        bookLibrary.add(new Book("Extreme Programming Explained", "Author of XP", 3));
        bookLibrary.add(new Book("Scrum Book", "Author of Scrum", 2));
        bookLibrary.add(new Book("Continuous Delivery", "Author of CD", 4));
        bookLibrary.add(new Book("TDD by Example", "Author of TDD", 3));
        bookLibrary.add(new Book("Clean Architecture", "Uncle Bob", 8));
        bookLibrary.add(new Book("Clean Agile", "Uncle Bob", 3));
        bookLibrary.add(new Book("Pro Git", "Author of Git", 2));
        bookLibrary.add(new Book("Version Control with Git", "Author of VCG", 2));
        bookLibrary.add(new Book("Mastering Regex", "Author of Regex", 4));
        bookLibrary.add(new Book("Linux Shell Scripting", "Author of LSS", 1));
        bookLibrary.add(new Book("Practical Vim", "Author of PV", 3));
        bookLibrary.add(new Book("Linux Programming Interface", "Author of LPI", 4));
        bookLibrary.add(new Book("Learning SQL", "Author of LSQL", 3));
        bookLibrary.add(new Book("SQL in 10 Minutes", "Author of SQL10", 6));
        bookLibrary.add(new Book("Effective C++", "Author of EC++", 2));
        bookLibrary.add(new Book("More Effective C++", "Author of MEC++", 6));
        bookLibrary.add(new Book("The C++ Programming Language", "Bjarne", 4));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Order> orderQueue = new Queue<>();
        ArrayList<Book> lastProcessedBooks = null;
        initializeLibrary();

        while (true) {
            System.out.println("\n=== Online Bookstore System ===");
            System.out.println("1. Place New Order");
            System.out.println("2. Process Orders");
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

                    System.out.println("\n📚 Available Books:");
                    for (int i = 0; i < bookLibrary.size(); i++) {
                        System.out.println((i + 1) + ". " + bookLibrary.get(i));
                    }

                    System.out.print("Number of books to order: ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // clear newline

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
                                System.out.println("❌ Invalid quantity. Try again.");
                                i--; // repeat this book
                            }
                        } else {
                            System.out.println("❌ Invalid book number. Try again.");
                            i--; // repeat this book
                        }
                    }

                    boolean success = orderQueue.offer(new Order(name, address, books));
                    if (success) {
                        System.out.println("✅ Order placed successfully!");
                    } else {
                        System.out.println("❌ Failed to place order.");
                    }
                }

                case 2 -> {
                    if (orderQueue.isEmpty()) {
                        System.out.println("⚠️ No orders to process.");
                    } else {
                        for (int i = 0; i < orderQueue.size(); i++) {
                            Order order = orderQueue.get(i);
                            System.out.println("======================================");
                            System.out.println("📦 Processing Order for " + order.customerName + ":");
                            System.out.println(order);

                            System.out.println("\n📚 Books before sorting:");
                            for (int j = 0; j < order.books.size(); j++) {
                                System.out.println(" - " + order.books.get(j));
                            }

                            System.out.println("\n🔀 [Quick Sort] Sorting books by title...");
                            long start = System.nanoTime();
                            Sorting.sort(order.books);  // Quick Sort
                            long end = System.nanoTime();
                            long duration = (end - start) / 1_000_000;

                            for (int j = 0; j < order.books.size(); j++) {
                                System.out.println(" - " + order.books.get(j));
                            }
                            System.out.println("✅ Sorting done in " + duration + " ms.");

                            lastProcessedBooks = order.books;

                            System.out.println("======================================\n");
                        }
                        System.out.println("✅ Orders processed.");
                    }
                }

                case 3 -> {
                    if (lastProcessedBooks == null || lastProcessedBooks.isEmpty()) {
                        System.out.println("⚠️ No processed books to search. Please process orders first.");
                        continue;
                    }

                    System.out.println("Choose search method:");
                    System.out.println("1. Linear Search");
                    System.out.println("2. Binary Search");
                    System.out.print("Enter your choice (1-2): ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("🔍 Enter book title to search: ");
                    String searchTitle = scanner.nextLine();

                    if (searchChoice == 1) {
                        Searching.linearSearch(lastProcessedBooks, searchTitle);
                    } else if (searchChoice == 2) {
                        Searching.binarySearchAll(lastProcessedBooks, searchTitle);
                    } else {
                        System.out.println("❌ Invalid search choice.");
                    }
                }

                case 4 -> {
                    System.out.println("👋 Exiting system. Goodbye!");
                    scanner.close();
                    return;
                }

                case 5 -> {
                    System.out.println("\n📚 Library of Available Books:");
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

                    System.out.println("\n⚡ Measuring performance of Quick Sort...");

                    long startSmall = System.nanoTime();
                    Sorting.sort(smallList);
                    long endSmall = System.nanoTime();
                    long timeSmall = (endSmall - startSmall) / 1_000_000;

                    long startLarge = System.nanoTime();
                    Sorting.sort(largeList);
                    long endLarge = System.nanoTime();
                    long timeLarge = (endLarge - startLarge) / 1_000_000;

                    System.out.println("📊 Execution Time:");
                    System.out.println(" - Small list (3 items): " + timeSmall + " ms");
                    System.out.println(" - Large list (1000 items): " + timeLarge + " ms");
                }

                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
