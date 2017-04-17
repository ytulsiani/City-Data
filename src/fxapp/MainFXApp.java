package fxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainFXApp extends Application {

    //private Stage activeScreen;
    private Scene loginScene;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        DBConnection.connect();
        initRootLayout();
    }

    private void initRootLayout() throws Exception {
        Pane loginLayout = FXMLLoader.load(getClass().getClassLoader().getResource("/../resources/sample.fxml"));

        loginScene = new Scene(loginLayout);


        stage.setScene(loginScene);
        stage.setTitle("Login");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
