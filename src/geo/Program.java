package geo;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 01.10.17.
 */
public class Program extends Application{

    static final double WINDOW_WIDTH = 600;
    static final double WINDOW_HEIGHT = 500;
    BorderPane borderPane = new BorderPane();
    Pane workplace = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Geometry");
        primaryStage.setResizable(false);
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);

        borderPane.setTop(addHBox());
        borderPane.setCenter(workplace);



        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 12, 10, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #8A2BE2;");

        Button b = new Button("Multy Threads");
        b.setOnAction(event -> {
            workplace.getChildren().addAll(new Rectangle(30, 30));
        });
        b.setPrefSize(150, 20);

        Button b1 = new Button("Single Thread");
        b1.setPrefSize(150, 20);
        b1.setOnAction(event -> {
            workplace.getChildren().clear();
            workplace.getChildren().addAll(addRectangle());


        });

        hbox.getChildren().addAll(b, b1);
        return hbox;
    }

    public Rectangle addRectangle(){

        Random rand = new Random();
        Color color = Color.color(
                rand.nextDouble(),
                rand.nextDouble(),
                rand.nextDouble(),
                rand.nextDouble()
        );
        Rectangle rect = new Rectangle(
                rand.nextInt((int)WINDOW_WIDTH),
                rand.nextInt((int)WINDOW_HEIGHT),
                Paint.valueOf(color.toString())
        );
        rect.setX(rand.nextInt((int)(workplace.getWidth() - rect.getWidth())));
        rect.setY(rand.nextInt((int)(workplace.getHeight() - rect.getHeight())));

        PathTransition pTrans = generatePathTransition(generatePath(rect), rect);
        pTrans.play();

        return rect;
    }

    public Path generatePath(Rectangle rectangle){

        Path path = new Path();
        Random rand = new Random();
        boolean xplus = rand.nextBoolean();
        boolean yplus = rand.nextBoolean();

        if (xplus == true && yplus == true){
            double startX = rectangle.getX();
            double startY = rectangle.getY();
            double destX = workplace.getWidth() - rectangle.getWidth();
            double destY = workplace.getHeight() - rectangle.getHeight();

        }
        else if (xplus == true && yplus == false){

        }
        else if (xplus == false && yplus == true){

        }
        else if (xplus == false && yplus == false){

        }

        return null;
    }

    public PathTransition generatePathTransition(Path path, Rectangle rectangle){

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(3000));
        pathTransition.setPath(path);
        pathTransition.setNode(rectangle);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        return pathTransition;
    }
}
