package controller;

import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sun.applet.Main;

import java.sql.SQLException;

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
    public void onAddLocationClick() {
        main.setAddLocationScene();
    }

    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }

    @FXML
    public void onSubmitClick() {
        //String locationName = poiLocationName.getValue().toString();
        //System.out.println(timeDataReading.toString());

    }

    @FXML
    public void initialize() throws SQLException {
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


    }

}
