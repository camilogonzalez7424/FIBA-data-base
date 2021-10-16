package ui;


import controller.MainGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import routes.Routes;

public class Main extends Application {
    
    public static void main(String[] args){
        launch(args);

    }


    @Override
    public void start(Stage primaryStage)throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Routes.MAIN_VIEW.getRoute()));
        MainGUI gui = new MainGUI();

        fxmlLoader.setController(gui);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FIBA Data Base");
        //primaryStage.setResizable(false);
        primaryStage.show();


    }
       
}
