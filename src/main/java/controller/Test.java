package controller;

import fxapp.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mahati on 4/23/2017.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        String query = "SELECT D.LocationName, D.Type, SUM(D.DataValue), MAX(D.DataValue), MIN(D.DataValue)," +
                "AVG(D.DataValue) FROM POI AS P LEFT OUTER JOIN DATA_POINT AS D ON" +
                "P.LocationName= D.LocationName GROUP BY D.LocationName, D.Type";
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                System.out.println(result.getString("LocationName"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }

}
