package gitDSALGO.graph.Matrix;

import gitDSALGO.graph.GeneralGraph;

public class UnDirectedGraph implements GeneralGraph{

    private int[][] adjMatrix;

    UnDirectedGraph(int nodes){
        adjMatrix = new int[nodes][nodes];
    }

    @Override
    public void addEdge(int u, int v) {
        if(u>adjMatrix.length || v > adjMatrix.length){
            return;
        }
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    @Override
    public void bfs(int val) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bfs'");
    }
    
    
}
