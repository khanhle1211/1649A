package main;

import model.Book;
import model.Order;
import structures.Queue;
import structures.ArrayList.ArrayList;
import algorithms.Sorting;
import algorithms.Searching;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Order> orderQueue = new Queue<>();
        ArrayList<Book> lastProcessedBooks = null;

        while (true) {
            System.out.println("\n=== Online Bookstore System ===");
            System.out.println("1. Place New Order");
            System.out.println("2. Process All Orders");
            System.out.println("3. Search Book");
            System.out.println("4. Exit System");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Shipping Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Number of books to order: ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    ArrayList<Book> books = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Book " + (i + 1) + ":");
                        System.out.print("  Title: ");
                        String title = scanner.nextLine();
                        System.out.print("  Author: ");
                        String author = scanner.nextLine();
                        System.out.print("  Quantity: ");
                        int qty = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        books.add(new Book(title, author, qty));
                    }

                    orderQueue.enqueue(new Order(name, address, books));
                    System.out.println("✅ Order placed successfully!");
                }

                case 2 -> {
                    if (orderQueue.isEmpty()) {
                        System.out.println("⚠️ No orders to process.");
                    } else {
                        while (!orderQueue.isEmpty()) {
                            Order order = orderQueue.dequeue();
                            System.out.println("======================================");
                            System.out.println("📦 Processing Order for " + order.customerName + ":");
                            System.out.println(order);

                            System.out.println("\n📚 Books before sorting:");
                            for (int i = 0; i < order.books.size(); i++) {
                                System.out.println(" - " + order.books.get(i));
                            }

                            System.out.println("\n🔀 [Insertion Sort] Sorting books by title...");
                            Sorting.insertionSort(order.books);

                            for (int i = 0; i < order.books.size(); i++) {
                                System.out.println(" - " + order.books.get(i));
                            }
                            System.out.println("✅ Sorting done.");

                            // Save for later search
                            lastProcessedBooks = order.books;

                            System.out.println("======================================\n");
                        }
                        System.out.println("✅ All orders processed.");
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
                    scanner.nextLine(); // consume newline

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

                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
