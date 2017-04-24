package controller;

import fxapp.DBConnection;
import fxapp.MainFXApp;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import fxapp.POI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

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
    private Button nextButton;
    @FXML
    private TableColumn<POI, String> locationCol;
    @FXML
    private TableColumn<POI, String> cityCol;
    @FXML
    private TableColumn<POI, String> stateCol;
    @FXML
    private TableColumn<POI, String> zipCol;
    @FXML
    private TableColumn<POI, String> flaggedCol;
    @FXML
    private TableColumn<POI, String> dateCol;

    @FXML
    public void onApplyFilterClick() throws SQLException {
        String query = "SELECT * FROM POI WHERE ";
        Object locationBox = locationName.getSelectionModel().getSelectedItem();
        Object stateBox = state.getSelectionModel().getSelectedItem();
        Object cityBox = city.getSelectionModel().getSelectedItem();
        ObservableList<POI> data = FXCollections.observableArrayList();
        if(flagged.isSelected()) {
            query += "Flag = TRUE ";
        } else {
            query += "(Flag IS NULL OR Flag = FALSE) ";
        }

        if (locationBox != null) {
            query += "AND LocationName = '" + locationName.getValue().toString() + "' ";
        } if (cityBox != null) {
            query += "AND City = '" + city.getValue().toString() + "' ";
        } if (stateBox != null){
            query += "AND State = '" + state.getValue().toString() + "' ";
        }  if (!zipCode.getText().equals("")) {
            query += "AND ZipCode = '" + zipCode.getText() + "' ";
        } if (date1.getValue() != null) {
//            query += "AND DateFlagged > '" + date1.getValue().toString() + "' ";
            query += " AND DateFlagged > '" + date1.getValue().toString() + "'";
        } if (date2.getValue() != null) {
//            query += "AND DateFlagged < '" + date2.getValue().toString() + "' ";
            query += " AND DateFlagged < '" + date2.getValue().toString() + "'";
        }
        Statement stmt = null;
        try {
            System.out.println(query);
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                //ArrayList<String> data1 = new ArrayList<String>();
                POI poi = new POI(result.getString("LocationName"), result.getString("Flag"), result.getString("DateFlagged"),
                        result.getString("ZipCode"), result.getString("City"), result.getString("State"));
                data.add(poi);
                System.out.println(data.size());
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {

            if (stmt != null) {
                stmt.close();
            }
        }

        locationCol.setCellValueFactory(cellData -> cellData.getValue().getLocation());
        cityCol.setCellValueFactory(cellData -> cellData.getValue().getCity());
        stateCol.setCellValueFactory(cellData -> cellData.getValue().getState());
        zipCol.setCellValueFactory(cellData -> cellData.getValue().getZipcode());
        flaggedCol.setCellValueFactory(cellData -> cellData.getValue().getFlag());
        dateCol.setCellValueFactory(cellData -> cellData.getValue().getDate());

        table.setItems(data);
    }

    @FXML
    public void onResetFilterClick() {
        locationName.setValue(null);
        city.setValue(null);
        state.setValue(null);
        zipCode.clear();
        flagged.setSelected(false);
        date1.setValue(null);
        date2.setValue(null);

    }
    @FXML
    public void initialize() throws SQLException {
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
    public void onNextPressed() throws SQLException {
        main.setPOIDetailScene((POI) table.getSelectionModel().getSelectedItem());
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
    public int datePicker(String date1, String date2) {
        int year1 = Integer.parseInt(date1.substring(0,4));
        int year2 = Integer.parseInt(date2.substring(0,4));
        int month1 = Integer.parseInt(date1.substring(5,7));
        int month2 = Integer.parseInt(date2.substring(5,7));
        int day1 = Integer.parseInt(date1.substring(8,10));
        int day2 = Integer.parseInt(date2.substring(8,10));
        if (year1 == year2) {
            if (month1 == month2) {
                if (day1 == day2) {
                    return 0;
                } else if (day1 > day2) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (month1 > month2) {
                return 1;
            } else {
                return -1;
            }
        } else if (year1 > year2) {
            return 1;
        } else {
            return -1;
        }
    }
}
