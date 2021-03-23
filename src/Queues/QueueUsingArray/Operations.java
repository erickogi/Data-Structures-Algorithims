package Queues.QueueUsingArray;

import Queues.QueueOverflowException;
import Queues.QueueUnderflowException;

public class Operations {

    public static void main(String [] args) throws QueueOverflowException, QueueUnderflowException {

        Queue<String> queue = new Queue<>(String.class);
        queue.enqueue("element1");
        queue.enqueue("element2");
        queue.enqueue("element3");
        queue.enqueue("element3");
        queue.enqueue("element3");
        queue.enqueue("element3");
        queue.enqueue("element3");
        queue.enqueue("element3");
        queue.enqueue("element3");
        queue.enqueue("element3");


        System.out.println(" Is Empty : "+queue.isEmpty()+" , Is Full : "+queue.isFull()+" , Size : "+queue.size()+" \n Contents : "+queue);
        queue.dequeue();
        System.out.println(" Is Empty : "+queue.isEmpty()+" , Is Full : "+queue.isFull()+" , Size : "+queue.size()+" \n Contents : "+queue);

    }
}
