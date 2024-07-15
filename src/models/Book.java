package models;

import java.util.ArrayList;

public abstract class Book {
    private String name;
    private String isbn;
    private ArrayList<Author> author;

    public Book(String name, String isbn, ArrayList<Author> author){
        this.name = name;
        this.isbn = isbn;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public ArrayList<Author> getAuthor() {
        return author;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book)
            return this.isbn.equals(((Book)obj).getIsbn());
        return false;
    }
}
