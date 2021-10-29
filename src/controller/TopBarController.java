package controller;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.App;
import view.AddView;
import view.ResultView;
import view.SearchView;

public class TopBarController {

    private GeneralController gController;
    private App app;

    public TopBarController(SearchView searchView, App app) {
        gController = new GeneralController();
        btnAction(searchView.getRedBtn(), searchView.getYellowBtn(), searchView.getStage());
        menuActions(searchView.getGoSearch(), searchView.getGoAdd(), searchView.getGoImport(), searchView);
        this.app = app;
    }

    public TopBarController(ResultView resultView, App app) {
        gController = new GeneralController();
        btnAction(resultView.getRedBtn(), resultView.getYellowBtn(), resultView.getStage());
        menuActions(resultView.getGoSearch(), resultView.getGoAdd(), resultView.getGoImport(), resultView);
        this.app = app;
    }

    public TopBarController(AddView addView, App app) {
        gController = new GeneralController();
        btnAction(addView.getRedBtn(), addView.getYellowBtn(), addView.getStage());
        menuActions(addView.getGoSearch(), addView.getGoAdd(), addView.getGoImport(), addView);
        this.app = app;
    }

    private void btnAction(Circle red, Circle yellow,  Stage stage) {
        red.setOnMouseClicked(e -> {
            System.exit(0);
        });

        yellow.setOnMouseClicked(e -> {
           stage.setIconified(true);
        });
    }

    private void menuActions(MenuItem goSearch, MenuItem goAdd, MenuItem goImport, Stage stage) {
        goSearch.setOnAction(e -> {
            Platform.runLater(() -> {
                SearchView sv = new SearchView(app);
                stage.close();
                sv.show();
            });
        });

        goAdd.setOnAction(e -> {
            Platform.runLater(() -> {
                AddView av = new AddView(app);
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
                    try {
                        app.importPlayers(file.getAbsolutePath());
                        gController.alert(AlertType.INFORMATION, "Successfully", "Data imported correctly");
                    } catch (IOException e1) {
                        gController.alert(AlertType.WARNING, "Import Fail", "An error ocurred, try again");
                        e1.printStackTrace();
                    }
                    
                }
            });
        });

    }
}
