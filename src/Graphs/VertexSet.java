package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VertexSet {

    private int vertexNumber;
    private int weight;

    private Set<VertexSet> adjacencyList = new HashSet<>();

    public VertexSet(int vertexNumber, int weight){
        this.vertexNumber = vertexNumber;
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public void addEdge(int vertexNumber,int weight){
        adjacencyList.add(new VertexSet(vertexNumber,weight));
    }
    public int getVertexNumber(){
        return vertexNumber;
    }

    public List<VertexSet> getAdjacencyVertices(){
        return new ArrayList<>(adjacencyList);
    }

    @Override
    public String toString() {
        return "Vertex:" + vertexNumber +
                " weight:" + weight;
    }
}
