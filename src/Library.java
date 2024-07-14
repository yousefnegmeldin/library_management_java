import java.util.ArrayList;
import java.util.HashMap;
public class Library {
    private ArrayList<Book> books;
    private HashMap<Book,String> borrowed;

    public Library(){
        borrowed = new HashMap<>();
        books = new ArrayList<>();
    }
    public void addBook(Book b){
        books.add(b);
    }
    public void removeBook(Book b){
        books.remove(b);

    }
    public void displayBooks(){
        books.forEach(b->System.out.println("Book Name: "+b.getName() +", Book Author: "+ b.getAuthor()+ ", Book Id: "+b.getBookId());)
    }

    //used polymorphism and optional

    public List<Book> retrieve(Author author){
        Optional<ArrayList<Book>> retrievedBooks =
                books.stream()
                        .filter(b -> b.getAuthor().equals(author)).;
        //return only books where author of book is the same as the author provided ^^^^
        return retrievedBooks.orElse(new ArrayList<Book>());
    }

    public void borrowBook(Book b, String customerId){
        if(borrowed.containsKey(b)){
            System.out.println("book already borrowed");
            return;
        }
        borrowed.put(b,customerId);
    }
}
