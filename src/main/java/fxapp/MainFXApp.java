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

        initRootLayout();

        //test sql statements



    }

    private void initRootLayout() throws Exception {

        Pane loginLayout = FXMLLoader.load(getClass().getResource("login.fxml"));
        loginScene = new Scene(loginLayout);

        //add other loaders and layouts here

        //register controllers


        stage.setScene(loginScene);
        stage.setTitle("Login");
        stage.show();
    }
    public void setRegisterScene() throws Exception {

        Pane loginLayout = FXMLLoader.load(getClass().getResource("login.fxml"));
        loginScene = new Scene(loginLayout);

        //add other loaders and layouts here

        //register controllers


        stage.setScene(loginScene);
        stage.setTitle("Register");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
