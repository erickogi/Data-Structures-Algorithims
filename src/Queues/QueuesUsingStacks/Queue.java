package Queues.QueuesUsingStacks;

import Queues.Element;
import Queues.QueueOverflowException;
import Queues.QueueUnderflowException;
import Stacks.LinkedListImplementation.Stack;
import Stacks.StackUnderflowException;

public class Queue<T> {

    private Stack<T> forwardStack;
    private Stack<T> reverseStack;


    public Queue() {
        forwardStack = new Stack<>();
        reverseStack = new Stack<>();
    }

    public boolean isEmpty(){
        return forwardStack.isEmpty() && reverseStack.isEmpty();
    }

    public boolean isFull(){
        return forwardStack.isFull() && reverseStack.isFull();
    }

    public int size(){
        return Math.max(forwardStack.size(),reverseStack.size());
    }


    public void enqueue(T data) throws QueueOverflowException {
        try {
            if(forwardStack.isEmpty()){
                while (!reverseStack.isEmpty()){
                    forwardStack.push(reverseStack.pop());
                }
            }
            forwardStack.push(data);
        } catch (StackUnderflowException e) {
           throw new QueueOverflowException("Queue overflow");
        }
    }
    public T dequeue() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException("Queue underflowed");
        }
        try {
            if(reverseStack.isEmpty()){
                while (!forwardStack.isEmpty()){
                    reverseStack.push(forwardStack.pop());
                }
            }
            return reverseStack.pop();
        } catch (StackUnderflowException e) {
           throw new QueueUnderflowException("Queue underflowed");
        }
    }


    public T peek()throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException("Queue underflowed");
        }
        try {
            if(reverseStack.isEmpty()){
                while (!forwardStack.isEmpty()){
                    reverseStack.push(forwardStack.pop());
                }
            }
            return reverseStack.peek();
        } catch (StackUnderflowException e) {
            throw new QueueUnderflowException("Queue underflowed");
        }

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nForward stack: "+forwardStack);
        sb.append("\nReverse stack: "+reverseStack);

        return sb.toString();
    }


}
