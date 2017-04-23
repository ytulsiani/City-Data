package fxapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnection {
    public static ResultSet connectAndQuery(Statement stmt, String query) throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/cs4400_86", "cs4400_86", "pAtSRI1i");
        ResultSet returnSet = null;
        if (!con.isClosed()) {
            System.out.println("Successfully connected to MySQL server");
        }
        try {
            stmt = con.createStatement();
            returnSet = stmt.executeQuery(query);
        } catch(SQLException e) {
            System.out.println(e);
        }
        return returnSet;
    }
    public static void connectAndUpdate(Statement stmt, String query) throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/cs4400_86", "cs4400_86", "pAtSRI1i");
        if (!con.isClosed()) {
            System.out.println("Successfully connected to MySQL server");
        }
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}
