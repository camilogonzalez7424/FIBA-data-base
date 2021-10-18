package controller;

import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import view.AddView;
import view.ResultView;
import view.SearchView;

public class TopBarController {

    private SearchView searchView;
    private ResultView resultView;
    private AddView addView;

    private GeneralController gController;

    public TopBarController(SearchView searchView) {
        gController = new GeneralController();
        this.searchView = searchView;
        btnAction(searchView.getRedBtn(), searchView.getYellowBtn());
        menuActions(searchView.getGoSearch(), searchView.getGoAdd(), searchView.getGoImport(), searchView);
    }

    public TopBarController(ResultView resultView) {
        gController = new GeneralController();
        this.resultView = resultView;
    }

    public TopBarController(AddView addView) {
        gController = new GeneralController();
        this.addView = addView;

    }

    private void btnAction(Circle red, Circle yellow) {
        red.setOnMouseClicked(e -> {
            System.exit(0);
        });

        yellow.setOnMouseClicked(e -> {
            System.exit(0);
        });
    }

    private void menuActions(MenuItem goSearch, MenuItem goAdd, MenuItem goImport, Stage stage){
        goSearch.setOnAction(e -> {
            Platform.runLater(() -> {
                SearchView sv = new SearchView();
                stage.close();
                sv.show();
            });
        });

        goAdd.setOnAction(e -> {
            Platform.runLater(() -> {
                AddView av = new AddView();
                stage.close();
                av.show();
            });
        });

        goImport.setOnAction(e -> {
            Platform.runLater(() -> {
                gController.alert(AlertType.INFORMATION, "En proceso", "Funcion en proceso");
            });
        });
        
    }
}
