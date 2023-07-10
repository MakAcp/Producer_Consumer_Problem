package reflection.Exceptions.BlockingQueue;

import java.util.LinkedList;

public class Table{

     LinkedList<Integer> ll = new LinkedList<>();
     int capacity = 2;

    public void produce() throws InterruptedException{
        int value=0;
        while(true){
        synchronized(this){
            while(ll.size()>capacity){
                wait();
            }

            ll.add(value++);
            System.out.println(ll);

            notify();

            Thread.sleep(1000);

        }   
      }
    }

        public void consume() throws InterruptedException{
        while(true){
        synchronized(this){
            while(ll.size()==0){
                wait();
            }

            int x= ll.removeFirst();
            System.out.println(x);
            notify();

            Thread.sleep(1000);

        }   
      }
    }
}
