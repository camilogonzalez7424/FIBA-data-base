package controller;

import javafx.application.Platform;
import view.ResultView;
import view.SearchView;

public class SearchController {

    private SearchView view;

    public SearchController(SearchView searchView) {
        this.view = searchView;
        btnActions();
    }

    private void btnActions() {
        view.getSearchBtn().setOnAction(e -> {
            Platform.runLater(() -> {
                ResultView resultView = new ResultView();
                view.close();
                resultView.show();
            });
        });
    }

}
