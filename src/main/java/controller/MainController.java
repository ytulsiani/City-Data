package controller;
import fxapp.MainFXApp;
import fxapp.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Yash on 4/22/2017.
 */
public class MainController {
    private MainFXApp main;
    @FXML
    private Button newButtonButton;
    @FXML
    private Button newLocationButton;
    @FXML
    private Button filterButton;
    @FXML
    private Button poiReportButton;
    @FXML
    private Button pendingDataPointsButton;
    @FXML
    private Button pendingCOButton;
    public void initialize() {

    }
    public void setScreen(String usertype) {
        if (usertype.equals("City Scientist")) {
            filterButton.setVisible(false);
            poiReportButton.setVisible(false);
            pendingDataPointsButton.setVisible(false);
            pendingCOButton.setVisible(false);
        } else if (usertype.equals("City Official")) {
            newButtonButton.setVisible(false);
            newLocationButton.setVisible(false);
            pendingDataPointsButton.setVisible(false);
            pendingCOButton.setVisible(false);
        } else if (usertype.equals("Admin")) {
            newButtonButton.setVisible(false);
            newLocationButton.setVisible(false);
            pendingDataPointsButton.setVisible(false);
            pendingCOButton.setVisible(false);
        }
    }
}
