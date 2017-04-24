package controller;

import fxapp.DBConnection;
import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Yash on 4/23/2017.
 */
public class AddLocationController {
    private MainFXApp main;

    @FXML
    private TextField poiLocationName;
    @FXML
    private ComboBox selectCity;
    @FXML
    private ComboBox selectState;
    @FXML
    private TextField zipCode;
    @FXML
    private Button back;
    @FXML
    private Button submit;

    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }

    @FXML
    public void onSubmitClick() throws SQLException {
        if (!poiLocationName.getText().toString().equals("") && !zipCode.getText().toString().equals("")
                && selectState.getSelectionModel().getSelectedItem() != null && selectCity.getSelectionModel().getSelectedItem() != null) {
            Statement stmt = null;
            String update = String.format("INSERT INTO POI (Flag, DateFlagged, LocationName, ZipCode, City, State) VALUES (FALSE, NULL, '%s', '%s', '%s', '%s')"
                    , poiLocationName.getText().toString(), zipCode.getText().toString(), selectCity.getSelectionModel().getSelectedItem().toString(), selectState.getSelectionModel().getSelectedItem().toString());
            try {
                DBConnection.connectAndUpdate(stmt, update);
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        }

    }

    @FXML
    public void initialize() throws SQLException {
        Statement stmt = null;
        String query = "SELECT DISTINCT State FROM CITY_STATE ORDER BY State";
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                selectState.getItems().add(result.getString("State"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    @FXML
    public void onStateSwitch() throws SQLException{
        String state = selectState.getValue().toString();
        Statement stmt = null;
        selectCity.getItems().removeAll(selectCity.getItems());
        String query = "SELECT City FROM CITY_STATE WHERE State = '" + state + "' ORDER BY City";
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                selectCity.getItems().add(result.getString("City"));
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
