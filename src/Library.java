import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private final ArrayList<Book> books;
    private final HashMap<Book,Customer> borrowed;

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

        books.forEach(b->System.out.println("Book Name: "+b.getName() +", Book Author: "+ b.getAuthor().getFirstName() +" " +b.getAuthor().getLastName()+ ", Book Id: "+b.getBookId()));
    }

    //used polymorphism and optional
    public Optional<List<Book>> retrieve(Author author){
        List<Book> retrievedBooks = books.stream()
                .filter(b -> b.getAuthor().equals(author))
                .collect(Collectors.toList());
        //return only books where author of book is the same as the author provided ^^^^

        return retrievedBooks.isEmpty() ? Optional.empty() : Optional.of(retrievedBooks);
    }

    public boolean borrowBook(Book b, Customer customer){
        if (borrowed.containsKey(b)) {
            System.out.println("Book already borrowed");
            return false;
        }
        borrowed.put(b, customer);
        return true;
    }

    public boolean returnBook(Customer c, Book b){
        if(!borrowed.containsKey(b)){
            System.out.println("book was not borrowed");
            return false;
        }
        if(borrowed.get(b)!=c){
            //can use exceptions instead of true and false
            System.out.println("book was not borrowed by this customer");
            return false;
        }
        borrowed.remove(b);
        return true;
    }
}
