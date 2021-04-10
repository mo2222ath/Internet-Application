package DB;


import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Moaaz Hasan
 */
public class ConnectionToDB {

    java.sql.Connection Con = null;
    public Statement Stmt = null;
    String url = "";
    String user = "";
    String password = "";

    public ConnectionToDB() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://localhost:3306/bank?allowPublicKeyRetrieval=true&useSSL=false";
            user = "Moaaz";
            password = "Moaaz";
            Con = DriverManager.getConnection(url, user, password);
            Stmt = Con.createStatement();
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.err.println("Exception: " + cnfe);
        }
    }
}
