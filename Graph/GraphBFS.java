/*
 * BFS of graph
 * Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
 * Note: One can move from node u to node v only if there's an edge from u to v and find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.
 * 
 * Your task:
 * You dont need to read input or print anything. Your task is to complete the function bfsOfGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns  a list containing the BFS traversal of the graph starting from the 0th vertex from left to right.
 *
 * Time Complexity: O(V+E)
 * Space Complexity: O(V)
 * 
 * GFG solution:
 *  class Solution 
 *  {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) 
        {
            ArrayList<Integer> al = new ArrayList<Integer>();
            boolean[] isVisited = new boolean[V];
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(0);
            isVisited[0] = true;
            
            while(!q.isEmpty())
            {
                int n = q.poll();
                al.add(n);        
                for(int i=0; i<adj.get(n).size(); i++)
                {
                    int k = adj.get(n).get(i);
                    if(!isVisited[k]){
                        q.add(k);
                        isVisited[k] = true;
                    }
                }
            }
            return al;
        }
    }
 */



package Graph;
import java.util.*;
@SuppressWarnings("unchecked")
public class GraphBFS 
{ 
    int V;
    ArrayList<Integer>[] adj;
    GraphBFS(int V)
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int i=0;i<V; i++)
            adj[i] = new ArrayList<>();
    }
    void addEdge(int a, int b){
        adj[a].add(b);
    }

    void BFS(int s)
    {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        visited[s] = true;
        q.add(s);

        while (q.size() != 0)
        {
            s = q.peek();
            q.poll();
            System.out.print(s + " ");
            for(int i=0; i<adj[s].size(); i++)
            {
                int n = adj[s].get(i);
                if(!visited[n])
                {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        GraphBFS t = new GraphBFS(4);
        t.addEdge(0, 1);
        t.addEdge(0, 2);
        t.addEdge(1, 2);
        t.addEdge(2, 0);
        t.addEdge(2, 3);
        t.addEdge(3, 3);
        t.BFS(2);
    }
}