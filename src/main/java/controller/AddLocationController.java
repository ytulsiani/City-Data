package controller;

import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by Yash on 4/23/2017.
 */
public class AddLocationController {
    private MainFXApp main;
    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    private TextField poiLocationName;
    @FXML
    private ComboBox city;
    @FXML
    private ComboBox state;
    @FXML
    private TextField zipCode;
    @FXML
    private Button back;
    @FXML
    private Button submit;


    @FXML
    public void onBackClick() {
    }

    @FXML
    public void onSubmitClick() {
    }
}
