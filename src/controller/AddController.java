package controller;

import java.io.IOException;
import java.io.Serializable;

import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import model.App;
import model.Player;
import view.AddView;
import view.SearchView;

public class AddController implements Serializable {

    private static final long serialVersionUID = 424311543;

    private AddView view;
    private GeneralController gController;
    private App app;

    public AddController(AddView addView, App app) {
        view = addView;
        this.app = app;
        gController = new GeneralController();
        goBackAction();
        saveBtn();
    }

    private void saveBtn() {
        view.getSaveBtn().setOnAction((e)->{
            if (complete()) {

                String name = view.getPlayerNameTF().getText();
                String team = view.getTeamTF().getText();

                int age = Integer.parseInt(view.getAgeTF().getText());
                int points = Integer.parseInt(view.getPointsTF().getText());
                int rebounds = Integer.parseInt(view.getReboundsTF().getText());
                int assists = Integer.parseInt(view.getAssistsTF().getText());
                int steals = Integer.parseInt(view.getStealsTF().getText());
                int games = Integer.parseInt(view.getGamesTF().getText());

                Player temp = new Player(name, age, team, points, rebounds, assists, steals, games);
                try {
                    app.addPlayer(temp);
                } catch (IOException e1) {
                    displayAlert(AlertType.ERROR, "Error", "Add fail");
                    e1.printStackTrace();
                }
                
                new Thread(()->{
                    try {
                        Platform.runLater(()->{
                            displayAlert(AlertType.INFORMATION, "Success", "Player created successfully");
                        });
                        
                        Thread.sleep(3000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    goBack();
                }).run();
                
            } else {
                displayAlert(AlertType.WARNING, "Warning", "Please fill all fields");
            }
        });
        
    }

    private boolean complete() {
        if (view.getAgeTF().getText().equals("") || view.getAssistsTF().getText().equals("")
                || view.getPointsTF().getText().equals("") || view.getTeamTF().getText().equals("")
                || view.getStealsTF().getText().equals("") || view.getReboundsTF().getText().equals("")
                || view.getPlayerNameTF().getText().equals("") || view.getGamesTF().getText().equals(""))  {
            return false;
        } else {
            return true;
        }
    }

    private void goBackAction() {
        view.getCancelLabel().setOnMouseClicked((me) -> {
            goBack();
        });
    }

    private void goBack(){
        Platform.runLater(() -> {
            SearchView sv = new SearchView(app);
            view.close();
            sv.show();
        });
    }

    private void displayAlert(AlertType type, String title, String msg ){
        Platform.runLater(()->{
            gController.alert(type, title, msg);
        });
    }

}
