/*
 * Problem: Shortest path in an unweighted graph
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * 
 */
package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphShortestPathInUnWeightedGraph{
    ArrayList<Integer>[] adj;
    int v;
    GraphShortestPathInUnWeightedGraph(int v){
        this.v = v;
        adj = new ArrayList[v];
        for(int i=0; i<v; i++)
            adj[i] = new ArrayList<>();
    }

    public void addEdge(int a, int b){
        adj[a].add(b);
    }

    public static void main(String[] args) {
        int v = 4;
        GraphShortestPathInUnWeightedGraph t = new GraphShortestPathInUnWeightedGraph(v);
        t.addEdge(0, 1);
        t.addEdge(0, 2);
        t.addEdge(1, 2);
        t.addEdge(2, 0);
        t.addEdge(2, 3);
        t.addEdge(3, 3);
        t.shortestPath(0, v);
    }

    //Normal BFS
    public void shortestPath(int v, int max) {
        int[] dist = new int[max];
        dist[v] = 0;                               // Change 1
        boolean[] isVisited = new boolean[max];
        isVisited[v] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        while(!q.isEmpty()){
            int a = q.peek();
            q.poll();

            for(Integer i: adj[a]){
                if(!isVisited[i]){
                    dist[i] = dist[a] + 1;          // Change 2        
                    isVisited[i] = true;
                    q.add(i);
                }
            }
        }

        for(int i=0; i<dist.length; i++)
            System.out.print(dist[i]);
    }
}