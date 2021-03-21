package Graphs;

import java.util.List;

public interface Graph {

    enum GraphType{
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int v1,int v2);

    void addEdge(int v1,int v2,int weight);

    List<Vertex> getAdjecentVerticesLis(int v);

    List<VertexSet> getAdjecentVerticesSet(int v);

    List<Integer> getAdjecentVerticesMatrix(int v);

    int getNumVertices();

    int getIndegree(int v);

    void displayGraph();
}
