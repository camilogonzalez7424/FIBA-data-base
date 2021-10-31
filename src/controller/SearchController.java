package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.Alert.AlertType;
import model.App;
import model.DataStructure;
import model.Player;
import model.Query.queryListener;
import view.ResultView;
import view.SearchView;

public class SearchController implements queryListener, Serializable{

    private static final long serialVersionUID = 4560013;

    private SearchView view;
    private GeneralController gController;
    private ArrayList<Player> queryResult;
    private String dataStructure;

    private App app;
    private long initTime;
    private long time;

    public SearchController(SearchView searchView, App app) {
        this.app = app;
        this.view = searchView;
        this.gController = new GeneralController();
    
        queryResult = new ArrayList<>();

        btnActions();
        toggleActions();
        
    }

    private void btnActions() {

        view.getSearchBtn().setOnAction(e -> {
            String query = view.getSearchTF().getText();

            //Platform.runLater(() -> {
                if (makeQuery(query)) {
                    ResultView resultView = new ResultView(queryResult, app);
                    resultView.getController().queryLabel(time + "", dataStructure);
                    view.close();
                    resultView.show();
                    resultView.getController().initializeTableView();

                } else {
                    gController.alert(AlertType.ERROR, "Query Fail", "Please check input and the filter selection");
                }
            //});
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
            msg = "Please write the number of points";
            break;
        case "by assists":
            msg = "Please write the number of assists";
            break;
        case "by rebounds":
            msg = "Please write the number of rebounds";
            break;
        case "by steals":
            msg = "Please write the number of steals";
            break;
        case "by name":
            msg = "Please write the player name";
            break;
        case "by age":
            msg = "Please write the player age";
            break;
        case "by games":
            msg = "Please write the number of games played";
            break;
        case "by team":
            msg = "Please write the player team name";
            break;
        }
        return msg;
    }

    private boolean makeQuery(String query) {
        boolean result = false;
        Random rd = new Random();
        boolean tree = rd.nextBoolean();

        RadioButton rb = (RadioButton) view.getFilter().getSelectedToggle();
        initTime = System.currentTimeMillis();

        switch (rb.getText()) {
        case "by points":

            try {
                // app.getPointsRB().inOrderPrint(); // <--------------------------------- Check
                if (tree) {
                    app.ABBSearch(Integer.parseInt(query), app.getPointsABB(), this);
                    dataStructure = DataStructure.ABB.getDataStructure();
                } else {
                    app.RBSearch(Integer.parseInt(query), app.getPointsRB(), this);
                    dataStructure = DataStructure.RB.getDataStructure();
                }
                
                result = true;

            } catch (NumberFormatException e) {
                numberAlert();
                result = false;
            }
            break;
        case "by assists":

            try {
                if (tree) {
                    app.ABBSearch(Integer.parseInt(query), app.getAssistsABB(), this);
                    dataStructure = DataStructure.ABB.getDataStructure();
                } else {
                    app.AVLSearch(Integer.parseInt(query), app.getAssistsAVL(), this);
                    dataStructure = DataStructure.AVL.getDataStructure();
                }
                result = true;

            } catch (NumberFormatException e) {
                numberAlert();
                result = false;
            }
            break;
        case "by rebounds":

            try {
                if (tree) {
                    app.ABBSearch(Integer.parseInt(query), app.getReboundsABB(), this);
                    dataStructure = DataStructure.ABB.getDataStructure();
                } else {
                    app.AVLSearch(Integer.parseInt(query), app.getReboundsAVL(), this);
                    dataStructure = DataStructure.AVL.getDataStructure();
                }

                result = true;

            } catch (NumberFormatException e) {
                numberAlert();
                result = false;
            }
            break;
        case "by steals":

            try {
                if (tree) {
                    app.ABBSearch(Integer.parseInt(query), app.getStealsABB(), this);
                    dataStructure = DataStructure.ABB.getDataStructure();
                } else {
                    app.AVLSearch(Integer.parseInt(query), app.getStealsAVL(), this);
                    dataStructure = DataStructure.AVL.getDataStructure();
                }
                result = true;

            } catch (NumberFormatException e) {
                numberAlert();
                result = false;
            }
            break;
        case "by name":
            // resultView = new ResultView(queryResult, System.currentTimeMillis(),
            // dataStructure, app);
            app.linearSearch(query, "by name", this);
            dataStructure = DataStructure.LINEAL.getDataStructure();
            result = true;

            break;
        case "by age":
            try {

                Integer.parseInt(query);

                app.linearSearch(query, "by age", this);
                dataStructure = DataStructure.LINEAL.getDataStructure();

                result = true;

            } catch (NumberFormatException e) {
                numberAlert();
                result = false;
            }
            break;
        case "by team":

            app.linearSearch(query, "by team", this);
            dataStructure = DataStructure.LINEAL.getDataStructure();
            result = true;

            break;
        case "by games":

            try {

                Integer.parseInt(query);
                app.linearSearch(query, "by games", this);
                dataStructure = DataStructure.LINEAL.getDataStructure();
                result = true;

            } catch (NumberFormatException e) {
                numberAlert();
                result = false;
            }

            break;
        }
        return result;
    }

    private void numberAlert() {
        gController.alert(AlertType.ERROR, "Data type error", "please insert a number");
    }

    @Override
    public void onResult(ArrayList<Player> result) {
        queryResult = result;
        time = System.currentTimeMillis() - initTime;

    }

}
