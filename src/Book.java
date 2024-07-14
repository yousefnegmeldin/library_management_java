public class Book {
    private String name;
    private String bookId;
    private String author;
    public Book(String n, String b, String a){
        this.name = n;
        this.bookId = b;
        this.author =a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        return this.bookId.equals(((Book)obj).bookId);
    }
}
