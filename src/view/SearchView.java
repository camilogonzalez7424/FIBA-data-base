package view;

import java.io.IOException;

import controller.SearchController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import routes.Routes;

public class SearchView extends Stage {

    private Scene scene;
    private SearchController controller;

    // View elements
    private TextField searchTF;
    private Button searchBtn;
    private RadioButton byPoints;
    private RadioButton byAssists;
    private RadioButton byRebounds;
    private RadioButton bySteals;
    private RadioButton byName;
    private RadioButton byAge;
    private RadioButton byTeam;

    private ToggleGroup filter;

    // View general
    private Circle redBtn;
    private Circle yellowBtn;
    private MenuItem goSearch;
    private MenuItem goAdd;
    private MenuItem goImport;

    
    public SearchView(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.SEARCH_VIEW.getRoute()));
            Parent parent = loader.load();
            
            // Link elements
            redBtn = (Circle) loader.getNamespace().get("redBtn");
            yellowBtn = (Circle) loader.getNamespace().get("yellowBtn");
            goSearch = (MenuItem) loader.getNamespace().get("goSearch");
            goAdd = (MenuItem) loader.getNamespace().get("goAdd");
            goImport = (MenuItem) loader.getNamespace().get("goImport");
            

            searchTF = (TextField) loader.getNamespace().get("searchTF");
            searchBtn = (Button) loader.getNamespace().get("searchBtn");

            filter = (ToggleGroup) loader.getNamespace().get("filter");

            byPoints = (RadioButton) loader.getNamespace().get("byPoints");
            byAssists = (RadioButton) loader.getNamespace().get("byAssists");
            byRebounds = (RadioButton) loader.getNamespace().get("byRebounds");
            bySteals = (RadioButton) loader.getNamespace().get("bySteals");
            byName = (RadioButton) loader.getNamespace().get("byName");
            byAge = (RadioButton) loader.getNamespace().get("byAge");
            byTeam = (RadioButton) loader.getNamespace().get("byTeam");
            
            scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource(Routes.STYLE.getRoute()).toExternalForm());
            this.setScene(scene);
            this.initStyle(StageStyle.UNDECORATED);
            controller = new SearchController(this);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPromptText(TextField tf, String text) {
        Platform.runLater(() -> {
            tf.setPromptText(text);;
        });
    }
}

