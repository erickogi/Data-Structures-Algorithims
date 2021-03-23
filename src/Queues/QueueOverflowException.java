package Queues;

public class QueueOverflowException extends Exception {
    private static final  long serialVersionUID = 1L;

    public QueueOverflowException(String message){
        super(message);
    }

}
