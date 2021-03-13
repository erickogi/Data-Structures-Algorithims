public class BinaryTreesProblems {

    public static <T> int countNodes(Node<T> root){
        if(root == null){
            return 0;
        }
        int numNodesLeft = countNodes(root.getLeftChild());
        int numNodesRight = countNodes(root.getRightChild());

        return 1+ numNodesLeft+ numNodesRight;
    }

    public static void main(String[] args) {

        Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> h = new Node<>('H');

        a.setLeftChild(b);
        a.setRightChild(c);

        c.setLeftChild(d);
        c.setRightChild(e);

        d.setLeftChild(f);
        d.setRightChild(g);

        e.setRightChild(h);


        System.out.println(countNodes(a));

        }

    }
