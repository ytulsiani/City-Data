package controller;

import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private MainFXApp main;
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;
    public void register(MainFXApp main) {
        this.main = main;
    }
    @FXML
    public void onLoginSelected() {

        //CHANGE SO IT WORKS WITH QUERYING THE DATABSE
        /*if (main.notifyLogin(authenticationManager
                .tokenFromCredentials(usernameField
                        .getText(), passwordField.getText()))) {
            if (main.getActiveUser().isBanned()) {
                message.setText("Account banned, contact an admin.");
            } else {
                main.setMainScene();
            }
        } else {
            message.setText("Username or password incorrect.");
        }*/
    }
    @FXML
    public void initialize() {
    }
    @FXML
    public void onRegisterPressed() throws Exception{
        main.setRegisterScene();

    }


}
