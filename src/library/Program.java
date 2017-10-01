package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Semaphore;

/**
 * Created by user on 27.09.17.
 */
public class Program {

    static int peopleCount;
    static int maxAmount;

    public static void main(String[] args) throws IOException {

        System.out.println("Enter how many people came to the library");
        peopleCount = readNumberFromConsole();
        System.out.println("Enter max people amount at the library");
        maxAmount = readNumberFromConsole();
        final Semaphore SEMAPHORE = new Semaphore(maxAmount);

        for (int i = 0; i < peopleCount; i++){
            new Thread(new Visitor(SEMAPHORE)).start();
        }

    }

    public static int readNumberFromConsole() throws IOException {
        String string = null;
        int number = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        string = reader.readLine();

        try {
            number = Integer.parseInt(string);
        }
        catch (Exception e){
            System.out.println("It's not a number, try again");
            readNumberFromConsole();
        }
        return number;
    }
}
