package fxapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBConnection {
    public static Connection  connect() throws SQLException {
        Connection con = null;

            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/cs4400_86", "cs4400_86", "pAtSRI1i");

            if (!con.isClosed()) {
                System.out.println("Successfully connected to MySQL server");
            }
            return con;

            //sql test



            /*while (blah.next()) {
                String str = blah.getString("EmailAddress");
                if (str == null) {
                    System.out.println("blah");
                }
                System.out.println(str);
            }*/

    }
}
