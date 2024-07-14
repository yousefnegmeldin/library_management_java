public class Author extends Human {
    private int numOfPublishedBooks;
    private ArrayList<Book> booksWritten;
    public Author(String f,String l,int a){
        super(f,l,a);
        numOfPublishedBooks=0;
        this.booksWritten = new ArrayList<>();
    }

    public int getNumOfPublishedBooks() {
        return numOfPublishedBooks;
    }

}
