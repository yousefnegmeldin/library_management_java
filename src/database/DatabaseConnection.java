package database;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library","root","yousef"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
            while(resultSet.next()){
                System.out.println(resultSet.getString("bookName") + " "+ resultSet.getString("isbn"));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }

    }
}
