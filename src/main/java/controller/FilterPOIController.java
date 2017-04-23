package controller;

import fxapp.DBConnection;
import fxapp.MainFXApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private Button back;
    @FXML
    private TableView table;

    @FXML
    public void onApplyFilterClick() throws SQLException {
        String query = "SELECT * FROM POI WHERE ";
        Object locationBox = locationName.getSelectionModel().getSelectedItem();
        Object stateBox = state.getSelectionModel().getSelectedItem();
        Object cityBox = city.getSelectionModel().getSelectedItem();
        ObservableList<ArrayList<String>> data = FXCollections.<ArrayList<String>>observableArrayList();
        if(flagged.isSelected()) {
            query += "Flag = true ";
        } else {
            query += "(Flag = false OR Flag = NULL) ";
        }

        if (locationBox != null) {
            query += "AND LocationName = '" + locationName.getValue().toString() + "' ";
        } if (cityBox != null) {
            query += "AND City = '" + city.getValue().toString() + "' ";
        } if (stateBox != null){
            query += "AND State = '" + state.getValue().toString() + "' ";
        }  if (zipCode != null) {
            query += "AND ZipCode = '" +zipCode + "' ";
        } if (date1 != null) {
            System.out.println("DATE1: " + date1.toString());
        } if (date2 != null) {
            System.out.println("DATE2: " + date2.toString());
        }
        Statement stmt = null;
        try {
            System.out.println(query);
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                System.out.println("IN LIOOOOOOPP");
                ArrayList<String> data1 = new ArrayList<String>();
                data1.add(result.getString("LocationName"));
                data1.add(result.getString("City"));
                data1.add(result.getString("State"));
                data1.add(result.getString("ZipCode"));
                data1.add(result.getString("Flag"));
                data1.add(result.getString("DateFlagged"));
                System.out.println(data1);
                data.add(data1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            table.setItems(data);
            if (stmt != null) {
                stmt.close();
            }
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
