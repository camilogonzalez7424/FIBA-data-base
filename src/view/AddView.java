package view;

import java.io.IOException;

import controller.AddController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import routes.Routes;

public class AddView extends Stage{
    private Scene scene;
    private AddController controller;

    // View elements
    
    public AddView(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.ADD_VIEW.getRoute()));
            Parent parent = loader.load();
            
            
            
            scene = new Scene(parent);
            this.setScene(scene);
            controller = new AddController(this);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
