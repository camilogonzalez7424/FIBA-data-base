package view;

import java.io.IOException;

import controller.AddController;
import controller.TopBarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import routes.Routes;

public class AddView extends Stage{
    
    private Scene scene;
    private AddController controller;
    private TopBarController tController;

    // View elements
    
    public AddView(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.ADD_VIEW.getRoute()));
            Parent parent = loader.load();
            
            
            
            scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource(Routes.STYLE.getRoute()).toExternalForm());
            this.setScene(scene);
            this.initStyle(StageStyle.UNDECORATED);
            
            controller = new AddController(this);
            tController = new TopBarController(this);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
