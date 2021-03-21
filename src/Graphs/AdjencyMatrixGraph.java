package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjencyMatrixGraph implements Graph{

    //A two demension array represent interconnections be=twn nodes in graph
    private int[][] adjacencyMatrix;

    //Track no of vertices in graph
    private int numVertices = 0;

    //Track If graph is directed or undirectd
    private GraphType graphType;

    //cONSTRUCTOR FOR numVertices
    public AdjencyMatrixGraph(int numVertices,GraphType graphType){
        this.numVertices = numVertices;
        this.graphType = graphType;

        //instantiate adjanceyMatrix where no of rows == no of columns (numVertices
        this.adjacencyMatrix = new int[numVertices][numVertices];

        //Nested for loop to initial all elements to zero (No connections at first)
        for( int i = 0; i<numVertices;i++){
            for(int j=0;j<numVertices;j++){
                adjacencyMatrix[i][j] = 0;
            }
        }
    }


    @Override
    public void addEdge(int v1, int v2) {
        addEdge(v1,v2,1);
    }

    //Adds a directed edge of weight 1 on vertice 1 to vertice 2
    @Override
    public void addEdge(int v1, int v2,int weight) {

        if(v1 >= numVertices||v2>=numVertices||v1<0||v2<0){
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        //Always Adds  the edge ie value of cell V1,V2 to 1
        adjacencyMatrix[v1][v2] = weight;

        //IF its Undirected add edge on both directions of the vertex
        if(graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v2][v1] = weight;
        }


    }

    @Override
    public List<Vertex> getAdjecentVerticesLis(int v) {
        return null;
    }

    @Override
    public List<VertexSet> getAdjecentVerticesSet(int v) {
        return null;
    }

    // Get vertices adjacent to given vertex
    @Override
    public List<Integer> getAdjecentVerticesMatrix(int v) {
       if(v <0 || v>= numVertices){
           throw new IllegalArgumentException("Vertex number is not valid");
       }

       // list to hold adjecent vertices of given vertex
       List<Integer> adjacentVerticesList = new ArrayList<>();

       //Iterate over all rows of the matrix
        //Check if entry is not equal to zero there is an adjecnt vertex
       for (int i = 0; i < numVertices; i++){
           if(adjacencyMatrix[v][i] != 0){
               adjacentVerticesList.add(i);
           }
       }
       //Sort// optional
        Collections.sort(adjacentVerticesList);
       return adjacentVerticesList;
    }


    @Override
    public int getNumVertices() {
        return numVertices;
    }


    //To calculate the number of edges pointing to given vertex
    @Override
    public int getIndegree(int v) {
        //Validate vertex number
        if(v < 0 || v>= numVertices){
            throw new IllegalArgumentException("Vertex number is not valid");
        }

        //initiaze indegree to 0
        int indegree =0;

        //loop through matrix
        for (int i =0; i < numVertices; i++){

            //check if there is any inward edge by looking at cells in column v.
            // If there is one then there is an inward edge thus incriment indegree
            if(adjacencyMatrix[i][v] != 0){
                indegree++;
            }

        }
        //return
        return indegree;
    }

    //Prints out graph representation
    @Override
    public void displayGraph() {

        System.out.println("Adjacency Matrix\n");
        for (int i =0; i< numVertices; i++){
            for (int j =0; j< numVertices;j++){
                System.out.print(adjacencyMatrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i =0;i<numVertices;i++){
            System.out.print("Edges from "+i+" to : ");
            for (int j =0;j<numVertices;j++){
                if(adjacencyMatrix[i][j] > 0){
                    System.out.println(j+" ");
                }
            }
            System.out.println();
        }
    }
}
