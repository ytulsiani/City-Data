package controller;

import fxapp.DBConnection;
import fxapp.MainFXApp;
import fxapp.POI;
import fxapp.POIReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
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
    private TableColumn<POIReport, String> poiLocationCol;
    @FXML
    private TableColumn<POIReport, String> cityCol;
    @FXML
    private TableColumn<POIReport, String> moldMinCol;
    @FXML
    private TableColumn<POIReport, String> moldAvgCol;
    @FXML
    private TableColumn<POIReport, String> moldMaxCol;
    @FXML
    private TableColumn<POIReport, String> aqMinCol;
    @FXML
    private TableColumn<POIReport, String> aqAvgCol;
    @FXML
    private TableColumn<POIReport, String> aqMaxCol;
    @FXML
    private TableColumn<POIReport, String> numDPCol;
    @FXML
    private TableColumn<POIReport, String> flaggedCol;
    @FXML
    public void initialize() throws SQLException {

        poiLocationCol.setCellValueFactory(cellData -> cellData.getValue().getPOILocation());
        cityCol.setCellValueFactory(cellData -> cellData.getValue().getCity());
        moldMinCol.setCellValueFactory(cellData -> cellData.getValue().getMoldMin());
        moldAvgCol.setCellValueFactory(cellData -> cellData.getValue().getMoldAvg());
        moldMaxCol.setCellValueFactory(cellData -> cellData.getValue().getMoldMax());
        aqMinCol.setCellValueFactory(cellData -> cellData.getValue().getAQMin());
        aqAvgCol.setCellValueFactory(cellData -> cellData.getValue().getAQAvg());
        aqMaxCol.setCellValueFactory(cellData -> cellData.getValue().getAQMax());
        numDPCol.setCellValueFactory(cellData -> cellData.getValue().getNumDP());
        flaggedCol.setCellValueFactory(cellData -> cellData.getValue().getFlagged());

    }

    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }
    public void loadData() throws SQLException{
        System.out.println("YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        ObservableList<POIReport> data = FXCollections.observableArrayList();
        Statement stmt = null;
        String query = "SELECT POI.LocationName, POI.City, POI.State, Round(IfNULL(MT.MoldMin,0),2) AS MoldMin, Round(IfNULL(MT.MoldAvg,0),2) AS MoldAvg, Round(IfNULL(MT.MoldMax,0),2) AS MoldMax, Round(IfNULL(AQT.AQMin,0),2) as AQMin, Round(IfNULL(AQT.AQAvg,0),2) as AQAvg, Round(IfNULL(AQT.AQMax,0),2) AS AQMax, (IfNULL(AQT.AQCount,0) + IfNULL(MT.MoldCount,0)) AS Counter, POI.Flag from POI LEFT OUTER JOIN ( SELECT D.LocationName as LocationName, D.Type as Type, COUNT(D.DataValue) as MoldCount, MAX(D.DataValue) as MoldMax, MIN(D.DataValue) as MoldMin, AVG(D.DataValue) as MoldAvg FROM POI P, DATA_POINT D WHERE P.LocationName= D.LocationName AND D.Type = 'Mold' GROUP BY D.LocationName, D.Type ) MT ON POI.LocationName = MT.LocationName LEFT OUTER JOIN ( SELECT D.LocationName as LocationName, D.Type as Type, COUNT(D.DataValue) AS AQCount, MAX(D.DataValue) AS AQMax, MIN(D.DataValue) AS AQMin, AVG(D.DataValue) As AQAvg FROM POI P, DATA_POINT D WHERE P.LocationName= D.LocationName AND D.Type = 'Air Quality' GROUP BY D.LocationName, D.Type ) AQT ON POI.LocationName = AQT.LocationName";
        try {
            System.out.println("IN TRY CATCH");
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            while (result.next()) {
                System.out.println("TffffffffffffffffffffffffEST");
                POIReport poiReport = new POIReport(result.getString("LocationName"), result.getString("City"),
                        result.getString("State"), result.getString("MoldMin"), result.getString("MoldAvg"),
                        result.getString("MoldMax"), result.getString("AQMin"), result.getString("AQAvg"),
                        result.getString("AQMax"), result.getString("Counter"), result.getString("Flag"));
                data.add(poiReport);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        poiReportTable.setItems(data);

    }

}
