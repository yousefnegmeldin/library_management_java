import models.*;
import services.SQLService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args){

        SQLService sqlService = new SQLService();
        Author author1 = new Author("JK", "Rowling",35);
        sqlService.addAuthorToDatabase(author1);
        Author author2 = new Author("Jane","Doe",32);
        sqlService.addAuthorToDatabase(author2);
        ArrayList<Book> allBooks = sqlService.getAllBooks();
        System.out.println("Printing all books!");
        for(Book book: allBooks){
            System.out.println(book);
        }
        Book bookToDelete = allBooks.get(allBooks.size()-1);
        sqlService.deleteBook(bookToDelete);
        System.out.println("successful deletion in database for book: " + bookToDelete.getName());
        Book bookToBeAdded = new FantasyBook("I am number four","273589632586325","Fantasy");
        bookToBeAdded.setAuthor(author1);
        bookToBeAdded.setSecondAuthor(author2);
        sqlService.addBookToDatabase(bookToBeAdded);

        Book selectedBookByName = sqlService.getBookByName("Harry Potter 2");
        System.out.println(selectedBookByName);
        Book selectedBookByIsbn = sqlService.getBookByIsbn("273589632586325");
        System.out.println(selectedBookByIsbn);

        ArrayList<Book> retrievedBooksByAuthor = sqlService.retrieveBooksByAuthor(author1);

        Customer firstCustomer = new Customer("youseCustomer", "negm",19);
        sqlService.addCustomerToDatabase(firstCustomer);
        sqlService.addCustomerIdToBook(bookToBeAdded, firstCustomer);

        sqlService.removeCustomerIdFromBook(bookToBeAdded);



    }
}
