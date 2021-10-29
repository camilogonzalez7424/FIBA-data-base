package controller;

import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import model.App;
import model.Player;
import view.AddView;
import view.SearchView;

public class AddController {

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
                app.addPlayer(temp);
                gController.alert(AlertType.INFORMATION, "Success", "Player created successfully");
                goBack();
            } else {
                gController.alert(AlertType.WARNING, "Warning", "Please fill all fields");
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

}
