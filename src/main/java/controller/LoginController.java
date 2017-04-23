package controller;

import fxapp.MainFXApp;
import fxapp.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
    private MainFXApp main;
    //private DBConnection dbConnection;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Text message;
    @FXML
    private Button button;

    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    public void onLoginPressed() throws SQLException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Statement stmt = null;
        String query = "SELECT Username, Password, UserType FROM cs4400_86.USER WHERE Username = '" + username +
                "' AND Password = '" + password + "'";
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);
            System.out.println("TEST");
            while (result.next()) {
                System.out.println("HELOOO");
                System.out.println(result.getString("Username"));
                System.out.println("(OEUO(UEWURW(GUORW(BUOG" + result.getString("UserType"));
                main.setMainScene(result.getString("UserType"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }


        //System.out.println(loginReturn);
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
    public void onRegisterPressed() {
        main.setRegisterScene();
    }

    @FXML
    public void initialize() {
    }



}
