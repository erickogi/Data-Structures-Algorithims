package Queues.PriorityQueue;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Operations {



    public static void main(String [] args)  {
        Comparator<String> descendingComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2) *-1;
            }
        };
        //lEXICOGRAPHICAL ORDER
        PriorityQueue<String> queue = new PriorityQueue<>(descendingComparator);
        queue.add("element1");
        queue.add("element2");
        queue.add("element3");
        queue.add("element3");
        queue.add("element3");
        queue.add("element3");
        queue.add("element3");
        queue.add("element3j");
        queue.add("element3p");
        queue.add("element3l");


        System.out.println(" Is Empty : "+queue.isEmpty()+" , Size : "+queue.size()+" \n Contents : "+queue);
        queue.poll();
        System.out.println(" Is Empty : "+queue.isEmpty()+" , Size : "+queue.size()+" \n Contents : "+queue);
        queue.remove();
        System.out.println(" Is Empty : "+queue.isEmpty()+" , Size : "+queue.size()+" \n Contents : "+queue);
        System.out.println(" Peek: "+queue.peek());
        System.out.println(" Is Empty : "+queue.isEmpty()+"  , Size : "+queue.size()+" \n Contents : "+queue);
    }
}
