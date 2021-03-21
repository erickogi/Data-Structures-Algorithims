package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjencySetGraph implements Graph{

    //List of vertex objects (not adjecent) each has a refrence to its adjacents
    private List<VertexSet> vertexList = new ArrayList<>();

    //Track no of vertices in graph
    private int numVertices = 0;

    //Track If graph is directed or undirectd
    private GraphType graphType = GraphType.DIRECTED;

    //cONSTRUCTOR FOR numVertices & GraphType

    public AdjencySetGraph(int numVertices, GraphType graphType){
        this.numVertices = numVertices;


        //Nested for loop to initial all elements to zero (No connections at first)
        for( int i = 0; i<numVertices;i++){
            vertexList.add(new VertexSet(i,0));
        }

        this.graphType = graphType;

    }


    @Override
    public void addEdge(int v1, int v2,int weight) {
        if(v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0){
            throw  new IllegalArgumentException("Vertex number is not valid: "+v1+", "+v2);
        }

        //Access vertex v1 and add v2 as an edge
        vertexList.get(v1).addEdge(v2,weight);

        //If its an underected graph wwe need to add both directions v1 to v2 and v2 to v1
        if(graphType == GraphType.UNDIRECTED){
            vertexList.get(v2).addEdge(v1,weight);
        }
    }

    @Override
    public List<Vertex> getAdjecentVerticesLis(int v) {
        return null;
    }

    @Override
    public void addEdge(int v1, int v2) {
        addEdge(v1,v2,1);

    }


    // Get vertices adjacent to given vertex
    @Override
    public List<VertexSet> getAdjecentVerticesSet(int v) {
       if(v <0 || v>= numVertices){
           throw new IllegalArgumentException("Vertex number is not valid: "+v);
       }

       //Very Simple just get the adjacent of given v (vertex)
       return vertexList.get(v).getAdjacencyVertices();
    }

    @Override
    public List<Integer> getAdjecentVerticesMatrix(int v) {
        return null;
    }


    @Override
    public int getNumVertices() {
        return numVertices;
    }


    //To calculate the number of edges pointing to given vertex
    @Override
    public int getIndegree(int v) {
//We only have a one way mapping from vertex to its adjacents

        //Initialize to 0
        int indegree = 0;

        //Iterate over all vertex
        for(VertexSet vertex : vertexList){
            List<VertexSet> adjacentVertices = vertex.getAdjacencyVertices();
            for(VertexSet adjacent : adjacentVertices) {
                //Get adjacents of every vertex and check if v is contained.
                //If it is then we no there is an incoming from the vertex to V this indegree
                if (adjacent.getVertexNumber() ==v) {
                    indegree++;
                }
            }
        }
        return indegree;
    }

    //Prints out graph representation
    @Override
    public void displayGraph() {

        System.out.println("Adjacency List\n");

        for (VertexSet vertex : vertexList){
            List<VertexSet> adjacentVertices = vertex.getAdjacencyVertices();

            System.out.println("Edges from "+vertex.getVertexNumber()+ " to : "+adjacentVertices);
        }
    }
}
