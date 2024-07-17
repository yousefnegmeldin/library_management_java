package models;

public class NonFictionBook extends Book {
    public NonFictionBook(String name, String isbn, String genre){
        super(name,isbn,genre);
    }
    public NonFictionBook(int bookId, String name, String isbn, String genre){
        super(bookId, name,isbn,genre,null);
    }
}