package view;

import java.io.IOException;
import java.util.ArrayList;

import controller.ResultController;
import controller.TopBarController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.App;
import model.Player;
import routes.Routes;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.shape.Circle;

public class ResultView extends Stage {

    private Scene scene;
    private ResultController controller;
    private TopBarController tController;

    // View elements
    private Label cancelLabel;
    private Button exportBtn;

    private TableView<Player> table;
    private TableColumn<Player, String> nameCol;
    private TableColumn<Player, Integer> ageCol;
    private TableColumn<Player, String> teamCol;
    private TableColumn<Player, Integer> pointsCol;
    private TableColumn<Player, Integer> stealsCol;
    private TableColumn<Player, Integer> assistsCol;
    private TableColumn<Player, Integer> reboundsCol;
    private TableColumn<Player, Integer> gamesCol;

    private Label timeLabel;

    // View general
    private Circle redBtn;
    private Circle yellowBtn;
    private MenuItem goSearch;
    private MenuItem goAdd;
    private MenuItem goImport;
    
    @SuppressWarnings("unchecked")
    public ResultView(ArrayList<Player> queryResult, App app){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.RESULT_VIEW.getRoute()));
            Parent parent = loader.load();
            
            // Link elements
            redBtn = (Circle) loader.getNamespace().get("redBtn");
            yellowBtn = (Circle) loader.getNamespace().get("yellowBtn");
            goSearch = (MenuItem) loader.getNamespace().get("goSearch");
            goAdd = (MenuItem) loader.getNamespace().get("goAdd");
            goImport = (MenuItem) loader.getNamespace().get("goImport");

            cancelLabel = (Label) loader.getNamespace().get("cancelLabel");
            exportBtn = (Button) loader.getNamespace().get("exportBtn");
            exportBtn.setVisible(false);

            
            table = (TableView<Player>) loader.getNamespace().get("table");
            nameCol = (TableColumn<Player, String>) loader.getNamespace().get("nameCol");
            ageCol = (TableColumn<Player, Integer>) loader.getNamespace().get("ageCol");
            teamCol = (TableColumn<Player, String>) loader.getNamespace().get("teamCol");
            pointsCol = (TableColumn<Player, Integer>) loader.getNamespace().get("pointsCol");
            stealsCol = (TableColumn<Player, Integer>) loader.getNamespace().get("stealsCol");
            assistsCol = (TableColumn<Player, Integer>) loader.getNamespace().get("assistsCol");
            reboundsCol = (TableColumn<Player, Integer>) loader.getNamespace().get("reboundsCol");
            gamesCol = (TableColumn<Player, Integer>) loader.getNamespace().get("gamesCol");

            timeLabel = (Label) loader.getNamespace().get("timeLabel");
            
            scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource(Routes.STYLE.getRoute()).toExternalForm());
            this.setScene(scene);
            this.initStyle(StageStyle.UNDECORATED);
            
            controller = new ResultController(this, queryResult, app);
            tController = new TopBarController(this, app);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTimeLabel(String text) {
        Platform.runLater(() -> {
            timeLabel.setText(text);
        });
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

    public Button getExportBtn() {
        return exportBtn;
    }

    public TableView<Player> getTable() {
        return table;
    }

    public TableColumn<Player, String> getNameCol() {
        return nameCol;
    }

    public TableColumn<Player, Integer> getAgeCol() {
        return ageCol;
    }

    public TableColumn<Player, String> getTeamCol() {
        return teamCol;
    }

    public TableColumn<Player, Integer> getPointsCol() {
        return pointsCol;
    }

    public TableColumn<Player, Integer> getStealsCol() {
        return stealsCol;
    }

    public TableColumn<Player, Integer> getAssistsCol() {
        return assistsCol;
    }

    public TableColumn<Player, Integer> getReboundsCol() {
        return reboundsCol;
    }

    public ResultController getController() {
        return controller;
    }

    public TopBarController gettController() {
        return tController;
    }

    public TableColumn<Player, Integer> getGamesCol() {
        return gamesCol;
    }

    public Stage getStage(){
        return (Stage) scene.getWindow();
    }

    public Label getTimeLabel() {
        return timeLabel;
    }
    
}
