package Stacks.Problems.CommandDesignPattern;

import Stacks.LinkedListImplementation.Stack;
import Stacks.StackOverflowException;
import Stacks.StackUnderflowException;

import java.util.Scanner;

public class Operation {

    public static int readInput(Scanner scanner){
        System.out.print("\n Enter 1 for bold, 2 for italics, 3 for underline, 4 for undo ");
        int entry = scanner.nextInt();
        System.out.println(entry);
        return entry;
    }

    public static void performAction(int entry, Stack<Command> commandStack) throws StackUnderflowException, StackOverflowException {
        Command command;
        switch (entry){

            case 1:
                Command bold = new Bold();
                bold.execute();
                commandStack.push(bold);
                break;

            case 2:
                Command italic = new Italic();
                italic.execute();
                commandStack.push(italic);
                break;

            case 3:
                Command underline = new Underline();
                underline.execute();
                commandStack.push(underline);
                break;

            case 4:
               command = commandStack.pop();
               command.undo();
                break;
        }

    }

    public static void main(String [] args) throws StackUnderflowException, StackOverflowException {

        Stack<Command> commandStack = new Stack<>();

        Scanner scanner = new Scanner(System.in);

        while ((true)){
            int entry = readInput(scanner);

            if(entry <1 || entry>4){
                System.out.println("Goodbye");
                break;
            }

            performAction(entry,commandStack);

        }
        scanner.close();
    }
}
