package controller;

import fxapp.CityOfficial;
import fxapp.DBConnection;
import fxapp.DataPoint;
import fxapp.MainFXApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Yash on 4/23/2017.
 */
public class PendingCOController {
    private MainFXApp main;
    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    private TableView pendingCOTable;
    @FXML
    private Button back;
    @FXML
    private Button reject;
    @FXML
    private Button accept;
    @FXML
    private TableColumn<CityOfficial, String> selCol;
    @FXML
    private TableColumn<CityOfficial, String> usernameCol;
    @FXML
    private TableColumn<CityOfficial, String> emailCol;
    @FXML
    private TableColumn<CityOfficial, String> cityCol;
    @FXML
    private TableColumn<CityOfficial, String> stateCol;
    @FXML
    private TableColumn<CityOfficial, String> titleCol;
    @FXML
    private TableColumn<CityOfficial, String> dateCol;

    @FXML
    public void initalize() {

    }
    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }

    @FXML
    public void onRejectClick() {
    }

    @FXML
    public void onAcceptClick() {
    }
    public void loadData() throws SQLException {
        Statement stmt = null;
        String query = "SELECT * FROM CITY_OFFICIAL WHERE Approved IS NULL";
        System.out.println("TEST");
        ObservableList<CityOfficial> data = FXCollections.observableArrayList();

        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                System.out.println("IN LIOOOOOOPP");
                data.add(new CityOfficial(result.getString("Username"), result.getString("EmailAddress")
                ,result.getString("City"), result.getString("State"), result.getString("Title")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pendingCOTable.setItems(data);
            if (stmt != null) {
                stmt.close();
            }
        }
        usernameCol.setCellValueFactory(cellData -> cellData.getValue().getUsername());
        emailCol.setCellValueFactory(cellData -> cellData.getValue().getEmail());
        cityCol.setCellValueFactory(cellData -> cellData.getValue().getCity());
        stateCol.setCellValueFactory(cellData -> cellData.getValue().getState());
        titleCol.setCellValueFactory(cellData -> cellData.getValue().getTitle());

    }

}
