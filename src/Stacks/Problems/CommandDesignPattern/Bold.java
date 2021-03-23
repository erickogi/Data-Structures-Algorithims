package Stacks.Problems.CommandDesignPattern;

public class Bold implements Command{
    @Override
    public void execute() {
        System.out.println("Execute Bold");
    }

    @Override
    public void undo() {
        System.out.println("Undo Bold");
    }
}
