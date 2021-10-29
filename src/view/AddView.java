package view;

import java.io.IOException;

import controller.AddController;
import controller.TopBarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.App;
import routes.Routes;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class AddView extends Stage{

    private Scene scene;
    private AddController controller;
    private TopBarController tController;

    // View elements
    private Label cancelLabel;
    private Button saveBtn;
    
    private TextField playerNameTF;
    private TextField teamTF;
    private TextField ageTF;
    private TextField pointsTF;
    private TextField reboundsTF;
    private TextField assistsTF;
    private TextField stealsTF;
    private TextField gamesTF;

    // View general
    private Circle redBtn;
    private Circle yellowBtn;
    private MenuItem goSearch;
    private MenuItem goAdd;
    private MenuItem goImport;
    private MenuItem clean;
    
    public AddView(App app){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.ADD_VIEW.getRoute()));
            Parent parent = loader.load();
            
             // Link elements
            redBtn = (Circle) loader.getNamespace().get("redBtn");
            yellowBtn = (Circle) loader.getNamespace().get("yellowBtn");
            goSearch = (MenuItem) loader.getNamespace().get("goSearch");
            goAdd = (MenuItem) loader.getNamespace().get("goAdd");
            goImport = (MenuItem) loader.getNamespace().get("goImport");
            clean = (MenuItem) loader.getNamespace().get("clean");

            cancelLabel = (Label) loader.getNamespace().get("cancelLabel");
            saveBtn = (Button) loader.getNamespace().get("saveBtn");

            playerNameTF = (TextField) loader.getNamespace().get("playerNameTF");
            teamTF = (TextField) loader.getNamespace().get("teamTF");
            ageTF = (TextField) loader.getNamespace().get("ageTF");
            pointsTF = (TextField) loader.getNamespace().get("pointsTF");
            reboundsTF = (TextField) loader.getNamespace().get("reboundsTF");
            assistsTF = (TextField) loader.getNamespace().get("assistsTF");
            stealsTF = (TextField) loader.getNamespace().get("stealsTF");
            gamesTF = (TextField) loader.getNamespace().get("gamesTF");
            
            scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource(Routes.STYLE.getRoute()).toExternalForm());
            this.setScene(scene);
            this.initStyle(StageStyle.UNDECORATED);
            
            controller = new AddController(this, app);
            tController = new TopBarController(this, app);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Circle getRedBtn() {
        return redBtn;
    }
    public Circle getYellowBtn() {
        return yellowBtn;
    }

    public MenuItem getGoSearch() {
        return goSearch;
    }

    public MenuItem getGoAdd() {
        return goAdd;
    }
    public MenuItem getGoImport() {
        return goImport;
    }

    public Label getCancelLabel() {
        return cancelLabel;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public TextField getPlayerNameTF() {
        return playerNameTF;
    }

    public TextField getTeamTF() {
        return teamTF;
    }

    public TextField getAgeTF() {
        return ageTF;
    }

    public TextField getPointsTF() {
        return pointsTF;
    }

    public TextField getReboundsTF() {
        return reboundsTF;
    }

    public TextField getAssistsTF() {
        return assistsTF;
    }

    public TextField getStealsTF() {
        return stealsTF;
    }

    public AddController getController() {
        return controller;
    }

    public TopBarController gettController() {
        return tController;
    }

    public Stage getStage(){
        return (Stage) scene.getWindow();
    }

    public TextField getGamesTF() {
        return gamesTF;
    }

    public MenuItem getClean() {
        return clean;
    }
    
}
