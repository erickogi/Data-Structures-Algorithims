package Stacks.ArrayImplementation;

import Stacks.StackOverflowException;
import Stacks.StackUnderflowException;

import java.util.Arrays;

public class Stack<T>{

    private static final int MAX_SIZE = 10;

    private final Object[] array;
    private int topIndex = -1;

    public Stack(){
        array = new Object[MAX_SIZE];
    }

    public boolean isEmpty(){
        return topIndex == -1;
    }

    public boolean isFull(){
        return topIndex == MAX_SIZE-1;
    }

    public int size(){
        return topIndex+1;
    }

    public void push(T element) throws StackOverflowException {
        if(isFull()){
            throw new StackOverflowException("Stack is full, Cannot add element: "+element);
        }
        array[++topIndex] = element;
    }

    public T peek() throws StackUnderflowException {
        if(isEmpty()){
            throw new StackUnderflowException("Stack is empty");
        }
        @SuppressWarnings("unchecked")
        T topElement = (T) array[topIndex];
        return topElement;
    }

    public T pop() throws StackUnderflowException{
        if(isEmpty()){
            throw new StackUnderflowException("Stack is empty");
        }
        @SuppressWarnings("unchecked")
       T topElement = (T) array[topIndex];
        topIndex--;
        return topElement;
    }


    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
