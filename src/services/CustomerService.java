package services;

import interfaces.CustomerFunctions;
import models.Book;
import models.Customer;

import java.util.HashMap;

public class CustomerService implements CustomerFunctions {
    HashMap<Book,Customer> borrowedBooks;

    public CustomerService(){
        borrowedBooks = new HashMap<>();
    }

    @Override
    public void borrowBook(Book book, Customer customer) {
        if (borrowedBooks.containsKey(book)) {
            System.out.println("models.Book already borrowed");
        }
        borrowedBooks.put(book, customer);
        System.out.println("models.Book borrowed successfully");
    }

    @Override
    public void returnBook(Book book, Customer customer) {
        if(!borrowedBooks.containsKey(book)){
            System.out.println("book was not borrowed");
        }
        if(borrowedBooks.get(book)!=customer){
            //can use exceptions instead of true and false
            System.out.println("book was not borrowed by this customer");
        }
        borrowedBooks.remove(book);
        System.out.println("models.Book removed successfully");
    }
}
