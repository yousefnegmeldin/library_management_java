package database;

import java.sql.*;

public class DatabaseConnection {
    Connection connection;

    public DatabaseConnection(){
        try{
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library","root","yousef"
            );

//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

}
