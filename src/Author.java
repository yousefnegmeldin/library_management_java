public class Author extends Human {
    private int numOfPublishedBooks;
    public Author(String f,String l,int a){
        super(f,l,a);
        numOfPublishedBooks=0;
    }

    public int getNumOfPublishedBooks() {
        return numOfPublishedBooks;
    }

}
