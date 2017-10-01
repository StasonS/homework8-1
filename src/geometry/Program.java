package geometry;

import geometry.utils.ColorGenerator;
import geometry.utils.PositionGenerator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

/**
 * Created by user on 30.09.17.
 */
public class Program extends Application {

    double windowWidth = 500;
    double windowHeight = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Geometry");
        primaryStage.setWidth(windowWidth);
        primaryStage.setHeight(windowHeight);

        Pane root = new Pane();


        Button button = addButton(20, 20, "Multy Threads");
        button.setOnAction(event -> {
            root.getChildren().addAll(addRectangle());
        });

//        PathTransition pathTransition = new PathTransition();
//        pathTransition.setNode(button);
//        pathTransition.setDuration(Duration.seconds(5));
//        pathTransition.setPath(new Rectangle(300, 100));
//        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//        pathTransition.setCycleCount(PathTransition.INDEFINITE);
//        pathTransition.play();

        root.getChildren().addAll(button);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
//        Random rand = new Random(600);
//        for (int i = 0; i < 100; i++)
//            System.out.println(rand.nextDouble() * 100);

    }

    public Button addButton(double X, double Y, String text){

        Button button = new Button(text);
        button.setLayoutX(X);
        button.setLayoutY(Y);

        button.setOnAction(event -> {
            Random random = new Random(7);
            int countOfRect = random.nextInt() + 3;
            for (int i = 0; i < countOfRect; i++){
                //здесь запускается движение прямоугольников

            }
        });

        return button;
    }

    public Rectangle addRectangle(){

        Random rand = new Random();
        Rectangle rect = new Rectangle();
        rect.setFill(Paint.valueOf(ColorGenerator.generateColor()));
        rect.setLayoutX(PositionGenerator.genX(windowWidth));
        rect.setLayoutY(PositionGenerator.genY(windowHeight));
        rect.setWidth(60);
        rect.setHeight(50);


        return rect;
    }
}

