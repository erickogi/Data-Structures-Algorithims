package LinkedLists.Singly;

public class Operations {



    public static void main(String [] args){
        Node<Integer> intNode1 = new Node<>(10);
        Node<Integer> intNode2 = new Node<>(20);
        Node<String> intNode3 = new Node<>("Javascript");
        Node<String> intNode4 = new Node<>("Kkasasd");
        Node<Integer> intNode5 = new Node<>(44);
        intNode1.setNext(intNode2);
        intNode2.setNext(intNode5);
        intNode3.setNext(intNode4);

        System.out.println("\n Int Node Data : "+intNode1);
        System.out.println("\n String Node Data : "+intNode3);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertAtHead(2);
        linkedList.insertAtHead(7);
        linkedList.insertAtHead(8);
        System.out.println("\n Insert : "+linkedList);
        linkedList.insertAtHead(9);
        System.out.println("\n Insert At Head : "+linkedList);
        linkedList.insertAtIndex(44,2);
        System.out.println("\n Insert At Index : "+linkedList);
        linkedList.insertAtTail(29);
        System.out.println("\n Insert At Tail : "+linkedList);


        System.out.println("\n Count Nodes : "+linkedList.countNodes());
        System.out.println("\n Size oF Nodes : "+linkedList.getSize());

        System.out.println("\n Before Pop : "+linkedList);
        System.out.println("\n Pop : "+linkedList.pop());
        System.out.println("\n After Pop : "+linkedList);


        System.out.println("\n Before Delete : "+linkedList);
        linkedList.delete(7);
        System.out.println("\n After Delete : "+linkedList);


        System.out.println("\n List Contains : "+linkedList.contains(44));
        System.out.println("\n All less than : "+linkedList.findAllLessThan(22));
    }
}
