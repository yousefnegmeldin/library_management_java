package models;

public class FantasyBook extends Book {
    public FantasyBook(String name, String isbn, String genre){
        super(name,isbn,genre);
    }
    public FantasyBook(int bookId, String name, String isbn, String genre){
        super(bookId, name,isbn,genre,null);
    }
}
