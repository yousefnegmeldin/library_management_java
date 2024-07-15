package interfaces;

import models.Book;
import models.Author;
import java.util.List;
import java.util.Optional;

public interface BookFunctions {
    void addBook(Book book);
    void removeBook(Book bookToRemove);
    void displayBooks();
    Optional<List<Book>> retrieveBooksByAuthor(Author author);
}
