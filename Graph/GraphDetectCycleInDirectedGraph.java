/*
 * Problem: Detect cycle in a directed graph
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
 *
 * Time Complexity: O(V+E) like DFS
 * Space Complexity:  O(V+E)
 * 
 * GFG Solution:
 class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[V];
        boolean[] recStack = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!isVisited[i]){
                if(isCyclicUtil(i, V, isVisited, recStack, adj))
                    return true;
            }
        }
        return false;
    }
    
    public boolean isCyclicUtil(int j, int V, boolean[] isVisited, 
    boolean[] recStack, ArrayList<ArrayList<Integer>> adj) 
    {
        isVisited[j] = true;
        recStack[j] = true;
        
        for(int i=0; i<adj.get(i).size(); i++) {
            if(!isVisited[i]){
                if(isCyclicUtil(i, V, isVisited, recStack, adj))
                    return true;
            }
            else if(recStack[i])
                return true;
        }
        
        recStack[j] = false;
        return false;
    }
}
 */
package Graph;
import java.util.ArrayList;
public class GraphDetectCycleInDirectedGraph {
    ArrayList<Integer>[] arr;
    int v;
    GraphDetectCycleInDirectedGraph(int v){
        this.v = v;
        arr = new ArrayList[v];
        for(int i=0; i<v; i++){
            arr[i] = new ArrayList<Integer>();
        }
    }

    void addEdge(int a, int b){
        arr[a].add(b);
    }

    public static void main(String[] args) {
        int v = 6;
        GraphDetectCycleInDirectedGraph t = new GraphDetectCycleInDirectedGraph(v);
        t.addEdge(0, 3);
        t.addEdge(0, 2);
        t.addEdge(3, 1);
        t.addEdge(2, 3);
        t.addEdge(2, 1);
        t.addEdge(5, 1);
        t.addEdge(1, 4);
        t.addEdge(5, 4);

        boolean[] isVisited = new boolean[v];
        boolean[] recStack = new boolean[v];

        boolean ans = false;
        for(int i=0; i<v; i++){
            if(!isVisited[i])
                ans = t.detectCycle(i, isVisited, recStack);
        }
        System.out.println(ans);
    }

    public boolean detectCycle(int i, boolean[] isVisited, boolean[] recStack) {
        isVisited[i] = true;
        recStack[i] = true;

        for(Integer neighbour: arr[i]){
            //If node is not visited
            if(!isVisited[neighbour]){
                if(detectCycle(neighbour, isVisited, recStack)) 
                    return true;
            } //If node is visited and in recStack as well
            else if(recStack[neighbour]) 
                    return true;
        }

        //Remove node from recStack as we are moving back in recursion 
        recStack[i] = false;
        return false;
    }
}
