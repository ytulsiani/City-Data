package fxapp;

import controller.*;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class MainFXApp extends Application {

    private Stage stage;

    private Scene loginScene;
    private Scene registerScene;
    private Scene mainScene;
    private Scene addDPScene;

    private LoginController loginController;
    private RegisterController registerController;
    private MainController mainController;
    private AddDPController dpController;
    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        initRootLayout();
    }

    /**
     * Changes active views
     * @param s scene to view
     * @param title window titlebar title
     */
    private void setScene(Scene s, String title) {
        stage.hide();
        stage.setScene(s);
        stage.setTitle(title);
        stage.show();
    }

    public void setLoginScene() {
        setScene(loginScene, "Login or Register");
    }

    public void setRegisterScene() {
        setScene(registerScene, "Register");
    }

    public void setMainScene(String userType) {
        setScene(mainScene, "SLS Point of Interest Tool");
        mainController.setUser(userType);
    }
    public void setAddDPScene() {
        setScene(addDPScene, "Add Datapoint");
    }

    private void initRootLayout() throws Exception {
        //FXML Loaders and layouts
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        FXMLLoader mainSceneLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        FXMLLoader dpLoader = new FXMLLoader(getClass().getResource("addPoint.fxml"));

        Pane loginLayout = loginLoader.load();
        Pane registerLayout = registerLoader.load();
        Pane mainSceneLayout = mainSceneLoader.load();
        Pane addDPLayout = dpLoader.load();
        //initialize scenes

        loginScene = new Scene(loginLayout);
        registerScene = new Scene(registerLayout);
        mainScene = new Scene(mainSceneLayout);
        addDPScene = new Scene(addDPLayout);

        //register controllers
        loginController = loginLoader.getController();
        loginController.register(this);
        registerController = registerLoader.getController();
        registerController.register(this);
        mainController = mainSceneLoader.getController();
        mainController.register(this);
        dpController = dpLoader.getController();
        dpController.register(this);
        //set opening scene

        setLoginScene();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
