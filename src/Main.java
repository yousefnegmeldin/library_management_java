import models.*;
import services.SQLService;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args){
        /*Library library = new Library();
        Customer customer1 = new Customer("yousef","mohamed",20);
        Customer customer2 = new Customer("mohamed","negm",25);

        Author author1 = new Author("yousef", "negm",19);
        Author author2 = new Author("john","doe",33);
        Book book1 = new FantasyBook("Harry Potter","1",author1);
        Book book2 = new NonFictionBook("The boy in striped pjamas","2",author2 );
        library.addBook(book1);

        library.addBook(book2);
        library.removeBook(book2);

        library.displayBooks();

        library.borrowBook(book1,customer1);
        library.borrowBook(book1,customer1);
        library.returnBook(book1,customer1);
        Optional<List<Book>> opt = library.retrieve(author1);

        if(opt.isPresent()){
            List<Book> books = opt.get();
            System.out.println("Books written by: "+ author1.getFirstName() +" "+ author1.getLastName());
            books.forEach(b -> System.out.println(b.getName()));
        }
        else{
            System.out.println("no books found for this author");
        }*/
        SQLService sqlService = new SQLService();
        FantasyBook book1 = new FantasyBook("Harry Potter9","23578357932","Fantasy",null);
        sqlService.addBookToDatabase(book1);
//        sqlService.deleteBook(book1);
        Book book = sqlService.getBookByIsbn("23578357932");
        System.out.println(book.getName());
    }
}
