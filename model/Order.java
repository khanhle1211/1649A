package model;

public class Order {
    public String customerName;
    public String shippingAddress;
    public Book[] books;

    public Order(String customerName, String shippingAddress, Book[] books) {
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.books = books;
    }

    @Override
    public String toString() {
        String result = "Customer: " + customerName + ", Address: " + shippingAddress + ", Books: [";
        for (int i = 0; i < books.length; i++) {
            result += books[i].toString();
            if (i < books.length - 1) result += ", ";
        }
        result += "]";
        return result;
    }
}