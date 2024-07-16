package services;

import database.DatabaseConnection;
import interfaces.SqlQueriesInterface;
import models.Author;
import models.Book;
import models.Customer;
import java.sql.*;

public class SQLService implements SqlQueriesInterface {
    DatabaseConnection databaseConnection;
    public SQLService(){
        databaseConnection = new DatabaseConnection();
    }


    @Override
    public Book[] getAllBooks() {
        return new Book[0];
    }

    @Override
    public void deleteBook(Book book) {

    }

    @Override
    public void addBookToDatabase(Book book) {
        String name = book.getName();
        String isbn = book.getIsbn();
        String genre = book.getGenre();
        String values = name + ","+ isbn + ","+genre; // ex: "john doe,1235325,potato
        Author firstAuthor = book.getAuthor();
        Author secondAuthor = book.getSecondAuthor();
        Author thirdAuthor = book.getThirdAuthor();
        try{
            Statement statement = databaseConnection.connection.createStatement();
            String executionString ="INSERT INTO book(bookName,isbn,genre) " +
                    "VALUES ("+values+")";
            ResultSet resultSet = statement.executeQuery(executionString);
            System.out.println(resultSet.toString());
        }catch(SQLException exception){

        }

    }

    @Override
    public Book getBookByName(String bookName) {
        return null;
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return null;
    }

    @Override
    public Book[] retrieveBooksByAuthor(Author author) {
        return new Book[0];
    }

    @Override
    public void addCustomerIdToBook(Customer customer) {

    }

    @Override
    public int addAuthorToDatabase(Author a) {
        return 0;
    }

    @Override
    public void deleteAuthorFromDatabase(Author a) {

    }


    @Override
    public Author getAuthorByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public void linkBookToAuthor(Book book, Author author) {

    }
}
