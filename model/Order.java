package model;

import structures.ArrayList.ArrayList;

public class Order {
    public String customerName;
    public String shippingAddress;
    public ArrayList<Book> books;

    public Order(String customerName, String shippingAddress, ArrayList<Book> books) {
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.books = books;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Customer: " + customerName + ", Address: " + shippingAddress + ", Books: [");
        for (int i = 0; i < books.size(); i++) {
            result.append(books.get(i));
            if (i < books.size() - 1) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }
}
