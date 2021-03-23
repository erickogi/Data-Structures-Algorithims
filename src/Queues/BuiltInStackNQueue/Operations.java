package Queues.BuiltInStackNQueue;


import java.util.LinkedList;
import java.util.Queue;

public class Operations {

    public static void main(String [] args)  {

        Queue<String> queue = new LinkedList<>();
        queue.add("element1");
        queue.add("element2");
        queue.add("element3");
        queue.add("element3");
        queue.add("element3");
        queue.add("element3");
        queue.add("element3");
        queue.add("element3");
        queue.add("element3");
        queue.add("element3");


        System.out.println(" Is Empty : "+queue.isEmpty()+" , Size : "+queue.size()+" \n Contents : "+queue);
        queue.poll();
        System.out.println(" Is Empty : "+queue.isEmpty()+" , Size : "+queue.size()+" \n Contents : "+queue);
        queue.remove();
        System.out.println(" Is Empty : "+queue.isEmpty()+" , Size : "+queue.size()+" \n Contents : "+queue);
        System.out.println(" Peek: "+queue.peek());
        System.out.println(" Is Empty : "+queue.isEmpty()+"  , Size : "+queue.size()+" \n Contents : "+queue);
    }
}
