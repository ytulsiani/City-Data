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
    private Button newDataButton;
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

    public void register(MainFXApp main) {
        this.main = main;
    }

    public void initialize() {

    }
    public void setUser(String userType) {
        if (userType.equals("City Scientist")) {
            filterButton.setDisable(true);
            poiReportButton.setDisable(true);
            pendingDataPointsButton.setDisable(true);
            pendingCOButton.setDisable(true);
        } else if (userType.equals("City Official")) {
            newDataButton.setDisable(true);
            newLocationButton.setDisable(true);
            pendingDataPointsButton.setDisable(true);
            pendingCOButton.setDisable(true);
        } else if (userType.equals("Admin")) {
            newDataButton.setDisable(true);
            newLocationButton.setDisable(true);
            pendingDataPointsButton.setDisable(true);
            pendingCOButton.setDisable(true);
        }
    }
    @FXML
    public void onAddDP() {
        main.setAddDPScene();
    }
    @FXML
    public void onAddLocation() {
        main.setAddLocationScene();
    }
    @FXML
    public void onFilterPOI() {
        main.setFilterPOIScene();
    }
    @FXML
    public void onPOIReport() {

    }
    @FXML
    public void onPendingDP() {

    }
    @FXML
    public void onPendingCity() {

    }

}
