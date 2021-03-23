package Queues.QueueUsingArray;

import Queues.QueueOverflowException;
import Queues.QueueUnderflowException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Queue<T> {

    private static final int MAX_SIZE = 10;
    private T[] array;

    private int frontIndex = -1;
    private int rearIndex = -1;

    @SuppressWarnings("unchecked")
    public Queue(Class<T> clazz) {
        array = (T[]) Array.newInstance(clazz,MAX_SIZE);
    }


    public boolean isEmpty(){
        return frontIndex == -1 && rearIndex == -1;
    }

    public boolean isFull(){
        return frontIndex == 0 && rearIndex ==MAX_SIZE-1;
    }

    public int size(){
        if(isEmpty()){
            return 0;
        }
        return rearIndex-frontIndex+1;
    }

    public void enqueue(T data) throws QueueOverflowException {
        if(isFull()){
            throw new QueueOverflowException("Queue is full");
        }

        if(isEmpty()){
            array[0] = data;
            frontIndex =0;
            rearIndex =0;
            return;
        }

        // iF THERE IS SPACE AT END OF ARRRAY JUST ENQUEUE AT THE END

        if(rearIndex < MAX_SIZE-1){
            rearIndex++;
            array[rearIndex] = data;
            return;
        }



        //AT THIS POINT REAR INDEX == MAX_SIZE -1 and yet queue is not full . MMeans front index is not at index 0 (front of queue
        //We cant increment due to array overflow
        //We copy all element sto begining of array

        int copyIndex = 0;
        for(int i = frontIndex;i<=rearIndex;i++){
            array[copyIndex] = array[i];
            copyIndex++;
        }

        array[copyIndex] =data;
        frontIndex = 0;
        rearIndex = copyIndex;

    }

    public T dequeue () throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is empty");
        }

        T data = array[frontIndex];
        if(frontIndex == rearIndex){
            frontIndex = -1;
            rearIndex = -1;
        }
        else {
            frontIndex++;
        }
        return data;
    }

    @Override
    public String toString(){
        String sb = "\n" +
                Arrays.toString(array) +
                "\nFront: " + frontIndex + " Rear: " + rearIndex;
        return sb;
    }
}
