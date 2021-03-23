package Stacks;

public class StackOverflowException extends Exception{

    private static final  long serialVersionUID = 1L;

    public StackOverflowException(String message){
        super(message);
    }

}
