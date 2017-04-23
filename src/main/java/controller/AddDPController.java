package controller;

import fxapp.DBConnection;
import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sun.applet.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Yash on 4/23/2017.
 */
public class AddDPController {
    private MainFXApp main;
    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    private ComboBox poiLocationName;
    @FXML
    private DatePicker dateReading;
    @FXML
    private ComboBox timeReading1;
    @FXML
    private ComboBox timeReading2;
    @FXML
    private ComboBox dataType;
    @FXML
    private TextField dataValue;
    @FXML
    private Button back;
    @FXML
    private Button submit;
    @FXML
    private Text errorText;

    @FXML
    public void onAddLocationClick() {
        main.setAddLocationScene();
    }

    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }

    @FXML
    public void onSubmitClick() throws SQLException {
        if (poiLocationName.getValue() == null) {
            errorText.setText("Please enter a location name.");
        } else if (dateReading.getValue().equals("")) {
            errorText.setText("Please enter a date for data reading");
        } else if ((timeReading1.getValue().equals("")) || (timeReading2.getValue().equals(""))) {
            errorText.setText("Please enter time of data reading");
        } else if (dataType.getValue().equals("")) {
            errorText.setText("Please enter a data type.");
        } else if (dataValue.getText().equals("")) {
            errorText.setText("Please enter a data value.");
        } else {
            String locationName = poiLocationName.getValue().toString();
            String dateTime = dateReading.getValue() + " " + timeReading1.getValue() + ":" + timeReading2.getValue();
            String type = dataType.getValue().toString();
            String value = dataValue.getText().toString();
            System.out.println(locationName + " " + dateTime + " " + type + " " + value);

            addDP(locationName, dateTime, type, value);
            main.setLoginScene();

        }


    }

    private void addDP(String locationName, String dateTime, String type, String dataValue) throws SQLException {
        Statement stmt = null;
        String update = String.format("INSERT INTO DATA_POINT (DateTime, LocationName, Accepted, DataValue, Type) " +
                "VALUES ('%s', '%s', null, '%s', '%s')"
                , dateTime, locationName, dataValue, type);
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


    @FXML
    public void initialize() throws SQLException {

        Statement locName = null;
        String queryLoc = "SELECT LocationName FROM POI";
        try {
            ResultSet result = DBConnection.connectAndQuery(locName, queryLoc);
            while (result.next()) {
                poiLocationName.getItems().add(result.getString("LocationName"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (locName != null) {
                locName.close();
            }
        }

        timeReading1.getItems().removeAll(timeReading1.getItems());
        String[] timeReading1Arr = new String[24];
        for (int i = 0; i < timeReading1Arr.length; i++) {
            if (i < 10) {
                timeReading1Arr[i] = "0" + Integer.toString(i);
            } else {
                timeReading1Arr[i] = Integer.toString(i);
            }
        }
        timeReading1.getItems().addAll(timeReading1Arr);

        timeReading2.getItems().removeAll(timeReading2.getItems());
        String[] timeReading2Arr = new String[60];
        for (int i = 0; i < timeReading2Arr.length; i++) {
            if (i < 10) {
                timeReading2Arr[i] = "0" + Integer.toString(i);
            } else {
                timeReading2Arr[i] = Integer.toString(i);
            }
        }
        timeReading2.getItems().addAll(timeReading2Arr);

        Statement typeStatement = null;
        String queryType = "SELECT Type FROM DATA_TYPE";
        try {
            ResultSet result = DBConnection.connectAndQuery(typeStatement, queryType);
            while (result.next()) {
                dataType.getItems().add(result.getString("Type"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (typeStatement != null) {
                typeStatement.close();
            }
        }



    }

}
