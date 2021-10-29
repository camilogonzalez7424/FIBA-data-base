package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.App;
import view.SearchView;

public class Main extends Application {

    private static App app;

    public static void main(String[] args) {
        app = new App();

        launch(args);

    }

    // Buscar points 36, Team Miami Heat, Games 21

    @Override
    public void start(Stage primaryStage) throws Exception {

        SearchView view = new SearchView(app);
        view.show();

    }

}
