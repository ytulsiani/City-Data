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
import java.util.List;

/**
 * Created by Yash on 4/23/2017.
 */
public class POIReportController {
    private MainFXApp main;
    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    private TableView poiReportTable;
    @FXML
    private Button back;

    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }
    @FXML
    public void initialize() throws SQLException {
        Statement stmt = null;
        String query = "SELECT * FROM POI";
        ObservableList<String[]> table = FXCollections.observableArrayList(

        );
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {

                //table.add(["", ""]);
                //CODE FOR ADDING TO TABLE

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            poiReportTable.setItems(table);
            if (stmt != null) {
                stmt.close();
            }
        }
    }

}
