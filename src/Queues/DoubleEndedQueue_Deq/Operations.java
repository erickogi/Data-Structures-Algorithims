package Queues.DoubleEndedQueue_Deq;

import Queues.QueueOverflowException;
import Queues.QueueUnderflowException;

public class Operations {

    public static void main(String [] args) throws QueueOverflowException, QueueUnderflowException {

        Deque<String> queue = new Deque<>();
        queue.addLast("elementlast");
        queue.addLast("elementlast1");
        System.out.println(" Is Empty : "+queue.isEmpty()+" , Is Full : "+queue.isFull()+" , Size : "+queue.size()+" \n Contents : "+queue);

        queue.addFirst("elementfirst");
        queue.addFirst("elementfirst1");
        System.out.println(" Is Empty : "+queue.isEmpty()+" , Is Full : "+queue.isFull()+" , Size : "+queue.size()+" \n Contents : "+queue);
        System.out.println(" Remove Last: "+queue.removeLast());
        System.out.println(" Is Empty : "+queue.isEmpty()+" , Is Full : "+queue.isFull()+" , Size : "+queue.size()+" \n Contents : "+queue);
        System.out.println(" Remove First: "+queue.removeFirst());
        System.out.println(" Is Empty : "+queue.isEmpty()+" , Is Full : "+queue.isFull()+" , Size : "+queue.size()+" \n Contents : "+queue);
        System.out.println(" Peek  : "+queue.peekFirst());
        System.out.println(" Peek Last: "+queue.peekFirst());

    }
}
