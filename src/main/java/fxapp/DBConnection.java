package fxapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBConnection {
    public static ResultSet  connectAndQuery(Statement stmt, String query) throws SQLException {
        Connection con = null;

            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/cs4400_86", "cs4400_86", "pAtSRI1i");
            ResultSet returnSet= null;
            if (!con.isClosed()) {
                System.out.println("Successfully connected to MySQL server");
            }
            //Statement stmt = null;
            //CHANGE SO IT WORKS WITH QUERYING THE DATABSE
            try {
                stmt = con.createStatement();
                returnSet = stmt.executeQuery(query);
            } catch(SQLException e) {
                System.out.println(e);
            } finally {

            }

            //sql test



            /*while (blah.next()) {
                String str = blah.getString("EmailAddress");
                if (str == null) {
                    System.out.println("blah");
                }
                System.out.println(str);
            }*/
        return returnSet;
    }
    public static void connectAndExecute(String query) {

    }
}
