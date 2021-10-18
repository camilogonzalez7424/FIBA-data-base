package view;

import java.io.IOException;

import controller.ResultController;
import controller.TopBarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import routes.Routes;

public class ResultView extends Stage {
    
    private Scene scene;
    private ResultController controller;
    private TopBarController tController;

    // View elements
    
    public ResultView(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.RESULT_VIEW.getRoute()));
            Parent parent = loader.load();
            
            
            
            scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource(Routes.STYLE.getRoute()).toExternalForm());
            this.setScene(scene);
            this.initStyle(StageStyle.UNDECORATED);
            
            controller = new ResultController(this);
            tController = new TopBarController(this);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
