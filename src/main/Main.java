package main;

import java.util.Arrays;

import collections.ABB.ABB;
import javafx.application.Application;
import javafx.stage.Stage;
import model.App;
import view.SearchView;

public class Main extends Application {

    private static App app;

    public static void main(String[] args) {
        app = new App();

        /* ABB<Integer, String> test = new ABB<>();
        test.insert(5, "A");
        test.insert(2, "B");
        test.insert(5, "C");
        test.insert(3, "D");
        test.insert(5, "E");
        test.insert(2, "F");
        test.inOrderPrint();

        System.out.println(Arrays.toString(test.search(5).toArray())); */
        launch(args);

    }

    // Buscar points 36, Team Miami Heat, Games 21

    @Override
    public void start(Stage primaryStage) throws Exception {

        SearchView view = new SearchView(app);
        view.show();

    }

}
