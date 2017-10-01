package geometry.utils;

import java.util.Random;

/**
 * Created by user on 30.09.17.
 */
public class PositionGenerator {

    public static String generatePosition(double windowWidth, double windowHeight){

        Random rand1 = new Random();
        Random rand2 = new Random();




        return null;
    }

    public static double genX(double width){

        Random rand = new Random();
        int multiplier;
        if (width < 100)
            multiplier = 100;
        else if (width > 100 && width < 1000)
            multiplier = 1000;
        else
            multiplier = 10000;

        return rand.nextDouble() * multiplier;
    }

    public static double genY(double height){

        Random rand = new Random();
        int multiplier;
        if (height < 100)
            multiplier = 100;
        else if (height > 100 && height < 1000)
            multiplier = 1000;
        else
            multiplier = 10000;

        return rand.nextDouble() * multiplier;
    }
}
