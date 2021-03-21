package LinkedLists.Circular;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(T data){
        //Create a node with the data
        Node<T> node = new Node<T>(data);
        if(head ==null){
            tail = node;
        }

        node.setNext(head);
        head = node;
        tail.setNext(head);

        size++;

    }

    public int countNodes(){
        //create  store for curr . Initialize it to the linkedlist head
        Node<T> curr = head;
        //Creat a store for the count
        int count = 0;

       while (curr != tail){
            curr = curr.getNext();
            //Increment count
            count++;
        }
        //Return the count
        return count+1;
    }


    //Return & Remove the first element of the list
    public T pop(){
        //IF list is empty, return null
        if(head == null){
            return null;
        }

        //Store the first element(head) of the list
        Node<T> first = head;

        //Remove the first(head) element of the list by changing head to be the second element of the list ie change head to head is current head's next
        head = head.getNext();

        //return previously first element's data
        //Decrement size of list
        size--;
        return first.getData();
    }



    public boolean contains(T data){
      //Traverse the list while comparing current node of the traversal to the given data. If similar, return true else if at end, return false

        //Store current node of the traversal At first this is Head of list
        Node<T> curr = head;

        while (curr != null){
            if(curr.getData().equals(data)){
                return true;
            }
            curr = curr.getNext();
        }
        //We are at the end without finding the data
        return  false;
    }

    public void delete(T data){

        Node<T> curr = head;
        Node<T> prev = tail;

        if (head == null && tail == null){
            return;
        }
        while (true){

             if(curr.getData().equals(data)){
                if(head == tail){
                    size--;
                    head = null;
                    tail = null;
                    break;

                }
                if(prev == tail){
                    head = head.getNext();
                }
                if(curr == tail){
                    tail = prev;
                }
                 size--;
                prev.setNext(curr.getNext());
                break;

            }
             if(curr == tail){
                 break;
             }
            prev =curr;
            curr = curr.getNext();
        }

    }

    public List<T> findAllLessThan(T data){
        //We need to traverse and add each element to a list if it is less than given data
        List<T> returnList = new ArrayList<>();

        Node<T> curr = head;

        while (curr!=null){
            if(curr.getData().compareTo(data)<0){
                returnList.add(curr.getData());
            }
            curr = curr.getNext();
        }
        return returnList;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        Node<T> curr = head;

        //NOTE : Iterate over the elements in the linked list till you reach the tail
        while (curr != tail) {
            sb.append(curr.toString() + "->");
            curr = curr.getNext();
        }

        if(tail != null){
            sb.append(tail.toString());
        }

        //NOTE: Display the head and tail of the circular linked list as well
        sb.append("\nHead "+head+" Tail "+tail);
        return sb.toString();
    }
}
