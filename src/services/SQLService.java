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

    }

    @Override
    public void addCustomerIdToBook(Customer customer) {

    }

    @Override
    public void addAuthorToDatabase(Author author) {
        String firstName = author.getFirstName();
        String lastName = author.getLastName();
        String executionString = "INSERT INTO book (firstName,lastName) VALUES (?, ?)";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);

            int resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet);
        }catch(SQLException exception){
            exception.printStackTrace();
        }

    }

    @Override
    public void deleteAuthorFromDatabase(Author a) {

    }


    @Override
    public Author getAuthorByName(String firstName, String lastName) {
        String executionString = "SELECT 1 FROM author WHERE firstName = ? AND lastName = ?";
        Author authorToReturn =null;
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            authorToReturn = createAuthor(resultSet);
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return authorToReturn;
    }

    @Override
    public void linkBookToAuthor(Book book, Author author) {
        int bookId = book.getBookId();
        int authorId = author.getAuthorId;

        Author authorToLink;
        String executionString = "INSERT INTO book_author (bookId,authorId) VALUES (?, ?)";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setString(1,bookId);
            preparedStatement.setString(2,authorId);

            int resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet);
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    private static Book createBook(ResultSet resultSet) throws SQLException {
        Book bookToCreate = null;
        String bookGenre = resultSet.getString("genre");
        String bookName = resultSet.getString("bookName");
        String bookIsbn = resultSet.getString("isbn");
        int bookId = resultSet.getInt("id");
        switch(bookGenre){
            case "Fantasy": bookToCreate = new FantasyBook(bookId,bookName,bookIsbn,bookGenre,null);break;
            case "NonFiction":bookToCreate = new NonFictionBook(bookId,bookName,bookIsbn,bookGenre,null);break;
        }
        return bookToCreate;
    }
    private static Author createAuthor(ResultSet resultSet) throws SQLException {
        Author authorToCreate;
        String authorFirstName = resultSet.getString("firstName");
        String authorLastName = resultSet.getString("lastName");
        int authorAge = resultSet.getInt("age");
        authorToCreate = new Author(authorFirstName,authorLastName,authorAge);
        return authorToCreate;
    }
}
