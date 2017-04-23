package controller;

import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by Yash on 4/23/2017.
 */
public class FilterPOIController {
    private MainFXApp main;
    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    private ComboBox locationName;
    @FXML
    private ComboBox city;
    @FXML
    private ComboBox state;
    @FXML
    private TextField zipCode;
    @FXML
    private CheckBox flagged;
    @FXML
    private Button applyFilter;
    @FXML
    private Button resetFilter;
    @FXML
    private Button back;


    @FXML
    public void onApplyFilterClick() {
    }

    @FXML
    public void onResetFilterClick() {
    }

    @FXML
    public void onBackClick() {
        main.setMainScene(MainFXApp.userType, MainFXApp.user);
    }
}
