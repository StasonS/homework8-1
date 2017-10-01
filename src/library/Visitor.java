package library;

import java.util.concurrent.Semaphore;

/**
 * Created by user on 30.09.17.
 */
public class Visitor implements Runnable{

    private static int id = 1;
    private String name;
    private static Semaphore SEMAPHORE;
    private static final Semaphore DOOR = new Semaphore(1);

    public Visitor(Semaphore semaphore) {
        this.name = "library.Visitor" + id;
        this.SEMAPHORE = semaphore;
        id++;
    }

    @Override
    public void run() {
        System.out.println(name + " came to the library");
        try {
            SEMAPHORE.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        entering();
        System.out.println(name + " entered the library");
        System.out.println(name + " is reading the book");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exiting();
        System.out.println(name + " left the library");
        SEMAPHORE.release();
    }

    private void entering(){
        System.out.println(name + " came to the door from outside");
        try {
            DOOR.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " is entering");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " walked through the door from outside");
        DOOR.release();
    }
    private void exiting(){
        System.out.println(name + " came to the door from inside");
        try {
            DOOR.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " walked through the door from inside");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " exited");
        DOOR.release();
    }
}
