package Stacks.Problems.MinimumElement;

import Stacks.LinkedListImplementation.Stack;
import Stacks.StackUnderflowException;

public class MinimumStack<T extends Comparable<T>> {

    private Stack<T> stack = new Stack<>();
    private Stack<T> minimumStack = new Stack<>();

    public void push(T data) throws StackUnderflowException {
        T minimumValue = data;
        if(!minimumStack.isEmpty()){
            if(minimumValue.compareTo(minimumStack.peek()) >= 0){
                minimumValue = minimumStack.peek();
            }
        }
        stack.push(data);
        minimumStack.push(minimumValue);
    }

    public T pop() throws StackUnderflowException {
        minimumStack.pop();
        return stack.pop();
    }

    public T peek() throws StackUnderflowException {
        minimumStack.peek();
        return stack.peek();
    }

    public T getMinimum() throws StackUnderflowException {
        return minimumStack.peek();
    }


    public String toString(){
        return "\nStack: "+stack.toString()+" \nMinimum stack: "+minimumStack.toString();
    }

}
