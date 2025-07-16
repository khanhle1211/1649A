package main;

import model.Book;
import model.Order;
import structures.Queue;
import algorithms.Sorting;
import algorithms.Searching;

public class Main {
    public static void main(String[] args) {
        Queue<Order> orderQueue = new Queue<>();

        // Đơn hàng 1
        Book[] books1 = {
                new Book("Java Programming", "Smith", 1),
                new Book("Algorithms", "Johnson", 2),
                new Book("Data Structures", "Brown", 1)
        };
        orderQueue.enqueue(new Order("Alice", "123 Main St", books1));

        // Đơn hàng 2
        Book[] books2 = {
                new Book("Clean Code", "Martin", 1),
                new Book("Artificial Intelligence", "Russell", 1),
                new Book("Computer Networks", "Tanenbaum", 1)
        };
        orderQueue.enqueue(new Order("Bob", "456 Elm St", books2));

        // Xử lý tất cả đơn hàng trong queue
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.dequeue();
            System.out.println("======================================");
            System.out.println("📦 Processing Order for " + order.customerName + ":");
            System.out.println(order);

            System.out.println("\n📚 Books before sorting:");
            for (Book book : order.books) System.out.println(" - " + book);

            System.out.println("\n🔀 [Insertion Sort] Sorting books by title...");
            Sorting.insertionSort(order.books);
            for (Book book : order.books) System.out.println(" - " + book);
            System.out.println("✅ Sorting done.");

            System.out.println("\n🔍 [Binary Search] Searching for 'Algorithms'...");
            int index = Searching.binarySearch(order.books, "Algorithms");
            if (index >= 0)
                System.out.println("✅ Found at index " + index + ": " + order.books[index]);
            else
                System.out.println("❌ Book 'Algorithms' not found.");
            System.out.println("🔎 Search complete.");
            System.out.println("======================================\n");
        }

        System.out.println("✅ All orders processed.");
    }
}
