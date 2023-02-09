/*
 * Problem: Detect cycle in an undirected graph
 * Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.
 * 
 * Time Complexity: O(V+E)
 * Space Complexity: 
 * 
 * GFG Solution:
 * class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[V];
        
        for(int i=0; i<V; i++)
        {
            if(!isVisited[i])
            {
                if(isCycleUtil(i, adj, isVisited, -1))
                    return true;
            }
        }
        return false;
    }
    
    public boolean isCycleUtil(int v, ArrayList<ArrayList<Integer>> adj, 
    boolean[] isVisited, int parent){
        isVisited[v] = true;
        
        for(Integer neighbour: adj.get(v)){
            if(!isVisited[neighbour]){
                if(isCycleUtil(neighbour, adj, isVisited, v))
                    return true;
            }
            else if(neighbour != parent)
                return true;
        }
        return false;
    }
 }
 */
package Graph;
public class GraphDetectCycle {

    public static void main(String[] args) {
        int[][] arr = {{0,1},{1,3},{3,2},{2,3}};
        boolean ans = false;
        boolean[] isVisited = new boolean[4];
        for(int i=0;i<arr.length;i++){
            if(detectCycle(arr, i, isVisited, -1))
                ans =  true;
        }
        System.out.println(ans);
    }

    public static boolean detectCycle(int[][] arr, int v, boolean[] isVisited, int parent) {
        isVisited[v] = true;

        for(int i=0;i<arr[v].length;i++)
        {
            if(!isVisited[i]){
                if(detectCycle(arr,v,isVisited,i))
                    return true;
            }
            else if(i != parent){
                return true;
            }
        }
        return false;
    }
}
