package Stacks.ArrayImplementation;


import Stacks.StackOverflowException;
import Stacks.StackUnderflowException;

public class Operations {

    public static void  pushToOverflow() throws StackOverflowException {
        Stack<String> stack = new Stack<>();
        stack.push("Element1");
        stack.push("Element2");
        stack.push("Element3");
        stack.push("Element4");

        for (int i =0;i<11;i++){
            stack.push("Element1"+i);
            System.out.println("Is Empty -> "+ stack.isEmpty()+", Is Full -> "+ stack.isFull()+", Size -> "+ stack.size());

        }
    }
    public static void  popToUnderflow() throws StackUnderflowException,StackOverflowException{
        Stack<String> stack = new Stack<>();
        stack.push("Element1");
        stack.push("Element2");
        stack.push("Element3");
        stack.push("Element4");

        for (int i =0;i<11;i++){
            System.out.println("\nStack Pop -> "+ stack.pop());
            System.out.println("Is Empty -> "+ stack.isEmpty()+", Is Full -> "+ stack.isFull()+", Size -> "+ stack.size());


        }
    }



    public static void main(String [] args) throws StackOverflowException, StackUnderflowException {
        Stack<String> stack = new Stack<>();
        //pushToOverflow();
        //popToUnderflow();


        stack.push("Element1");
        stack.push("Element2");
        stack.push("Element3");
        stack.push("Element4");


        System.out.println("\nStack "+ stack);
        System.out.println("Is Empty -> "+ stack.isEmpty()+", Is Full -> "+ stack.isFull()+", Size -> "+ stack.size());

        //Pop a stack - removes last added and returns it
        System.out.println("\nStack Pop -> "+ stack.pop());
        System.out.println("Stack "+ stack);
        System.out.println("Is Empty -> "+ stack.isEmpty()+", Is Full -> "+ stack.isFull()+", Size -> "+ stack.size());

        //The value popped is still in the array but will be overiden if we pushed another
        stack.push("ElementOveride4");
        System.out.println("\nStack Push after pop \n"+ stack);
        System.out.println("Is Empty -> "+ stack.isEmpty()+", Is Full -> "+ stack.isFull()+", Size -> "+ stack.size());


        //Peek a stack - returns last added element
        System.out.println("\nStack Peek -> "+ stack.peek());
        System.out.println("Stack "+ stack);
        System.out.println("Is Empty -> "+ stack.isEmpty()+", Is Full -> "+ stack.isFull()+", Size -> "+ stack.size());


    }
}
