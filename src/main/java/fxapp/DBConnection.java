package fxapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBConnection {
    public static void connect() throws SQLException {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/cs4400_86", "cs4400_86", "pAtSRI1i");

            if (!con.isClosed()) {
                System.out.println("Successfully connected to MySQL server");
            }


            //sql test
            /*
            Statement stmnt = con.createStatement();
            stmnt.executeUpdate("INSERT INTO USER (EmailAddress, Username, Password, UserType) VALUES ('blah@blah.com', 'zmudge3', 'password', 'Admin')");
            */
            /*while (blah.next()) {
                String str = blah.getString("EmailAddress");
                if (str == null) {
                    System.out.println("blah");
                }
                System.out.println(str);
            }*/





            //test
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }


    }
}
