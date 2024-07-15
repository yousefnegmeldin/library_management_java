package models;

import java.util.ArrayList;

public class Customer extends Human {
    ArrayList<Book> books;
    public Customer(String firstName,String lastName,int age){
        super(firstName,lastName,age);
        books = new ArrayList<>();
    }

}
