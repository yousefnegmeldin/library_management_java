package models;

public abstract class Book {
    private String name;
    private String isbn;
    private int bookId;
    private String genre;
    private Author author;
    private Author secondAuthor;
    private Author thirdAuthor;
    public Book(int bookId, String name, String isbn, String genre, Author author){
        this.bookId = bookId;
        this.name = name;
        this.isbn = isbn;
        this.author =author;
        this.genre = genre;
        if(author !=null)
            author.addBook(this);
    }
    public Book(int bookId, String name, String isbn,String genre, Author author1, Author author2){
        this.bookId = bookId;
        this.name = name;
        this.isbn = isbn;
        this.author =author1;
        this.secondAuthor= author2;
        author.addBook(this);
        secondAuthor.addBook(this);
    }

    public Book(int bookId, String name, String isbn,String genre, Author author1, Author author2, Author author3){
        this.name = name;
        this.bookId = bookId;
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

    public int getBookId(){
        return this.bookId;
    }
    public void setBookId(int bookId){
        this.bookId = bookId;
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

    public String getGenre(){
        return this.genre;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book)
            return this.isbn.equals(((Book)obj).getIsbn());
        return false;
    }
}
