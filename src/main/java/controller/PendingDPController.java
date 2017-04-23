package controller;

import fxapp.DBConnection;
import fxapp.DataPoint;
import fxapp.MainFXApp;
import fxapp.POI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Yash on 4/23/2017.
 */
public class PendingDPController {
    private MainFXApp main;
    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    private TableView pendingDPTable;
    @FXML
    private Button back;
    @FXML
    private Button reject;
    @FXML
    private Button accept;
    @FXML
    private TableColumn<DataPoint, String> selCol;
    @FXML
    private TableColumn<DataPoint, String> poiCol;
    @FXML
    private TableColumn<DataPoint, String> dataValCol;
    @FXML
    private TableColumn<DataPoint, String> dataTypeCol;
    @FXML
    private TableColumn<DataPoint, String> dateCol;



    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }

    @FXML
    public void onRejectClick() {
    }

    @FXML
    public void onAcceptClick() {
        System.out.println("ACCEPT CLICK");
    }
    @FXML
    public void initalize() throws SQLException {
        loadData();
    }
    public void loadData() throws SQLException {
        Statement stmt = null;
        String query = "SELECT * FROM DATA_POINT WHERE Accepted IS NULL";
        System.out.println("TEST");
        ObservableList<DataPoint> data = FXCollections.observableArrayList();

        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                System.out.println("IN LIOOOOOOPP");
                data.add(new DataPoint(result.getString("LocationName"), result.getString("Type"),
                result.getString("DataValue"), result.getString("DateTime")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pendingDPTable.setItems(data);
            if (stmt != null) {
                stmt.close();
            }
        }
        poiCol.setCellValueFactory(cellData -> cellData.getValue().getLocation());
        dataValCol.setCellValueFactory(cellData -> cellData.getValue().getDataVal());
        dataTypeCol.setCellValueFactory(cellData -> cellData.getValue().getDataType());
        dateCol.setCellValueFactory(cellData -> cellData.getValue().getDateTime());

    }

}
