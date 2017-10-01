package geometry1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by user on 30.09.17.
 */
public class Program extends Application{

    final double WIDTH = 500;
    final double HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Geometry");
        primaryStage.setResizable(false);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        Pane root = new Pane();





        root.getChildren().addAll();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
