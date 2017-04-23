package controller;

import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

/**
 * Created by Yash on 4/23/2017.
 */
public class PendingCOController {
    private MainFXApp main;
    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    private TableView pendingCOTable;
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
}
