package Stacks.Problems.MinimumElement;

import Stacks.StackUnderflowException;

public class Operation {

    public static void main(String[] args) throws StackUnderflowException {

        MinimumStack<Integer> stack = new MinimumStack<>();

        stack.push(100);
        stack.push(45);
        stack.push(55);
        stack.push(66);
        stack.push(245);
        stack.push(67);

        System.out.println("Contents : "+stack+" , Top of Stack : "+stack.peek()+" , Minimum element : "+stack.getMinimum());
    }


    }
