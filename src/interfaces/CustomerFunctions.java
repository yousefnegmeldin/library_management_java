package interfaces;

import models.Book;
import models.Customer;

public interface CustomerFunctions {
    void borrowBook(Book book, Customer customer);
    void returnBook(Book book, Customer customer);
}
