package controller;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.AddView;
import view.ResultView;
import view.SearchView;

public class TopBarController {

    private GeneralController gController;

    public TopBarController(SearchView searchView) {
        gController = new GeneralController();
        btnAction(searchView.getRedBtn(), searchView.getYellowBtn());
        menuActions(searchView.getGoSearch(), searchView.getGoAdd(), searchView.getGoImport(), searchView);
    }

    public TopBarController(ResultView resultView) {
        gController = new GeneralController();
        btnAction(resultView.getRedBtn(), resultView.getYellowBtn());
        menuActions(resultView.getGoSearch(), resultView.getGoAdd(), resultView.getGoImport(), resultView);
    }

    public TopBarController(AddView addView) {
        gController = new GeneralController();
        btnAction(addView.getRedBtn(), addView.getYellowBtn());
        menuActions(addView.getGoSearch(), addView.getGoAdd(), addView.getGoImport(), addView);

    }

    private void btnAction(Circle red, Circle yellow) {
        red.setOnMouseClicked(e -> {
            System.exit(0);
        });

        yellow.setOnMouseClicked(e -> {
            System.exit(0);
        });
    }

    private void menuActions(MenuItem goSearch, MenuItem goAdd, MenuItem goImport, Stage stage) {
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
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose File");
                File file = fileChooser.showOpenDialog(stage.getScene().getWindow());

                if (file != null) {
                    gController.alert(AlertType.INFORMATION, "Ready to import", "Conectar a importar del modelo");
                }
            });
        });

    }
}
