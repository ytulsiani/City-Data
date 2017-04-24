package fxapp;

import controller.*;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MainFXApp extends Application {

    private Stage stage;

    public static String userType;
    public static String user;


    private Scene loginScene;
    private Scene registerScene;
    private Scene mainScene;
    private Scene addDPScene;
    private Scene addLocationScene;
    private Scene filterScene;
    private Scene poiReportScene;
    private Scene pendingDPScene;
    private Scene pendingCOScene;
    private Scene poiDetailScene;

    private LoginController loginController;
    private RegisterController registerController;
    private MainController mainController;
    private AddDPController dpController;
    private AddLocationController addLocationController;
    private FilterPOIController filterPOIController;
    private POIReportController poiReportController;
    private PendingDPController pendingDPController;
    private PendingCOController pendingCOController;
    private POIDetailController poiDetailController;

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

    public void setMainScene(String userType, String user) {
        setScene(mainScene, "SLS Point of Interest Tool");
        mainController.setUser(userType);
        this.userType = userType;
        this.user = user;
    }
    public void setAddDPScene() {
        setScene(addDPScene, "Add Datapoint");
    }
    public void setAddLocationScene() {
        setScene(addLocationScene, "Add Location");
    }
    public void setFilterPOIScene() {
        setScene(filterScene, "Filter POI");
    }
    public void setPOIReportScene() throws SQLException {
        setScene(poiReportScene, "POI Report");
        poiReportController.loadData();
    }

    public void setPendingDPScene() throws SQLException{
        setScene(pendingDPScene, "Pending Datapoints");
        pendingDPController.loadData();
    }

    public void setPendingCOScene() throws SQLException {
        setScene(pendingCOScene, "Pending City Officials");
        pendingCOController.loadData();
    }

    public void setPOIDetailScene(POI point) throws SQLException {
        setScene(poiDetailScene, "POI Detail");
        poiDetailController.loadPoint(point);
    }


    private void initRootLayout() throws Exception {
        //FXML Loaders and layouts
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        FXMLLoader mainSceneLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        FXMLLoader dpLoader = new FXMLLoader(getClass().getResource("addPoint.fxml"));
        FXMLLoader addLocationLoader = new FXMLLoader(getClass().getResource("addLocation.fxml"));
        FXMLLoader filterPOILoader = new FXMLLoader(getClass().getResource("filterPOI.fxml"));
        FXMLLoader poiReportLoader = new FXMLLoader(getClass().getResource("POIReport.fxml"));
        FXMLLoader pendingDPLoader = new FXMLLoader(getClass().getResource("pendingDP.fxml"));
        FXMLLoader pendingCOLoader = new FXMLLoader(getClass().getResource("pendingCO.fxml"));
        FXMLLoader poiDetailLoader = new FXMLLoader(getClass().getResource("POIDetail.fxml"));

        Pane loginLayout = loginLoader.load();
        Pane registerLayout = registerLoader.load();
        Pane mainSceneLayout = mainSceneLoader.load();
        Pane addDPLayout = dpLoader.load();
        Pane addLocationLayout = addLocationLoader.load();
        Pane filterPOILayout = filterPOILoader.load();
        Pane poiReportLayout = poiReportLoader.load();
        Pane pendingDPLayout = pendingDPLoader.load();
        Pane pendingCOLayout = pendingCOLoader.load();
        Pane poiDetailLayout = poiDetailLoader.load();

        //initialize scenes

        loginScene = new Scene(loginLayout);
        registerScene = new Scene(registerLayout);
        mainScene = new Scene(mainSceneLayout);
        addDPScene = new Scene(addDPLayout);
        addLocationScene = new Scene(addLocationLayout);
        filterScene = new Scene(filterPOILayout);
        poiReportScene = new Scene(poiReportLayout);
        pendingDPScene = new Scene(pendingDPLayout);
        pendingCOScene = new Scene(pendingCOLayout);
        poiDetailScene = new Scene(poiDetailLayout);

        //register controllers
        loginController = loginLoader.getController();
        loginController.register(this);
        registerController = registerLoader.getController();
        registerController.register(this);
        mainController = mainSceneLoader.getController();
        mainController.register(this);
        dpController = dpLoader.getController();
        dpController.register(this);
        addLocationController = addLocationLoader.getController();
        addLocationController.register(this);
        filterPOIController = filterPOILoader.getController();
        filterPOIController.register(this);
        poiReportController = poiReportLoader.getController();
        poiReportController.register(this);
        pendingDPController = pendingDPLoader.getController();
        pendingDPController.register(this);
        pendingCOController = pendingCOLoader.getController();
        pendingCOController.register(this);
        poiDetailController = poiDetailLoader.getController();
        poiDetailController.register(this);

        //set opening scene
        setLoginScene();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
