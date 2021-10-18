package view;

import java.io.IOException;

import controller.SearchController;
import controller.TopBarController;
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
    private TopBarController tController;

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
            tController = new TopBarController(this);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPromptText(TextField tf, String text) {
        Platform.runLater(() -> {
            tf.setPromptText(text);;
        });
    }

    public TextField getSearchTF() {
        return searchTF;
    }

    public void setSearchTF(TextField searchTF) {
        this.searchTF = searchTF;
    }

    public Button getSearchBtn() {
        return searchBtn;
    }

    public void setSearchBtn(Button searchBtn) {
        this.searchBtn = searchBtn;
    }

    public RadioButton getByPoints() {
        return byPoints;
    }

    public void setByPoints(RadioButton byPoints) {
        this.byPoints = byPoints;
    }

    public RadioButton getByAssists() {
        return byAssists;
    }

    public void setByAssists(RadioButton byAssists) {
        this.byAssists = byAssists;
    }

    public RadioButton getByRebounds() {
        return byRebounds;
    }

    public void setByRebounds(RadioButton byRebounds) {
        this.byRebounds = byRebounds;
    }

    public RadioButton getBySteals() {
        return bySteals;
    }

    public void setBySteals(RadioButton bySteals) {
        this.bySteals = bySteals;
    }

    public RadioButton getByName() {
        return byName;
    }

    public void setByName(RadioButton byName) {
        this.byName = byName;
    }

    public RadioButton getByAge() {
        return byAge;
    }

    public void setByAge(RadioButton byAge) {
        this.byAge = byAge;
    }

    public RadioButton getByTeam() {
        return byTeam;
    }

    public void setByTeam(RadioButton byTeam) {
        this.byTeam = byTeam;
    }

    public ToggleGroup getFilter() {
        return filter;
    }

    public void setFilter(ToggleGroup filter) {
        this.filter = filter;
    }

    public Circle getRedBtn() {
        return redBtn;
    }

    public void setRedBtn(Circle redBtn) {
        this.redBtn = redBtn;
    }

    public Circle getYellowBtn() {
        return yellowBtn;
    }

    public void setYellowBtn(Circle yellowBtn) {
        this.yellowBtn = yellowBtn;
    }

    public MenuItem getGoSearch() {
        return goSearch;
    }

    public void setGoSearch(MenuItem goSearch) {
        this.goSearch = goSearch;
    }

    public MenuItem getGoAdd() {
        return goAdd;
    }

    public void setGoAdd(MenuItem goAdd) {
        this.goAdd = goAdd;
    }

    public MenuItem getGoImport() {
        return goImport;
    }

    public void setGoImport(MenuItem goImport) {
        this.goImport = goImport;
    }

    
}

