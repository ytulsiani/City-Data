package controller;

import fxapp.DBConnection;
import fxapp.MainFXApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
        ObservableList<ArrayList<String>> data = FXCollections.<ArrayList<String>>observableArrayList();

        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                System.out.println("IN LIOOOOOOPP");
                ArrayList<String> data1 = new ArrayList<String>();
                data1.add("");
                data1.add(result.getString("Username"));
                data1.add(result.getString("EmailAddress"));
                data1.add(result.getString("City"));
                data1.add(result.getString("Title"));
                System.out.println(data1);
                data.add(data1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pendingCOTable.setItems(data);
            if (stmt != null) {
                stmt.close();
            }
        }
    }

}
