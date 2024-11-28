package gitDSALGO.graph.Matrix;

import gitDSALGO.graph.GeneralGraph;

public class DirectedGraph implements GeneralGraph{
    
    int[][] adjMatrix;

    DirectedGraph(int nodes){
        adjMatrix = new int[nodes][nodes];
    }

    @Override
    public void addEdge(int u, int v){
        if(u>adjMatrix.length || v > adjMatrix.length){
            return;
        }
        this.adjMatrix[u][v] =1;
    }

    @Override
    public void bfs(int val) {
        
    }


}
