package main;



import javafx.application.Application;
import javafx.stage.Stage;
import view.SearchView;

public class Main extends Application {
    
    public static void main(String[] args){
        launch(args);

    }


    @Override
    public void start(Stage primaryStage)throws Exception{
        
        SearchView view = new SearchView();
		view.show();

    }
       
}
