import models.*;
import services.SQLService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args){

        SQLService sqlService = new SQLService();

        //example author that is already found in database;
        //make sure to choose author name thats already found in database
        Author author1 =  new Author("JK","Rowling",30);
        sqlService.addAuthorToDatabase(author1);

        //get all books
        ArrayList<Book> allBooks = sqlService.getAllBooks();
//        System.out.println("Printing all books!");
//        for(Book book: allBooks){
//            System.out.println(book);
//        }

        //delete book
        Book bookToDelete = allBooks.get(allBooks.size()-1);
        sqlService.deleteBook(bookToDelete);
        System.out.println("successful deletion in database for book: " + bookToDelete.getName());

        //adding book function
        Book bookToBeAdded = new FantasyBook("I am number four","273589632586325","Fantasy");
        bookToBeAdded.setAuthor(author1);
        sqlService.addBookToDatabase(bookToBeAdded);



        //find book by name or by isbn
        Book selectedBookByName = sqlService.getBookByName("I am number four");
        System.out.println("Selected book by name: "+ selectedBookByName);
        Book selectedBookByIsbn = sqlService.getBookByIsbn("273589632586325");
        System.out.println("Selected book by isbn: "+ selectedBookByIsbn);


        //find books by author
        ArrayList<Book> retrievedBooksByAuthor = sqlService.retrieveBooksByAuthor(author1);
        if(retrievedBooksByAuthor.size()>0) {
            for (Book book : retrievedBooksByAuthor) {
                System.out.println("Book by author :"+author1.getFirstName()+" " +book);
            }
        }
        //borrow and return book
        Customer firstCustomer = new Customer("youseCustomer", "negm",19);
        sqlService.addCustomerToDatabase(firstCustomer);
        sqlService.addCustomerIdToBook(bookToBeAdded, firstCustomer);
        sqlService.removeCustomerIdFromBook(bookToBeAdded);



    }
}
