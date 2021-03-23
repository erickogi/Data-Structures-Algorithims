package Queues.CircularQueue;

import Queues.QueueOverflowException;
import Queues.QueueUnderflowException;

public class Operations {

    public static void main(String [] args) throws QueueOverflowException, QueueUnderflowException {

        CircularQueue<String> queue = new CircularQueue<>(String.class);
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


        System.out.println(" Is Empty : "+queue.isEmpty()+" , Is Full : "+queue.isFull()+" \n Contents : "+queue);
        queue.dequeue();
        System.out.println(" Is Empty : "+queue.isEmpty()+" , Is Full : "+queue.isFull()+" \n Contents : "+queue);
        System.out.println("Peek  After dequeue"+queue.peek());
    }
}
