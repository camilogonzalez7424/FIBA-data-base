package controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.Alert.AlertType;
import view.ResultView;
import view.SearchView;

public class SearchController {

    private SearchView view;
    private GeneralController gController;

    public SearchController(SearchView searchView) {
        this.view = searchView;
        this.gController = new GeneralController();
        btnActions();
        toggleActions();
    }

    private void btnActions() {

        view.getSearchBtn().setOnAction(e -> {
            String query = view.getSearchTF().getText();

            if (makeQuery(query)) {

                Platform.runLater(() -> {
                    ResultView resultView = new ResultView();
                    view.close();
                    resultView.show();
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
