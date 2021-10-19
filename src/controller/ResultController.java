package controller;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Player;
import view.ResultView;
import view.SearchView;

public class ResultController {

    private ResultView view;
    private ArrayList<Player> queryResult;

    public ResultController(ResultView resultView, ArrayList<Player> queryResult) {
        view = resultView;
        this.queryResult = queryResult;

        goBack();
    }

    private void goBack() {
        view.getCancelLabel().setOnMouseClicked((me) -> {
            Platform.runLater(() -> {
                SearchView sv = new SearchView();
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

        view.getTable().setItems(results);
    }

}
