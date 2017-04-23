package controller;
import fxapp.MainFXApp;
import fxapp.UserType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import fxapp.DBConnection;

/**
 * Created by Yash on 4/18/2017.
 */
public class RegisterController {
    private MainFXApp main;

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Text message;
    @FXML
    private ComboBox comboBox;
    @FXML
    private ComboBox selectState;
    @FXML
    private ComboBox selectCity;

    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    public void onRegisterPressed() {
        main.setRegisterScene();
    }

    @FXML
    public void initialize() {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("City Scientist", "City Official");
        comboBox.getSelectionModel().select("City Scientist");
        //ADD CODE WHICH QUEIRES AND GETS ALL THE STATES

    }
    @FXML
    public void switchBox() {
//        if (comboBox.getValue() == "City Official") {
//            main.setMainScene(UserType.CITY_OFFICIAL);
//        } else if (comboBox.getValue() == "City Scientist") {
//            main.setMainScene(UserType.)
//        }
    }
    @FXML
    public void switchBoxState() {
        //ADD CODE WHICH ADDS ALL CITIES WITHIN A STATE W/ SQL
        System.out.println(selectState.getValue());
    }
    @FXML
    public void switchBoxCity() {
        System.out.println(selectCity.getValue());
    }

}
