package interfaces;
import models.Author;
import models.Book;
import models.Customer;

import java.util.ArrayList;

public interface SqlQueriesInterface {
    ArrayList<Book> getAllBooks();
    void deleteBook(Book book);
    void addBookToDatabase(Book book);
    Book getBookByName(String bookName);
    Book getBookByIsbn(String isbn);
    ArrayList<Book> retrieveBooksByAuthor(Author author);
    void addCustomerIdToBook(Book bok,Customer customer);
    void removeCustomerIdFromBook(Book book,Customer customer);
    void addAuthorToDatabase(Author a);
    void deleteAuthorFromDatabase(Author a);
    Author getAuthorByName(String firstName, String lastName);
    void linkBookToAuthor(Book book,Author author);
}
