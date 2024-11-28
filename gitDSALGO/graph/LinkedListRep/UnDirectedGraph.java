package gitDSALGO.graph.LinkedListRep;

import java.util.*;

import gitDSALGO.graph.GeneralGraph;

public class UnDirectedGraph implements GeneralGraph{
 
    LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    UnDirectedGraph(int nodes){
        this.adjList = new LinkedList[nodes];
        for(int i =0;i<nodes;i++){
            adjList[i] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(int u, int v) {
        this.adjList[u].add(v);
        this.adjList[v].add(u);
    }

    @Override
    public void bfs(int val) {
        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(val);
        visited[val]= true;
        while(!q.isEmpty()){
            int element = q.poll();
            System.out.println("element => " +element);
            if(!visited[element]){
                for(int neb : adjList[element]){
                    visited[neb]=true;
                    q.add(neb);
                }
            }
        }
    }

    public static void main(String[] args) {
        UnDirectedGraph g = new UnDirectedGraph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        System.out.println(
        "BREATH FIRST SEARCH"
        );

        g.bfs(0);
    }

}
