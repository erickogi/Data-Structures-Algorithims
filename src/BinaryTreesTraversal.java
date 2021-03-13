import java.util.*;

public class BinaryTreesTraversal {

    public static <T> void breadthFirstWithLevelInfo(Node<T> root){
        if(root == null){
            return;
        }

        Queue<Pair<Node<T>, Integer>> queue = new LinkedList<>();

        int level = 0;
        queue.add(new Pair<>(root,level));

        while (!queue.isEmpty()){

            Pair<Node<T>, Integer> pair = queue.remove();

            System.out.print(pair +" -> ");

            level = pair.getValue()+1;

            if(pair.getKey().getLeftChild() != null){
                queue.add(new Pair<>(pair.getKey().getLeftChild(), level));
            }

            if(pair.getKey().getRightChild() != null){
                queue.add(new Pair<>(pair.getKey().getRightChild(), level));
            }
        }
    }

    /**
     * @param root
     * @param <T>
     *
     *     Start from root node and add to a queue (First In First Out DS)
     *     Dequeue and process the node
     *     Add its left and then its right child to the queue
     *     *Repeat so long as queue is not empty
     *
     */
    public static <T> void breadthFirst(Node<T> root){
        if(root == null){
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();


        queue.add(root);

        while (!queue.isEmpty()){

            Node<T> node = queue.remove();

            System.out.print(node +" -> ");

            if(node.getLeftChild() != null){
                queue.add(node.getLeftChild());
            }

            if(node.getRightChild() != null){
                queue.add(node.getRightChild());
            }
        }
    }


    /**
     * @param root
     * @param <T>
     *
     * Left -> Node -> right
     *
     * Then Left Subtree Is processed first & All nodes
     * * A node is processed after Left Subtree
     * Then Right Subtree & All nodes
     *
     * Repeat
     */
    public static <T> void depthFirstInOrderUsingStack(Node<T> root){
        if(root == null){
            return;
        }
        Set<Node<T>> visitedNodes = new HashSet<>();

        Stack<Node<T>> stack = new Stack<>();

        stack.push(root);

        while (! stack.empty()){

            Node<T> top = stack.pop();

            if(top.getLeftChild() == null && top.getRightChild() == null){
                System.out.print(top+"->");
            }
            else if ( visitedNodes.contains(top)){
                System.out.print(top+"->");
            }
            else {
                visitedNodes.add(top);
                if(top.getRightChild() != null){
                    stack.push(top.getRightChild());
                }
                stack.push(top);

                if(top.getLeftChild() != null){
                    stack.push(top.getLeftChild());
                }
            }
        }
    }

    /**
     * @param root
     * @param <T>
     *
     * Left -> Node -> right
     *
     * Then Left Subtree Is processed first & All nodes
     * * A node is processed after Left Subtree
     * Then Right Subtree & All nodes
     *
     * Repeat
     */
    public static <T> void depthFirstInOrderUsingRecursion(Node<T> root){
        if(root == null){
            return;
        }

        depthFirstInOrderUsingRecursion(root.getLeftChild());
        System.out.print(root.getData()+"->");
        depthFirstInOrderUsingRecursion(root.getRightChild());

    }


    /**
     * @param root
     * @param <T>
     *
     *     Root -> Left -> Right
     *
     * A node is processed before its sub trees
     * Then Left Subtree (The node -> Its Left Sub tree , then its right subtree )....
     * Then Right Subtree .....
     *
     * Repeat
     */
    public static <T> void depthFirstPreOrderUsingStack(Node<T> root){
        if(root == null){
            return;
        }
        Set<Node<T>> visitedNodes = new HashSet<>();

        Stack<Node<T>> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()){
            Node<T> top = stack.pop();

            if(top.getLeftChild() == null && top.getRightChild() == null){
                System.out.print(top+"->");
            }

            else if(visitedNodes.contains(top)){
                System.out.print(top+"->");
            }
            else {
                visitedNodes.add(top);
                if(top.getRightChild() != null){
                    stack.push(top.getRightChild());
                }
                if(top.getLeftChild() != null){
                    stack.push(top.getLeftChild());
                }
                stack.push(top);
            }
        }

    }

    /**
     * @param root
     * @param <T>
     *
     *     Root -> Left -> Right
     *
     * A node is processed before its sub trees
     * Then Left Subtree (The node -> Its Left Sub tree , then its right subtree )....
     * Then Right Subtree .....
     *
     * Repeat
     */
    public static <T> void depthFirstPreOrderUsingRecursion(Node<T> root){
        if(root == null){
            return;
        }
        System.out.print(root.getData()+"->");

        depthFirstPreOrderUsingRecursion(root.getLeftChild());
        depthFirstPreOrderUsingRecursion(root.getRightChild());

    }

    /**
     * @param root
     * @param <T>
     *
     * Left -> Right -> Root
     *
     * Then Left Subtree ( Its Left Sub tree , then its right subtree , then The node )....
     * Then Right Subtree ( Its Left Sub tree , then its right subtree , then The node ).....
     * A node is processed last after its sub trees
     *
     * Repeat
     */
    public static <T> void depthFirstPostOrderUsingStack(Node<T> root){
        if(root == null){
            return;
        }
        Set<Node<T>> visitedNodes = new HashSet<>();

        Stack<Node<T>> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()){
            Node<T> top = stack.pop();

            if(top.getLeftChild() == null && top.getRightChild() == null){
                System.out.print(top+"->");
            }

            else if(visitedNodes.contains(top)){
                System.out.print(top+"->");
            }
            else {
                visitedNodes.add(top);
                stack.push(top);
                if(top.getRightChild() != null){
                    stack.push(top.getRightChild());
                }
                if(top.getLeftChild() != null){
                    stack.push(top.getLeftChild());
                }

            }
        }

    }

    /**
     * @param root
     * @param <T>
     *
     * Left -> Right -> Root
     *
     * Then Left Subtree ( Its Left Sub tree , then its right subtree , then The node )....
     * Then Right Subtree ( Its Left Sub tree , then its right subtree , then The node ).....
     * A node is processed last after its sub trees
     *
     * Repeat
     */
    public static <T> void depthFirstPostOrderUsingRecursion(Node<T> root){
        if(root == null){
            return;
        }

        depthFirstPostOrderUsingRecursion(root.getLeftChild());

        depthFirstPostOrderUsingRecursion(root.getRightChild());

        System.out.print(root.getData()+"->");

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


        /**
         * TREE TRAVERSAL -> Visiting nodes of a tree
         * Two Types -> Breadth First & Depth First Traversal
         *
         * Breadth First -> NODE AT SAME LEVEL VISITED FIRST( Ie visit Root->Child(Left then right)-> Other Child at same level-> Next Level *Start from left to right))
         *
         * Deep First -> We go as deep as possible before visiting other nodes- Go to leaf nodes before moving up the tree
         * Deep First types -> Pre-Order, In-Order, Post-Order traversals
         * We use two implementations for depth first (Recursion,Using Stacks)
         *
         * PRE-ORDER -> Current (Root) -> Other nodes
         * IN-ORDER -> Root processed in between child nodes -> Left -> Root -> Right
         * POST-ORDER -> Process Current (Root) After all Child nodes -> Left -> Right -> Root
         *
         *
         **/


        System.out.println("\nbreadthFirst");
        breadthFirst(a);
        //System.out.println("\nbreadthFirstWithLevelInfo");
        //breadthFirstWithLevelInfo(a);

        System.out.println("\ndepthFirstInOrderUsingStack");
        depthFirstInOrderUsingStack(a);
        System.out.println("\ndepthFirstInOrderUsingRecursion");
        depthFirstInOrderUsingRecursion(a);
        System.out.println("\ndepthFirstPreOrderUsingStack");
        depthFirstPreOrderUsingStack(a);
        System.out.println("\ndepthFirstPreOrderUsingRecursion");
        depthFirstPreOrderUsingRecursion(a);
        System.out.println("\ndepthFirstPostOrderUsingStack");
        depthFirstPostOrderUsingStack(a);
        System.out.println("\ndepthFirstPostOrderUsingRecursion");
        depthFirstPostOrderUsingRecursion(a);





    }
}
