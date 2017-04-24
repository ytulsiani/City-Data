package controller;

import fxapp.DBConnection;
import fxapp.MainFXApp;
import fxapp.POI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import fxapp.DataPoint;

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
    private TableColumn<DataPoint, String> dataTypeCol;
    @FXML
    private TableColumn<DataPoint, String> dataValueCol;
    @FXML
    private TableColumn<DataPoint, String> dateTimeCol;

    @FXML
    private TableView poiDetailTable;
    @FXML
    private Button back;
    @FXML
    private Button flag;

    private DataPoint dataPoint;

    private POI point;

    private String locationName;


    public void loadPoint(POI point) {
        this.point = point;
        locationName = point.getLocation().get();
    }

    @FXML
    public void onApplyFilterClick() throws SQLException {
        ObservableList<DataPoint> data = FXCollections.observableArrayList();

        Statement stmt = null;
        String query = "SELECT * FROM DATA_POINT WHERE LocationName = '" + locationName +
                "'";
        if (type.getValue() != null) {
            query += " AND Type = '" + type.getValue().toString() + "'";
        }
        if (!dataValue1.getText().equals("")) {
            query += " AND DataValue > " + Integer.parseInt(dataValue1.getText());
        }
        if (!dataValue2.getText().equals("")) {
            query += " AND DataValue < " + Integer.parseInt(dataValue2.getText());
        }
        if(date1.getValue() != null) {
            //System.out.println(date1.getValue().toString());
            query += " AND DateTime > '" + date1.getValue().toString() + "'";
        }
        if(date2.getValue() != null) {
            query += " AND DateTime < '" + date2.getValue().toString() + "'";
        }
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                DataPoint point = new DataPoint(locationName, result.getString("Type"), result.getString("DataValue"), result.getString("DateTime"));
                data.add(point);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        dataTypeCol.setCellValueFactory(cellData -> cellData.getValue().getDataType());
        dataValueCol.setCellValueFactory(cellData -> cellData.getValue().getDataVal());
        dateTimeCol.setCellValueFactory(cellData -> cellData.getValue().getDateTime());

        poiDetailTable.setItems(data);
    }
    @FXML
    public void onResetFilterClick() {
        type.setValue(null);
        dataValue1.clear();
        dataValue2.clear();
        date1.setValue(null);
        date2.setValue(null);
        poiDetailTable.getItems().clear();

    }
    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }

    @FXML
    public void onFlagClick() {
    }

    @FXML
    public void initialize() {
        type.getItems().removeAll(type.getItems());
        type.getItems().addAll("Mold", "Air Quality");
        type.getSelectionModel().select("Mold");
    }

}
