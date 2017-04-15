package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static java.awt.Color.black;

public class Main extends Application {

    private Stage activeScreen;
    private Scene loginScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        //primaryStage.setTitle("Login and Registration");
        //primaryStage.setScene(new Scene(root, 300, 275));
        //primaryStage.show();

        DBConnection.connect();
        initRootLayout(primaryStage);
    }

    private void initRootLayout(Stage mainScreen) throws Exception{
        activeScreen = mainScreen;
        Pane loginLayout = FXMLLoader.load(getClass().getResource("login.fxml"));

        loginScene = new Scene(loginLayout);


        activeScreen.setScene(loginScene);
        activeScreen.setTitle("blah");
        activeScreen.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

//    public void setMainPage() {
//        activeScreen.setScene(s);
//    }
}
