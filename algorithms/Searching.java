package algorithms;

import model.Book;
import structures.ArrayList.ArrayList; // dùng cụ thể ArrayList

public class Searching {

    // Linear Search: partial match (case-insensitive)
    public static void linearSearch(ArrayList<Book> books, String title) {
        boolean found = false;
        System.out.println("\n🔍 [Linear Search] Searching for '" + title + "'...");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println("✅ Found at index " + i + ": " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Book '" + title + "' not found.");
        }
        System.out.println("🔎 Search complete.");
    }

    // Binary Search (exact match, assumes sorted by title)
    public static void binarySearchAll(ArrayList<Book> books, String title) {
        int low = 0, high = books.size() - 1;
        boolean found = false;

        System.out.println("\n🔍 [Binary Search] Searching for '" + title + "'...");

        while (low <= high) {
            int mid = (low + high) / 2;
            Book midBook = books.get(mid);
            int cmp = midBook.title.compareToIgnoreCase(title.trim());

            if (cmp == 0) {
                found = true;
                System.out.println("✅ Found at index " + mid + ": " + midBook);

                // Left duplicates
                int left = mid - 1;
                while (left >= 0 && books.get(left).title.equalsIgnoreCase(title)) {
                    System.out.println("✅ Found at index " + left + ": " + books.get(left));
                    left--;
                }

                // Right duplicates
                int right = mid + 1;
                while (right < books.size() && books.get(right).title.equalsIgnoreCase(title)) {
                    System.out.println("✅ Found at index " + right + ": " + books.get(right));
                    right++;
                }

                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("❌ Book '" + title + "' not found.");
        }
        System.out.println("🔎 Search complete.");
    }
}
