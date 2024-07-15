package models;

public abstract class Book {
    private String name;
    private String isbn;
    private Author author;
    private Author secondAuthor;
    private Author thirdAuthor;
    public Book(String name, String isbn, Author author){
        this.name = name;
        this.isbn = isbn;
        this.author =author;
        author.addBook(this);
    }
    public Book(String name, String isbn, Author author1, Author author2){
        this.name = name;
        this.isbn = isbn;
        this.author =author1;
        this.secondAuthor= author2;
        author.addBook(this);
        secondAuthor.addBook(this);
    }

    public Book(String name, String isbn, Author author1, Author author2, Author author3){
        this.name = name;
        this.isbn = isbn;
        this.author =author1;
        this.secondAuthor = author2;
        this.thirdAuthor = author3;
        author.addBook(this);
        secondAuthor.addBook(this);
        thirdAuthor.addBook(this);
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

    public Author getSecondAuthor(){
        return secondAuthor;
    }

    public Author getThirdAuthor(){
        return thirdAuthor;
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
