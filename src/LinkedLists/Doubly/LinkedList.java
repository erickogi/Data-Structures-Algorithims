package LinkedLists.Doubly;

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

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public void insertAtHead(T data){
        Node<T> node = new Node<T>(data);

        if(head==null){
            head = node;
            tail = node;

            return;
        }

        size++;
        node.setNext(head);
        head.setPrevious(node);
        head = node;

    }

    public int countNodes(){
        //create  store for curr . Initialize it to the linkedlist head
        Node<T> curr = head;
        //Creat a store for the count
        int count = 0;

        //Use a while loop to traverse
        //If curr node is not null set curr node to be next of current node and repeat untill curr is null (You are at the end of the list)
        while (curr != null){
            curr = curr.getNext();
            //Increment count
            count++;
        }
        //Return the count
        return count;
    }

    public void insertAtTail(T data){
       Node<T> node = new Node<T>(data);

        if(head==null){
            head = node;
            tail = node;
            return;
        }

        tail.setNext(node);
        node.setPrevious(tail);

        tail = node;
        size++;
    }

    public void insertAtIndex(T data,int index){
        // To Insert at defined index, we need to traverse to the index,Hold the next node in memory,set the curr node's next to newly created node and thenewly created node's next to the node stored in memory which was previously the next

        //If defined index is zero or  below, then the intention is to set the new node as the head, so we call insertAtHead
        if(index<=0){
            insertAtHead(data);
            return;
        }

        //Get hold of current node . At Start of traversal this is the head node
        Node<T> curr = head;
        //Store current Index as we traverse the list
        int currIndex = 1;

        //While traversing, if next node is not null(We are not yet at last node and we are not yet at defined index(currIndex<index) loop
        //Set curr to be the last next we are at
        //Increment next
        while ((curr.getNext() !=null) && currIndex < index){
            curr = curr.getNext();
            currIndex++;
        }
        //Store last nex
        //Create a node from data provided
        Node<T> next = curr.getNext();

        if(next == null){
            insertAtTail(data);
            return;
        }
        Node<T> newNode = new Node<>(data);

        //Set next of newly node to the current node next's (Stored above)
        //Set current's node next as new node
        newNode.setNext(next);
        newNode.setPrevious(curr);

        curr.setNext(newNode);
        next.setPrevious(newNode);
        size++;
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


        //traverse the list
        while (curr != null){

            //If we have found the data to be deleted
            if(curr.getData().equals(data)){
                Node<T> prev = curr.getPrevious();
                Node<T> next = curr.getNext();
                //if we dont have a prev ie found is head
                if(prev == null){
                    size--;
                    head = head.getNext();
                    head.setPrevious(null);
                }else {
                    prev.setNext(next);

                    if(next != null) {
                        next.setPrevious(prev);
                    }
                    size--;
                }
                break;

            }
            curr = curr.getNext();
        }
        if(tail == curr && curr != null){
            tail =  curr.getPrevious();
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

    public void  printBackwards(){
        Node<T> curr = tail;
        while (curr != null){
           System.out.print(curr.getData()
           +"--");
            curr= curr.getPrevious();
        }
        System.out.print("null"
        );
    }

    @Override
    public String toString() {
        if(head == null){
            return "";
        }
        return head.toString() +" Size "+size;
    }
}
