package Stacks.Problems.CommandDesignPattern;

public class Italic implements Command{

    @Override
    public void execute() {
        System.out.println("Execute Italics");
    }

    @Override
    public void undo() {
        System.out.println("Undo Italics");
    }
}
