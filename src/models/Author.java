package models;

import java.util.ArrayList;

public class Author extends Human {
    private int numOfPublishedBooks;
    private final ArrayList<Book> booksWritten;

    public Author(String firstName,String lastName,int age){
        super(firstName,lastName,age);
        numOfPublishedBooks=0;
        this.booksWritten = new ArrayList<>();
    }

    public int getNumOfPublishedBooks() {
        return numOfPublishedBooks;
    }

    public void addBook(Book book) {
        booksWritten.add(book);
        numOfPublishedBooks++;
    }

    public ArrayList<Book> getBooks() {
        return booksWritten;
    }
}
