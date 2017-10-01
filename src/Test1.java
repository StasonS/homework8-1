import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/**
 * Created by user on 01.10.17.
 */
public class Test1 extends Application {

    BorderPane border = new BorderPane();
    Pane workplace = new Pane();


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(600);
        primaryStage.setHeight(500);

        border.setTop(addHBox());
//        border.setLeft(addVBox());
        border.setCenter(workplace);



        primaryStage.setScene(new Scene(border));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 12, 10, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        ImageView imageView = new ImageView("https://cdn3-2.cdn.schoology.com/system/files/imagecache/profile_reg/courselogos/logo-1039104352_58f0c4fe4ca60.png?1492174090");
        Button b = new Button("Image!");
        b.setOnAction(event -> {
            workplace.getChildren().clear();
            workplace.getChildren().addAll(imageView);
        });
        b.setPrefSize(100, 20);

        Button b1 = new Button("Clear!");
        b1.setPrefSize(100, 20);
        b1.setOnAction(event -> workplace.getChildren().clear());

        hbox.getChildren().addAll(b, b1);
        return hbox;
    }
}
