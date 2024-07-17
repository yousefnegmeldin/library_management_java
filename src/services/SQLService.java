package services;

import database.DatabaseConnection;
import interfaces.SqlQueriesInterface;
import models.*;

import java.sql.*;
import java.util.ArrayList;

public class SQLService implements SqlQueriesInterface {
    DatabaseConnection databaseConnection;
    public SQLService(){
        databaseConnection = new DatabaseConnection();
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        String executionString = "SELECT * FROM book";
        ArrayList<Book> booksRetrieved = new ArrayList<>();
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                booksRetrieved.add(createBook(resultSet));
            }
            return booksRetrieved;
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return booksRetrieved;
    }

    @Override
    public void deleteBook(Book book) {
        String isbn = book.getIsbn();
        String executionString = "DELETE FROM book WHERE isbn=?";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setString(1,isbn);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet);
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void addBookToDatabase(Book book) {
        String name = book.getName();
        String isbn = book.getIsbn();
        String genre = book.getGenre();

        Author firstAuthor = book.getAuthor();
        Author secondAuthor = book.getSecondAuthor();
        Author thirdAuthor = book.getThirdAuthor();
        String executionString = "INSERT INTO book (bookName, isbn, genre) VALUES (?, ?, ?)";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,isbn);
            preparedStatement.setString(3,genre);
            int resultSet = preparedStatement.executeUpdate();

//            int resultSet = statement.executeUpdate(executionString);
            System.out.println(resultSet);
        }catch(SQLException exception){
            exception.printStackTrace();
        }

    }

    @Override
    public Book getBookByName(String bookName) {
        String executionString = "SELECT * FROM book WHERE bookName=?";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setString(1,bookName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Book selectedBook =null;
            while(resultSet.next()){
                selectedBook = createBook(resultSet);
            }
            return selectedBook;
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookByIsbn(String isbnToSearch) {
        String executionString = "SELECT * FROM book WHERE isbn=?";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setString(1,isbnToSearch);
            ResultSet resultSet = preparedStatement.executeQuery();
            Book selectedBook =null;
            while(resultSet.next()){
                selectedBook = createBook(resultSet);
            }
            return selectedBook;
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Book> retrieveBooksByAuthor(Author author) {
        return new Book[0];
    }

    @Override
    public void addCustomerIdToBook(Customer customer) {

    }

    @Override
    public void addAuthorToDatabase(Author a) {
        String firstName = a.getFirstName();
        String lastName = a.getLastName();
        String values = firstName+","+lastName;
        try{
            Statement statement = databaseConnection.connection.createStatement();
            String executionString ="INSERT INTO author(firstName,lastName) " +
                    "VALUES ("+values+")";
            ResultSet resultSet = statement.executeQuery(executionString);
            System.out.println(resultSet.toString());
        }catch(SQLException exception){

        }
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

    private static Book createBook(ResultSet resultSet) throws SQLException {
        Book bookToCreate = null;
        String bookGenre = resultSet.getString("genre");
        String bookName = resultSet.getString("bookName");
        String bookIsbn = resultSet.getString("isbn");
        switch(bookGenre){
            case "Fantasy": bookToCreate = new FantasyBook(bookName,bookIsbn,bookGenre,null);break;
            case "NonFiction":bookToCreate = new NonFictionBook(bookName,bookIsbn,bookGenre,null);break;
        }
        return bookToCreate;
    }
}
