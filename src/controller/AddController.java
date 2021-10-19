package controller;

import javafx.application.Platform;
import view.AddView;
import view.SearchView;

public class AddController {

    private AddView view;

    public AddController(AddView addView) {
        view = addView;
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
    
}
