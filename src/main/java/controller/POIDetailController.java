package controller;

import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private TableView poiDetailTable;
    @FXML
    private Button back;
    @FXML
    private Button flag;


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

    @FXML
    public void onFlagClick() {
    }

}
