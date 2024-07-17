package models;

import java.util.ArrayList;

public class Customer extends Human {
    ArrayList<Book> books;
    public Customer(int customerId,String firstName,String lastName,int age){
        super(customerId,firstName,lastName,age);
        books = new ArrayList<>();
    }
    public Customer(String firstName,String lastName,int age){
        super(firstName,lastName,age);
        books = new ArrayList<>();
    }

}
