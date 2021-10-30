package controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

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

public class TopBarController implements Serializable {

    private static final long serialVersionUID = 45611122;

    private GeneralController gController;
    private App app;

    public TopBarController(SearchView searchView, App app) {
        gController = new GeneralController();
        btnAction(searchView.getRedBtn(), searchView.getYellowBtn(), searchView.getStage());
        menuActions(searchView.getGoSearch(), searchView.getGoAdd(), searchView.getGoImport(), searchView,
                searchView.getClean());
        this.app = app;
    }

    public TopBarController(ResultView resultView, App app) {
        gController = new GeneralController();
        btnAction(resultView.getRedBtn(), resultView.getYellowBtn(), resultView.getStage());
        menuActions(resultView.getGoSearch(), resultView.getGoAdd(), resultView.getGoImport(), resultView,
                resultView.getClean());
        this.app = app;
    }

    public TopBarController(AddView addView, App app) {
        gController = new GeneralController();
        btnAction(addView.getRedBtn(), addView.getYellowBtn(), addView.getStage());
        menuActions(addView.getGoSearch(), addView.getGoAdd(), addView.getGoImport(), addView, addView.getClean());
        this.app = app;
    }

    private void btnAction(Circle red, Circle yellow, Stage stage) {
        red.setOnMouseClicked(e -> {
            System.exit(0);
        });

        yellow.setOnMouseClicked(e -> {
            stage.setIconified(true);
        });
    }

    private void menuActions(MenuItem goSearch, MenuItem goAdd, MenuItem goImport, Stage stage, MenuItem clean) {
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
                    Platform.runLater(() -> {
                        try {
                            app.importPlayers(file.getAbsolutePath());

                            gController.alert(AlertType.INFORMATION, "Successfully", "Data imported correctly");
                        } catch (IOException e1) {

                            gController.alert(AlertType.WARNING, "Import Fail", "An error ocurred, try again");

                            e1.printStackTrace();
                        }
                    });
                }
            });
        });

        clean.setOnAction((e) -> {
            try {
                app.clean();
                Platform.runLater(() -> {
                    gController.alert(AlertType.INFORMATION, "Success", "Data Base cleaned");
                });
            } catch (IOException e1) {
                Platform.runLater(() -> {
                    gController.alert(AlertType.ERROR, "Error", "Clean fail");
                });

                e1.printStackTrace();
            }
        });
    }
}
