package LinkedLists.Singly;

public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        setNext(null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }



    @Override
    public String toString() {
        return data + "->"+( next== null ? "null" : next.toString());
    }
}
