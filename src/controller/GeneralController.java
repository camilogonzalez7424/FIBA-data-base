package controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GeneralController {
    
    public GeneralController() {
    }

    public void alert(AlertType type, String title, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.show();

        new Thread(() -> {
            try {
                Thread.sleep(2500);
                Platform.runLater(() -> {
                    alert.close();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
