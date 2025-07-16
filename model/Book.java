package model;

public class Book {
    public String title;
    public String author;
    public int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (Qty: " + quantity + ")";
    }
}