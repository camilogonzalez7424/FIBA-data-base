package view;

import java.io.IOException;

import controller.ResultController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import routes.Routes;

public class ResultView extends Stage {
    private Scene scene;
    private ResultController controller;

    // View elements
    
    public ResultView(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.RESULT_VIEW.getRoute()));
            Parent parent = loader.load();
            
            
            
            scene = new Scene(parent);
            this.setScene(scene);
            controller = new ResultController(this);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
