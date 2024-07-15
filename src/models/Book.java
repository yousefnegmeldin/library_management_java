package models;

public abstract class Book {
    private String name;
    private String isbn;
    private Author author;
    public Book(String name, String isbn, Author author){
        this.name = name;
        this.isbn = isbn;
        this.author =author;
        author.addBook(this);
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book)
            return this.isbn.equals(((Book)obj).getIsbn());
        return false;
    }
}
