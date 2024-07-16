package interfaces;
import models.Author;
import models.Book;
import models.Customer;

public interface SqlQueriesInterface {
    Book[] getAllBooks();
    void deleteBook(Book book);
    void addBookToDatabase(Book book);
    Book getBookByName(String bookName);
    Book getBookByIsbn(String isbn);
    Book[] retrieveBooksByAuthor(Author author);
    void addCustomerIdToBook(Customer customer);

    int addAuthorToDatabase(Author a);
    void deleteAuthorFromDatabase(Author a);
    Author getAuthorByName(String firstName, String lastName);
    void linkBookToAuthor(Book book,Author author);
}
