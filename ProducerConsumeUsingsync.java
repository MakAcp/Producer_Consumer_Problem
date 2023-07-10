package reflection.Exceptions.BlockingQueue;
import reflection.Exceptions.BlockingQueue.Table;
import java.util.LinkedList;

public class ProducerConsumeUsingsync {

    
    public static void main(String[] args) {
        Table t= new Table();
        Runnable p = () ->{
            try {
               
                t.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    
        Thread mythread = new Thread(p);

        Runnable c = () ->{
            try {
                t.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread mythread1 = new Thread(c);

        mythread.start();
        mythread1.start();


    }
}
