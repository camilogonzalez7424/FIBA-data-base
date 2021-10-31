package controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import routes.Routes;
import view.AddView;
import view.ResultView;
import view.SearchView;

public class TopBarController implements Serializable, Import.listener {

    private static final long serialVersionUID = 45611122;

    private GeneralController gController;
    private App app;
    private Stage st2;
    private Stage stage;

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
            if (app.isAdded()) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                File file = fileChooser.showSaveDialog(stage);

                if (file != null) {
                    try {
                        app.update(file);
                        System.exit(0);
                    } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e1) {
                        Platform.runLater(()->{
                            gController.alert(AlertType.ERROR, "ERROR", "Data save fail");
                        });
                        e1.printStackTrace();
                    }
                }
            } else {
                System.exit(0);
            }
            
        });

        yellow.setOnMouseClicked(e -> {
            stage.setIconified(true);
        });
    }

    private void menuActions(MenuItem goSearch, MenuItem goAdd, MenuItem goImport, Stage stage, MenuItem clean) {
        goSearch.setOnAction(e -> {
            Platform.runLater(() -> {
                SearchView sv = new SearchView(app, false);
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
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose File");
            File file = fileChooser.showOpenDialog(null); // stage.getScene().getWindow() - stage
            this.stage = stage;

            if (file != null) {
                displayLoad();

                new Thread(() -> {
                    try {
                        app.importPlayers(file.getAbsolutePath(), this);
                        Platform.runLater(() -> {
                            gController.alert(AlertType.INFORMATION, "Successfully", "Data imported correctly");
                        });
                    } catch (IOException e1) {
                        Platform.runLater(() -> {
                            gController.alert(AlertType.ERROR, "ERROR", "Data imported fail");
                        });
                        e1.printStackTrace();
                    }
                }).start();
            }
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

    private void displayLoad() {

        st2 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.LOADING.getRoute()));
        Parent parent;
        try {
            parent = loader.load();
            st2.setScene(new Scene(parent));
            st2.initModality(Modality.WINDOW_MODAL);
            st2.initStyle(StageStyle.UNDECORATED);
            st2.initOwner(stage.getScene().getWindow());
            st2.setOpacity(0.85);
            st2.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onLoad() {
        Platform.runLater(() -> {
            st2.close();
        });

    }

    @Override
    public void onInit() {
        // displayLoad();
    }
}
