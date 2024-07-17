package services;

import database.DatabaseConnection;
import interfaces.SqlQueriesInterface;
import models.*;

import javax.swing.plaf.nimbus.State;
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
                booksRetrieved.add(createBookObject(resultSet));
            }
            return booksRetrieved;
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return booksRetrieved;
    }

    @Override
    public void deleteBook(Book book) {
        int bookId = book.getBookId();
        String executionString = "DELETE FROM book WHERE isbn=?";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setInt(1,bookId);
            int resultSet = preparedStatement.executeUpdate();
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
        int insertedBookId = 0;
        String executionString = "INSERT INTO book (bookName, isbn, genre) VALUES (?, ?, ?)";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,isbn);
            preparedStatement.setString(3,genre);
            ResultSet generatedKeys = null;
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    insertedBookId = generatedKeys.getInt(1);
                }
            }
            book.setBookId(insertedBookId);
            if(firstAuthor!=null)
                linkBookToAuthor(book,firstAuthor);
            if(secondAuthor !=null)
                linkBookToAuthor(book,secondAuthor);
            if(thirdAuthor!=null)
                linkBookToAuthor(book,thirdAuthor);
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
                selectedBook = createBookObject(resultSet);
            }
            return selectedBook;
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

    //redundant? useless?
    @Override
    public Book getBookByIsbn(String isbnToSearch) {
        String executionString = "SELECT * FROM book WHERE isbn=?";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setString(1,isbnToSearch);
            ResultSet resultSet = preparedStatement.executeQuery();
            Book selectedBook =null;
            while(resultSet.next()){
                selectedBook = createBookObject(resultSet);
            }
            return selectedBook;
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Book> retrieveBooksByAuthor(Author author) {
        String executionString = "SELECT * FROM book WHERE id IN (SELECT bookId FROM book_author WHERE authorId = ?)";
        ArrayList<Book> booksRetrieved = new ArrayList<>();
        int authorId = author.getId();
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setInt(1,authorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Book selectedBook =null;
            while(resultSet.next()){
                booksRetrieved.add(createBookObject(resultSet));
            }
            return booksRetrieved;
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void addCustomerToDatabase(Customer customer){
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        String executionString = "INSERT INTO customer (firstName,lastName) VALUES (?, ?)";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            ResultSet generatedKeys = null;
            int insertedCustomerId =0;
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    insertedCustomerId = generatedKeys.getInt(1);
                }
            }
            customer.setId(insertedCustomerId);
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void addCustomerIdToBook(Book book,Customer customer) {
        int bookId = book.getBookId();
        int customerId = customer.getId();
        String executionString = "UPDATE book SET customerId = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setInt(1,customerId);
            preparedStatement.setInt(2,bookId);
            int resultSet = preparedStatement.executeUpdate();

        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void removeCustomerIdFromBook(Book book) {
        int bookId = book.getBookId();
        String executionString = "UPDATE book SET customerId = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setInt(2,bookId);
            int resultSet = preparedStatement.executeUpdate();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void addAuthorToDatabase(Author author) {
        String firstName = author.getFirstName();
        String lastName = author.getLastName();
        String executionString = "INSERT INTO author (firstName,lastName) VALUES (?, ?)";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            ResultSet generatedKeys = null;
            int insertedAuthorId =0;
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    insertedAuthorId = generatedKeys.getInt(1);
                }
            }
            author.setId(insertedAuthorId);
        }catch(SQLException exception){
            exception.printStackTrace();
        }

    }

    @Override
    public void deleteAuthorFromDatabase(Author a) {
        int authorId = a.getId();
        String executionString = "DELETE FROM author WHERE id = ?";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setInt(1,authorId);
            int resultSet = preparedStatement.executeUpdate();

        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }


    @Override
    public Author getAuthorByName(String firstName, String lastName) {
        String executionString = "SELECT * FROM author WHERE firstName = ? AND lastName = ? LIMIT 1";
        Author authorToReturn =null;
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            authorToReturn = createAuthorObject(resultSet);
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return authorToReturn;
    }

    @Override
    public void linkBookToAuthor(Book book, Author author) {
        int authorId = author.getId();
        int bookId = book.getBookId();
        String executionString = "INSERT INTO book_author (bookId,authorId) VALUES (?, ?)";
        try{
            PreparedStatement preparedStatement =databaseConnection.connection.prepareStatement(executionString);
            preparedStatement.setInt(1,bookId);
            preparedStatement.setInt(2,authorId);
            int resultSet = preparedStatement.executeUpdate();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    private static Book createBookObject(ResultSet resultSet) throws SQLException {
        Book bookToCreate = null;
        String bookGenre = resultSet.getString("genre");
        String bookName = resultSet.getString("bookName");
        String bookIsbn = resultSet.getString("isbn");
        int bookId = resultSet.getInt("id");
        switch(bookGenre){
            case "Fantasy": bookToCreate = new FantasyBook(bookId,bookName,bookIsbn,bookGenre);break;
            case "NonFiction":bookToCreate = new NonFictionBook(bookId,bookName,bookIsbn,bookGenre);break;
        }
        return bookToCreate;
    }
    private static Author createAuthorObject(ResultSet resultSet) throws SQLException {
        Author authorToCreate;
        String authorFirstName = resultSet.getString("firstName");
        String authorLastName = resultSet.getString("lastName");
        int authorAge = resultSet.getInt("age");
        int authorId = resultSet.getInt("id");
        authorToCreate = new Author(authorId, authorFirstName,authorLastName,authorAge);
        return authorToCreate;
    }
}
