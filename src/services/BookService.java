package services;

import interfaces.BookFunctions;
import models.Author;
import models.Book;

import java.util.List;
import java.util.Optional;

public class BookService implements BookFunctions {
    @Override
    public void addBook(Book book) {

    }

    @Override
    public void removeBook(Book bookToRemove) {

    }

    @Override
    public void displayBooks() {

    }

    @Override
    public Optional<List<Book>> retrieveBooksByAuthor(Author author) {
        return Optional.empty();
    }
}
