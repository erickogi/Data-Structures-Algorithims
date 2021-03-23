package Queues.CircularQueue;

import Queues.QueueOverflowException;
import Queues.QueueUnderflowException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CircularQueue<T> {

    private static final int MAX_SIZE = 10;

    private T[] array;

    private int frontIndex = -1;
    private int rearIndex = -1;

    @SuppressWarnings("unchecked")
    public CircularQueue(Class<T> clazz){
        array = (T[]) Array.newInstance(clazz,MAX_SIZE);
    }

    public boolean isEmpty(){
        return frontIndex == -1 && rearIndex == -1;
    }

    public boolean isFull(){
        int nextIndex = (rearIndex+1)%array.length;
        return nextIndex == frontIndex;
    }

    public void enqueue(T data) throws QueueOverflowException {
        if(isFull()){
            throw  new QueueOverflowException("Queue is full");
        }
        rearIndex = (rearIndex+1)% array.length;
        array[rearIndex] = data;

        //If queue was previously empty both front & rear index point to same element
        if(frontIndex == -1){
            frontIndex = rearIndex;
        }

    }

    public T dequeue() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is empty");
        }
        T data = array[frontIndex];
        //both point to same element (One element in queue
        if(frontIndex == rearIndex){
            frontIndex = -1;
            rearIndex = -1;
        }
        else {
            frontIndex = (frontIndex+1) % array.length;
        }
        return data;
    }
    public T peek() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is empty");
        }
        return array[frontIndex];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append(Arrays.toString(array));
        sb.append("\nFront: "+frontIndex+" Rear: "+rearIndex);
        return sb.toString();
    }

}
