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
    @FXML
    private Text errorText;

    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    public void onLoginPressed() throws SQLException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Statement stmt = null;
        Statement stmt2 = null;
        String query = "SELECT Username, Password, UserType FROM cs4400_86.USER WHERE Username = '" + username +
                "' AND Password = '" + password + "'";
        try {
            ResultSet result = DBConnection.connectAndQuery(stmt, query);

            boolean correct = false;
            while (result.next()) {
                if (result.getString("UserType").equals("City Official")) {
                    String query2 = "SELECT Approved FROM CITY_OFFICIAL WHERE Username = '" + username + "'";
                    ResultSet result2 = DBConnection.connectAndQuery(stmt2, query2);
                    while (result2.next()) {
                        correct = true;
                        if (result2.getString("Approved") == null || result2.getString("Approved").equals("0")) {
                            errorText.setText("Your city official account hasn't been approved yet!");
                        } else {
                            main.setMainScene(result.getString("UserType"), result.getString("Username"));
                        }
                    }
                } else {
                    correct = true;
                    main.setMainScene(result.getString("UserType"), result.getString("Username"));
                }
            }
            if (correct == false) {
                errorText.setText("Incorrect username or password!");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (stmt2 != null) {
                stmt2.close();
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
