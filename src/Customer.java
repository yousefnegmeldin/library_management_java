import java.util.ArrayList;

public class Customer extends Human {
    ArrayList<Book> books;
    public Customer(String f,String l,int a){
        super(f,l,a);
        books = new ArrayList<>();
    }

}
