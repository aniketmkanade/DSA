/*
 * DFS of Graph
 * You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
 * Note: Use a recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.
 * Your task:
 * You don't need to read input or print anything. Your task is to complete the function dfsOfGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a list containing the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.
 * 
 * Time complexity: O(V+E)
 * Space Complexity: O(V)
 * 
 * GFG Solution:
 * class Solution 
   {
        ArrayList<Integer> al = new ArrayList<Integer>();
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) 
        {
            boolean[] isVisited = new boolean[V];
            for(int i=0; i<V; i++){
                if(!isVisited[i])
                    dfsOfGraphUtil(i, adj, isVisited);
            }
            return al;
        }
        
        public void dfsOfGraphUtil(int V, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited) 
        {
            isVisited[V] = true;
            al.add(V);
            
            for(int i=0;i< adj.get(V).size(); i++)
            {
                int n = adj.get(V).get(i);
                if(!isVisited[n])
                    dfsOfGraphUtil(n, adj, isVisited);
            }
        }
    }
 * 
 */
package Graph;
import java.util.*;
@SuppressWarnings("unchecked")
public class GraphDFS {
    int v;
    ArrayList<Integer>[] adj;
    GraphDFS(int v){
        this.v = v;
        adj = new ArrayList[v];
        for(int i=0; i<v; i++)
            adj[i] = new ArrayList<>();
    }

    void addEdge(int i, int j) {
        adj[i].add(j);
    }

    void DFS(){
        boolean[] isVisited = new boolean[v];
        for(int i=0; i<v; i++)
        {
            if(!isVisited[i])
                DFSUtil(isVisited, i);
        }
        
    }

    void DFSUtil(boolean[] isVisited, int v) {
        isVisited[v] = true;
        System.out.print(v + " ");

        for(int i=0; i<adj[v].size(); i++) {
            int n = adj[v].get(i);
            if(!isVisited[n])
                DFSUtil(isVisited, n);
        }
    }

    public static void main(String[] args) {
        GraphDFS t = new GraphDFS(4);
        t.addEdge(0, 1);
        t.addEdge(0, 2);
        t.addEdge(1, 2);
        t.addEdge(2, 0);
        t.addEdge(2, 3);
        t.addEdge(3, 3);
        t.DFS();
    }
}
