package Trees;


public class BinaryTreesProblems {

    public static <T> int countNodes(Node<T> root){
        if(root == null){
            return 0;
        }
        int numNodesLeft = countNodes(root.getLeftChild());
        int numNodesRight = countNodes(root.getRightChild());

        return 1+ numNodesLeft+ numNodesRight;
    }

    public static <T> int maxDepthOfTree(Node<T> root){
        if(root == null){
            return 0;
        }

        if(root.getLeftChild() == null && root.getRightChild() == null){
            //System.out.println(root+ "maxDepth: "+0);
            return 0;
        }

        int leftMaxDepth = maxDepthOfTree(root.getLeftChild());
        int rightMaxDepth = maxDepthOfTree(root.getRightChild());
        int maxDepth = 1+ Math.max(leftMaxDepth,rightMaxDepth);
//        System.out.println(root+
//                " left MaxDepth "+ leftMaxDepth+
//                " right MaxDepth "+rightMaxDepth+
//                " current MaxDepth "+maxDepth);

        return maxDepth;
    }

    public static <T> boolean pathWithSum(Node<Integer> root, int currentSum){
        if(root == null){
            return false;
        }

        if(root.getLeftChild() == null && root.getRightChild() == null){
            return  currentSum == root.getData();
        }
        boolean hasPathSumLeft = pathWithSum(root.getLeftChild(), currentSum - root.getData());
        boolean hasPathSumRight = pathWithSum(root.getRightChild(), currentSum - root.getData());

        boolean hasPAthSum = hasPathSumLeft || hasPathSumRight;

        return  hasPAthSum;
    }

    public static <T> void mirrorTree(Node<T> root){
        if(root == null){
            return ;
        }

        Node<T> temporary = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temporary);

        mirrorTree(root.getLeftChild());
        mirrorTree(root.getRightChild());


    }

    public static <T> boolean isFullOrProperTree(Node<T> root){
        if(root == null){
            return true;
        }

      if(root.getLeftChild() == null && root.getRightChild()==null){
          return true;
      }
      if(root.getLeftChild() != null && root.getRightChild() != null){
          return isFullOrProperTree(root.getLeftChild()) && isFullOrProperTree(root.getRightChild());
      }

      return false;

    }

    //EVery Trees.Node has max two children or none
    //All nodes are at same level

//    public static <T> boolean isPerfectTree(Node<T> root){
//        int leftDepth = 0;
//        Node<T> node = root;
//
//        while (node != null){
//            leftDepth++;
//            node = node.getLeftChild();
//        }
//
//        return  leftDepth -1;
//
//    }
    public static void main(String[] args) {
        Node<Integer> a1 = new Node<>(1);
        Node<Integer> b2 = new Node<>(2);
        Node<Integer> c3 = new Node<>(3);
        Node<Integer> d4 = new Node<>(4);
        Node<Integer> e5 = new Node<>(5);
        Node<Integer> f6 = new Node<>(6);
        Node<Integer> g7 = new Node<>(7);
        Node<Integer> h8 = new Node<>(8);

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

        ///////////////
        a1.setLeftChild(b2);
        a1.setRightChild(c3);

        c3.setLeftChild(d4);
        c3.setRightChild(e5);

        d4.setLeftChild(f6);
        d4.setRightChild(g7);

        e5.setRightChild(h8);


        System.out.println("\n Count Of Nodes  -->  "+countNodes(a));
        System.out.println("\n Max Depth root to farthest Trees.Node  -->  "+maxDepthOfTree(a));
        System.out.println("\n Path With Sum  -->  "+pathWithSum(a1,3));
        System.out.println("\n");
        BinaryTreesTraversal.breadthFirstWithLevelInfo(a);
        System.out.println("\n");
        mirrorTree(a);
        BinaryTreesTraversal.breadthFirstWithLevelInfo(a);
        System.out.println("\n isFullOrProperTree  -->  "+isFullOrProperTree(a));

        }

    }
