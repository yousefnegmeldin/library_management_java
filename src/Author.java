import java.util.ArrayList;

public class Author extends Human {
    private int numOfPublishedBooks;
    private final ArrayList<Book> booksWritten;

    public Author(String f,String l,int a){
        super(f,l,a);
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
