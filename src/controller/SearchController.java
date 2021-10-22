package controller;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.Alert.AlertType;
import model.Player;
import view.ResultView;
import view.SearchView;

public class SearchController {

    private SearchView view;
    private GeneralController gController;
    private ArrayList<Player> queryResult;

    public SearchController(SearchView searchView) {
        this.view = searchView;
        this.gController = new GeneralController();

        queryResult = new ArrayList<>();
        queryResult.add(new Player(45, "Pedro", "Bulls", 23, 5, 4, 10, 30,12));
        queryResult.add(new Player(18, "Rodrigo", "Celtics", 30, 11, 6, 7, 27,15));
        queryResult.add(new Player(34, "Andres", "Heat", 27, 2, 8, 14, 40,24));

        btnActions();
        toggleActions();
    }

    private void btnActions() {

        view.getSearchBtn().setOnAction(e -> {
            String query = view.getSearchTF().getText();

            if (makeQuery(query)) {

                Platform.runLater(() -> {
                    ResultView resultView = new ResultView(queryResult);
                    view.close();
                    resultView.show();
                    resultView.getController().initializeTableView();
                });
            } else {
                gController.alert(AlertType.ERROR, "Query Fail", "Please check input and the filter selection");
            }
        });

    }

    private void toggleActions() {

        view.getFilter().selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {

                RadioButton rb = (RadioButton) view.getFilter().getSelectedToggle();

                if (rb != null) {
                    String key = rb.getText();
                    view.setPromptText(changeTextPrompt(key));
                }
            }
        });
    }

    private String changeTextPrompt(String key) {
        String msg = "";

        switch (key) {
            case "by points":
                msg = "Please write the range of points #-# (without space)";
                break;
            case "by assists":
                msg = "Please write the range of assists #-# (without space)";
                break;
            case "by rebounds":
                msg = "Please write the range of rebounds #-# (without space)";
                break;
            case "by steals":
                msg = "Please write the range of steals #-# (without space)";
                break;
            case "by name":
                msg = "Please write the player name";
                break;
            case "by age":
                msg = "Please write the player age";
                break;
            case "by team":
                msg = "Please write the player team name";
                break;
        }
        return msg;
    }

    private boolean makeQuery(String query) {
        boolean result = false;

        RadioButton rb = (RadioButton) view.getFilter().getSelectedToggle();

        switch (rb.getText()) {
            case "by points":
                String[] parts = query.split("-");

                try {
                    int inf = Integer.parseInt(parts[0]);
                    int sup = Integer.parseInt(parts[1]);

                    // Realizar la consulta

                } catch (NumberFormatException e) {
                    result = false;
                }
                break;
            case "by assists":
                parts = query.split("-");

                try {
                    int inf = Integer.parseInt(parts[0]);
                    int sup = Integer.parseInt(parts[1]);

                    // Realizar la consulta

                } catch (NumberFormatException e) {
                    result = false;
                }
                break;
            case "by rebounds":
                parts = query.split("-");

                try {
                    int inf = Integer.parseInt(parts[0]);
                    int sup = Integer.parseInt(parts[1]);

                    // Realizar la consulta

                } catch (NumberFormatException e) {
                    result = false;
                }
                break;
            case "by steals":
                parts = query.split("-");

                try {
                    int inf = Integer.parseInt(parts[0]);
                    int sup = Integer.parseInt(parts[1]);

                    // Realizar la consulta

                } catch (NumberFormatException e) {
                    result = false;
                }
                break;
            case "by name":

                // Realizar la consulta
                result = true;

                break;
            case "by age":
                try {

                    int age = Integer.parseInt(query);

                } catch (NumberFormatException e) {
                    result = false;
                }
                break;
            case "by team":

                // Realizar la consulta

                break;
        }
        return result;
    }

}
