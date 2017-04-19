package controller;
import fxapp.MainFXApp;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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

    public void register(MainFXApp main) {
        this.main = main;
    }

    @FXML
    public void onRegisterPressed() {
        main.setRegisterScene();
    }

    @FXML
    public void initialize() {
    }
    @FXML
    public void setRegisterCityScientist() {
        System.out.print("TESTTTTTTTTTTTTTT");
    }
    public void setRegisterCityOfficial() {
        System.out.println("EOUGHUUUUUUUUU");
        typeSelect.
    }
}
