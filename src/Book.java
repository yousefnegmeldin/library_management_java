public abstract class Book {
    private String name;
    private int bookId;
    private Author author;
    public Book(String n, int b, Author a){
        this.name = n;
        this.bookId = b;
        this.author =a;
        a.addBook(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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
            return this.bookId ==((Book)obj).bookId;
        return false;
    }
}
