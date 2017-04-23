package controller;

import fxapp.DBConnection;
import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mahati on 4/23/2017.
 */
public class POIDetailController {
    private MainFXApp main;
    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    private ComboBox type;
    @FXML
    private TextField dataValue1;
    @FXML
    private TextField dataValue2;
    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private Button applyFilter;
    @FXML
    private Button resetFilter;

    @FXML
    private TableView poiDetailTable;
    @FXML
    private Button back;
    @FXML
    private Button flag;

    private String locationName;


    @FXML
    public void onApplyFilterClick() throws SQLException {
        Statement stmt = null;
        String query = "SELECT * FROM POI WHERE LocationName = '" + locationName +
                "'";
        if (type.getValue() != null) {
            query += " AND Type = '" + type.getValue().toString();
        }
        if (!dataValue1.getText().equals("")) {
            query += " AND DataValue > '" + Integer.parseInt(dataValue1.getText()) + "'";
        }
        if (!dataValue2.getText().equals("")) {
            query += " AND DataValue < '" + Integer.parseInt(dataValue2.getText()) + "'";
        }
        if(date1.getValue() != null) {
            System.out.println(date1.getValue().toString());
        }
        if(date2.getValue() != null) {
            System.out.println(date2.getValue().toString());
        }
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                //
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
    public void onResetFilterClick() {

    }
    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }

    @FXML
    public void onFlagClick() {
    }

}
