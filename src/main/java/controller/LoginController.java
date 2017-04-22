package controller;

import fxapp.MainFXApp;
import fxapp.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        Statement stmt = null;
        Connection con = null;
        //CHANGE SO IT WORKS WITH QUERYING THE DATABSE
        try {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String query = "SELECT " + username + "," + password + " FROM User WHERE username=%s AND password=%s";
            con = DBConnection.connect();
            stmt = con.createStatement();
            ResultSet loginReturn = stmt.executeQuery(query);
        } catch(SQLException e) {
            System.out.println("Something's broken");
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
