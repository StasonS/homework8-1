package geometry.utils;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 30.09.17.
 */
public class ColorGenerator {

    public static String generateColor(){
        Random rand = new Random();
        Color color = Color.color(
                rand.nextDouble(),
                rand.nextDouble(),
                rand.nextDouble());
        return color.toString();
    }
}
