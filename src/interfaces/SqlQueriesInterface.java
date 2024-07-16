package interfaces;
import models.Author;
import models.Book;
import models.Customer;

public interface SqlQueriesInterface {
    Book[] getAllBooks();
    void deleteBook(Book book);
    void addBook(Book book);
    Book getBookByName(String bookName);
    Book getBookByIsbn(String isbn);
    Book[] retrieveBooksByAuthor(Author author);
    void addCustomerIdToBook(Customer customer);
    void linkBookToAuthor(Book book,Author author);
}
