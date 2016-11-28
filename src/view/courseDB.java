package view;/**
 * Created by jlipecki on 2016-11-28.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import main.courseDbQueries;

public class courseDB extends Application implements courseDbQueries {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        primaryStage.show();

    }
}
