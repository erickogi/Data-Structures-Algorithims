package Queues.DoubleEndedQueue_Deq;

import Queues.Element;
import Queues.QueueUnderflowException;

public class Deque<T> {

    private Element<T> front;
    private Element<T> rear;
    private int size =0;

    public  Deque(){

    }

    public void  addFirst(T data){
        Element<T> element = new Element<>(data);
        size++;

        if(front==null){
            front = element;
            rear = element;
            return;
        }
        element.setNext(front);
        front.setPrevious(element);

        front = element;
    }

    public void addLast(T data){
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

    public T removeFirst() throws QueueUnderflowException {
        if(front == null){
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
    public T removeLast() throws QueueUnderflowException {
        if(rear == null){
            throw new QueueUnderflowException("Queue is empty");
        }

        T data = rear.getData();
        if(front == rear){
            front = null;
            rear = null;
        }else {
            rear = rear.getPrevious();
            rear.setNext(null);
        }
        size--;
        return data;

    }

    public T peekFirst() throws QueueUnderflowException {
        if(front == null){
            throw new QueueUnderflowException("Queue is empty");
        }

        return front.getData();

    }

    public T peekLast() throws QueueUnderflowException {
        if(rear == null){
            throw new QueueUnderflowException("Queue is empty");
        }

        return rear.getData();

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return false;
    }

    public int size(){return  size;}

    @Override
    public String toString() {
        if(front == null){
            return "";
        }
        return front.toString()+" \nFront: "+front.getData()+" Rear: "+rear.getData();
    }
}
