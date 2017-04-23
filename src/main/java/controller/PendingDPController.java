package controller;

import fxapp.DBConnection;
import fxapp.MainFXApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }

    @FXML
    public void onRejectClick() {
    }

    @FXML
    public void onAcceptClick() {
    }
    @FXML
    public void initalize() throws SQLException {
        ObservableList<ArrayList<String>> data = FXCollections.<ArrayList<String>>observableArrayList();
        Statement stmt = null;
        String query = "SELECT * FROM DATA_POINT WHERE Accepted = NULL";
        try {
            print(query);
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                System.out.println("IN LIOOOOOOPP");
                ArrayList<String> data1 = new ArrayList<String>();
                data1.add("");
                data1.add(result.getString("LocationName"));
                data1.add(result.getString("Type"));
                data1.add(result.getString("DataValue"));
                data1.add(result.getString("DateTime"));
                System.out.println(data1);
                data.add(data1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pendingDPTable.setItems(data);
            if (stmt != null) {
                stmt.close();
            }
        }
    }
        public void print(String pString) {
            System.out.println("WHAT THE FUCK");
    }

}
