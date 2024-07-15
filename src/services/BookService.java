package services;

import interfaces.BookFunctions;
import models.Author;
import models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookService implements BookFunctions {
    private final ArrayList<Book> books;

    public BookService(){
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book bookToRemove) {
        books.remove(bookToRemove);
    }

    @Override
    public void displayBooks() {
        books.forEach(b->System.out.println("models.Book Name: "+b.getName() +", models.Book models.Author: "+ b.getAuthor().getFirstName() +" " +b.getAuthor().getLastName()+ ", models.Book Id: "+b.getIsbn()));
    }

    @Override
    public Optional<List<Book>> retrieveBooksByAuthor(Author author) {
        List<Book> retrievedBooks = books.stream()
                .filter(b -> b.getAuthor().equals(author))
                .collect(Collectors.toList());
        //return only books where author of book is the same as the author provided ^^^^
        return retrievedBooks.isEmpty() ? Optional.empty() : Optional.of(retrievedBooks);
    }
}
