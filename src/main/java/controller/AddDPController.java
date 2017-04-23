package controller;

import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sun.applet.Main;

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
    private DatePicker timeDataReading;
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
    }

    @FXML
    public void onBackClick() {
    }

    @FXML
    public void onSubmitClick() {
    }

}
