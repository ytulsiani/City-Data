package controller;

import fxapp.DBConnection;
import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Yash on 4/23/2017.
 */
public class FilterPOIController {
    private MainFXApp main;
    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    private ComboBox locationName;
    @FXML
    private ComboBox city;
    @FXML
    private ComboBox state;
    @FXML
    private TextField zipCode;
    @FXML
    private CheckBox flagged;
    @FXML
    private Button applyFilter;
    @FXML
    private Button resetFilter;
    @FXML
    private Button back;


    @FXML
    public void onApplyFilterClick() {
        String query = "SELECT * from POI WHERE ";
        Object locationBox = locationName.getSelectionModel().getSelectedItem();
        Object stateBox = state.getSelectionModel().getSelectedItem();
        Object cityBox = city.getSelectionModel().getSelectedItem();

        if (locationBox != null) {
            query += "LocationName = '" + locationName + "'";
        } else if (city == null) {
            System.out.println("Please select a city!");
        } else if (title ""){
            System.out.println("Please set a title!");
        }
    }

    @FXML
    public void onResetFilterClick() {
    }
    @FXML
    public void initialize() throws SQLException{
        Statement stmt = null;
        String query = "SELECT DISTINCT LocationName, City, State FROM POI";
        Statement stmt1 = null;
        String query1 = "SELECT DISTINCT City FROM POI";
        Statement stmt2 = null;
        String query2 = "SELECT DISTINCT State FROM POI";

        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            ResultSet result1 = DBConnection.connectAndQuery(stmt1, query1);
            ResultSet result2 = DBConnection.connectAndQuery(stmt2, query2);
            while (result.next()) {
                locationName.getItems().add(result.getString("LocationName"));
            }
            while (result1.next()) {
                city.getItems().add(result1.getString("City"));
            }
            while (result2.next()) {
                state.getItems().add(result2.getString("State"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }
            if (stmt2 != null) {
                stmt2.close();
            }
        }
    }
    @FXML
    public void locationSelected() throws SQLException{
        city.getItems().removeAll(city.getItems());
        state.getItems().removeAll(state.getItems());
        Statement stmt = null;
        Statement stmt1 = null;
        String query = "SELECT DISTINCT City FROM POI WHERE LocationName= '"+
                locationName.getValue() + "'";
        String query1 = "SELECT DISTINCT State FROM POI WHERE LocationName='"+
                locationName.getValue() + "'";
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            ResultSet result1 = DBConnection.connectAndQuery(stmt1, query1);

            while (result.next()) {
                city.getItems().add(result.getString("City"));
            }
            while (result1.next()) {
                state.getItems().add(result1.getString("State"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }
        }
    }
    @FXML
    public  void citySelected() throws SQLException {
        /*locationName.getItems().removeAll(locationName.getItems());
        state.getItems().removeAll(state.getItems());
        Statement stmt = null;
        Statement stmt1 = null;
        String query = "SELECT DISTINCT LocationName FROM POI WHERE City= '"+
                city.getValue() + "'";
        String query1 = "SELECT DISTINCT State FROM POI WHERE City='"+
                city.getValue() + "'";
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            ResultSet result1 = DBConnection.connectAndQuery(stmt1, query1);

            while (result.next()) {
                locationName.getItems().add(result.getString("LocationName"));
            }
            while (result1.next()) {
                state.getItems().add(result1.getString("State"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }
        }*/
    }
    @FXML
    public void stateSelected() throws SQLException {
        /*locationName.getItems().removeAll(locationName.getItems());
        city.getItems().removeAll(city.getItems());
        Statement stmt = null;
        Statement stmt1 = null;
        String query = "SELECT DISTINCT LocationName FROM POI WHERE State= '"+
                state.getValue() + "'";
        String query1 = "SELECT DISTINCT City FROM POI WHERE State='"+
                state.getValue() + "'";
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            ResultSet result1 = DBConnection.connectAndQuery(stmt1, query1);

            while (result.next()) {
                locationName.getItems().add(result.getString("LocationName"));
            }
            while (result1.next()) {
                city.getItems().add(result1.getString("City"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }
        }*/

    }

    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }
}
