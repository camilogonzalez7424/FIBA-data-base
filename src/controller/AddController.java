package controller;

import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import view.AddView;
import view.SearchView;

public class AddController {

    private AddView view;
    private GeneralController gController;

    public AddController(AddView addView) {
        view = addView;
        gController = new GeneralController();
        goBackAction();
        saveBtn();
    }

    private void saveBtn() {
        view.getSaveBtn().setOnAction((e)->{
            if (complete()) {
                // Añadir a la Base de datos el nuevo item
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
                || view.getPlayerNameTF().getText().equals("")) {
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
            SearchView sv = new SearchView();
            view.close();
            sv.show();
        });
    }

}
