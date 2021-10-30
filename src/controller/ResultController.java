package controller;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import model.App;
import model.Player;
import view.ResultView;
import view.SearchView;

public class ResultController implements Serializable {

    private static final long serialVersionUID = 456544333;

    private ResultView view;
    private ArrayList<Player> queryResult;
    private App app;

    public ResultController(ResultView resultView, ArrayList<Player> queryResult, App app) {
        view = resultView;
        this.queryResult = queryResult;
        this.app =  app;
        goBack();
    }

    public void queryLabel(String time, String structure){
        view.setTimeLabel("Searching time: " + time + " // Data structure: " + structure );
    }

    private void goBack() {
        view.getCancelLabel().setOnMouseClicked((me) -> {
            Platform.runLater(() -> {
                SearchView sv = new SearchView(app);
                view.close();
                sv.show();
            });
        });
    }

    public void initializeTableView() {
        ObservableList<Player> results = FXCollections.observableList(queryResult);

        view.getNameCol().setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        view.getTeamCol().setCellValueFactory(new PropertyValueFactory<Player, String>("team"));

        view.getPointsCol().setCellValueFactory(new PropertyValueFactory<Player, Integer>("points"));
        view.getAssistsCol().setCellValueFactory(new PropertyValueFactory<Player, Integer>("assists"));
        view.getStealsCol().setCellValueFactory(new PropertyValueFactory<Player, Integer>("steals"));
        view.getAgeCol().setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
        view.getReboundsCol().setCellValueFactory(new PropertyValueFactory<Player, Integer>("rebounds"));
        view.getGamesCol().setCellValueFactory(new PropertyValueFactory<Player, Integer>("games"));

        view.getTable().setItems(results);
    }

}
