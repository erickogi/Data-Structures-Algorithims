package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Operations {

    public static void adjencencyMatricGraph(){
        Graph graph = new AdjencyMatrixGraph(8, Graph.GraphType.DIRECTED);

        graph.addEdge(1,0,2);
        graph.addEdge(1,2,1);
        graph.addEdge(1,5,3);

        graph.addEdge(3,4);

        graph.addEdge(2,7);
        graph.addEdge(2,4);
        graph.addEdge(2,3,5);

        graph.addEdge(5,6,4);

        graph.addEdge(6,3,2);

        System.out.println("\nVertices adjacent to 1: "+graph.getAdjecentVerticesMatrix(1));
        System.out.println("\nVertices adjacent to 2: "+graph.getAdjecentVerticesMatrix(2));
        System.out.println("\nVertices adjacent to 5: "+graph.getAdjecentVerticesMatrix(5));
        System.out.println("\nVertices adjacent to 7: "+graph.getAdjecentVerticesMatrix(7));

        System.out.println("\nIndegree of 1: "+graph.getIndegree(1));
        System.out.println("\nIndegree of 3: "+graph.getIndegree(3));
        System.out.println("\nIndegree of 5: "+graph.getIndegree(5));



        graph.displayGraph();


        System.out.println("\n\n Breadth First Traversal \n\n");
        boolean[] visited = new boolean[graph.getNumVertices()];
        for(int i = 0; i <graph.getNumVertices(); i++) {
            breadthFirstTraversal(graph, visited, i);
        }

        System.out.println("\n\n Depth First Traversal \n\n");
        boolean[] visitedd = new boolean[graph.getNumVertices()];

        for(int i = 0; i <graph.getNumVertices(); i++) {
//            depthFirstTraversal(graph, 1);
        depthFirstTraversal(graph,visitedd, i);
        }
    }
    public static void adjencencyListGraph(){
        Graph graph = new AdjencyListGraph(8, Graph.GraphType.UNDIRECTED);

        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(1,5);

        graph.addEdge(3,4);

        graph.addEdge(2,7);
        graph.addEdge(2,4);
        graph.addEdge(2,3);

        graph.addEdge(5,6);

        graph.addEdge(6,3);

        System.out.println("\nVertices adjacent to 1: "+graph.getAdjecentVerticesLis(1));
        System.out.println("\nVertices adjacent to 2: "+graph.getAdjecentVerticesLis(2));
        System.out.println("\nVertices adjacent to 5: "+graph.getAdjecentVerticesLis(5));
        System.out.println("\nVertices adjacent to 7: "+graph.getAdjecentVerticesLis(7));

        System.out.println("\nIndegree of 1: "+graph.getIndegree(1));
        System.out.println("\nIndegree of 3: "+graph.getIndegree(3));
        System.out.println("\nIndegree of 5: "+graph.getIndegree(5));



        graph.displayGraph();


        System.out.println("\n\n Breadth First Traversal \n\n");
        boolean[] visited = new boolean[graph.getNumVertices()];
        breadthFirstTraversal(graph,visited,1);
    }
    public static void adjencencySetGraph(){
        Graph graph = new AdjencySetGraph(8, Graph.GraphType.UNDIRECTED);

        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(1,5);

        graph.addEdge(3,4);

        graph.addEdge(2,7);
        graph.addEdge(2,4);
        graph.addEdge(2,3);

        graph.addEdge(5,6);

        graph.addEdge(6,3);

        System.out.println("\nVertices adjacent to 1: "+graph.getAdjecentVerticesSet(1));
        System.out.println("\nVertices adjacent to 2: "+graph.getAdjecentVerticesSet(2));
        System.out.println("\nVertices adjacent to 5: "+graph.getAdjecentVerticesSet(5));
        System.out.println("\nVertices adjacent to 7: "+graph.getAdjecentVerticesSet(7));

        System.out.println("\nIndegree of 1: "+graph.getIndegree(1));
        System.out.println("\nIndegree of 3: "+graph.getIndegree(3));
        System.out.println("\nIndegree of 5: "+graph.getIndegree(5));



        graph.displayGraph();

        System.out.println("\n\n Breadth First Traversal \n\n");
        boolean[] visited = new boolean[graph.getNumVertices()];
        breadthFirstTraversal(graph,visited,1);
    }

    public static void  breadthFirstTraversal(Graph graph,boolean[] visited,int currentVertex){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentVertex);

        while (!queue.isEmpty()){
            int vertex = queue.remove();
            if(visited[vertex]){
                continue;
            }
            System.out.print(vertex+"->");
            visited[vertex] = true;

            List<Integer> list = graph.getAdjecentVerticesMatrix(vertex);
            for(int v : list){
                if(!visited[v]){
                    queue.add(v);
                }
            }
        }
    }

    public static void  depthFirstTraversal(Graph graph,boolean[] visited,int currentVetex){
        if(visited[currentVetex]){
            return;
        }
        visited[currentVetex] = true;
        List<Integer> list = graph.getAdjecentVerticesMatrix(currentVetex);
        for(int vertex : list){
            depthFirstTraversal(graph,visited,vertex);
        }
        System.out.print(currentVetex+"->");
    }

    public static void main(String[] args){
        adjencencyMatricGraph();
        adjencencyListGraph();
        adjencencySetGraph();

    }
}
