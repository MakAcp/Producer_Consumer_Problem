package reflection.Exceptions.BlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    private static BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        
        Runnable p = () ->{
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    
        Thread mythread = new Thread(p);

        Runnable c = () ->{
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread mythread1 = new Thread(c);

        mythread.start();
        mythread1.start();
        
    }

    public static void produce() throws InterruptedException{
        while(true){
        Thread.sleep(2000);
        Random r= new Random();
        int x = r.nextInt(100);
        q.put(x);
        System.out.println("Random number "+x+" has been produced ");
        }
    }

    public static void consume() throws InterruptedException{
        
        while(true){
        Thread.sleep(2000);
        int z =q.take();
        System.out.println("Random number "+z+" has been consume ");
        }
    }
}
