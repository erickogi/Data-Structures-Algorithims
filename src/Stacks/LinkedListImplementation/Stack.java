package Stacks.LinkedListImplementation;

import Stacks.StackOverflowException;
import Stacks.StackUnderflowException;

public class Stack<T> {

    private Element<T> top;
    private int size = 0;

    public Stack(){}

    public  boolean isEmpty(){
        return size ==0;
    }

    public boolean isFull(){
        return false;
    }

    public int size(){return size;}

    public void push(T element) {
        Element<T> newElement = new Element<>(element);
        if(top != null){
            newElement.setNext(top);
        }

        top= newElement;
        size++;
    }

    public T pop() throws StackUnderflowException {
        if(isEmpty()){
            throw new StackUnderflowException("Stack is empty");
        }
        T topElement =  top.getData();
        top = top.getNext();
        size--;
        return topElement;
    }

    public T peek() throws StackUnderflowException{
        if(isEmpty()){
            throw new StackUnderflowException("Stack is empty");
        }
        return top.getData();
    }

    @Override
    public String toString() {
        if(top == null){
            return "";
        }
        return top.toString();
    }
}
