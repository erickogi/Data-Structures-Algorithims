package Queues.QueuesUsingLinkedList;

import Queues.Element;
import Queues.QueueUnderflowException;

public class Queue<T> {

    private Element<T> front;
    private Element<T> rear;

    private int size = 0;

    public Queue() {
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return false;
    }

    public int size(){
        return size;
    }


    public void enqueue(T data){
        Element<T> element = new Element<>(data);
        size++;

        if(front==null){
            front = element;
            rear = element;
            return;
        }
        rear.setNext(element);
        element.setPrevious(rear);

        rear = element;
    }

    public T dequeue() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is empty");
        }

        T data = front.getData();

        if(front == rear){
            front = null;
            rear = null;
        }else {
            front = front.getNext();
            front.setPrevious(null);
        }
        size--;
        return data;

    }

    public T peek()throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is empty");
        }
        return front.getData();

    }

    @Override
    public String toString(){
        if(front == null){
            return "";
        }
        return front.toString();
    }


}
