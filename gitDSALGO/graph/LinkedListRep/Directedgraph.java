package gitDSALGO.graph.LinkedListRep;

import java.util.LinkedList;
import java.util.Queue;

import gitDSALGO.graph.GeneralGraph;

public class Directedgraph implements GeneralGraph{
    
    private LinkedList<Integer>[] adjLists;

    @SuppressWarnings("unchecked")
    Directedgraph(int nodes){
        this.adjLists = new LinkedList[nodes];
        for(int i=0;i<nodes;i++){
            adjLists[i] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(int u, int v) {
        adjLists[u].add(v);
    }

    @Override
    public void bfs(int val) {
        boolean[] visited = new boolean[adjLists.length];
        Queue<Integer> q = new LinkedList<>();
        visited[val]= true;
        q.add(val);
        
        while(!q.isEmpty()){
            int element = q.poll();
            System.out.println("element => " +element);

                for(int neb : adjLists[element]){
                    if(!visited[neb]){
                        visited[neb]=true;
                        q.add(neb);
                    }
                    
                }
            
        }
    }

    public static void main(String[] args) {
        Directedgraph g = new Directedgraph(5);

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
