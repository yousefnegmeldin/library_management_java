package interfaces;

import models.Book;
import models.Customer;

public interface CustomerService {
    void borrowBook(Book book, Customer customer);

}
