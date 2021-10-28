package controller;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import model.App;
import model.Player;
import model.Query.queryListener;
import view.ResultView;
import view.SearchView;

public class ResultController implements queryListener {

    private ResultView view;
    private ArrayList<Player> queryResult;
    private long initTime;
    private String structure;
    private App app;

    public ResultController(ResultView resultView, ArrayList<Player> queryResult, long initTime, String structure, App app) {
        view = resultView;
        this.queryResult = queryResult;
        this.initTime = initTime;
        this.structure = structure;
        this.app =  app;
        goBack();
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


    @Override
    public <K extends Comparable<K>, V> void onResult(ArrayList<V> result) {
        queryResult = (ArrayList<Player>) result;
        long queryTime = System.currentTimeMillis() - initTime;
        view.setTimeLabel("Searching time: " + queryTime + "Data structure: " + structure );
    }

}
