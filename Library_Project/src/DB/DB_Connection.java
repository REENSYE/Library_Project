/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class DB_Connection {

    String URL = "jdbc:mysql://localhost:3306/first_task?useSSL=false";
    String USERNAME = ""; // use your username of Mysql server
    String PASSWORD = ""; // use your password of Mysql server
    Connection connection = null;
    PreparedStatement preparedStmt = null;
    ResultSet resultSet = null;
    String sqlQuery = "";

    public DB_Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getMydatabase() {
        sqlQuery = "SELECT * FROM ;";// table name in database

        try {
            preparedStmt = connection.prepareStatement(sqlQuery);
            resultSet = preparedStmt.executeQuery();
        } catch (SQLException e) {
        }
        return resultSet;
    }

    public int addBook(int val1, int val2) throws SQLException {
        sqlQuery = "insert into Book(book1,book2)values('" + val1 + "','" + val2 + "');";

        
        Boolean s;
        int i = 0;
        try {
            Statement stmt = connection.createStatement();
            i = stmt.executeUpdate(sqlQuery);
            if (i == 0) {
                s = false;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return i;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(URL);
        }
    }
}

