/*
 * Problem: Topological sort
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
 * 
 * Time Complexity:Time Complexity: O(V+E) -> The outer for loop will be executed V number of times and the inner for loop will be executed E number of times.
 * Space Complexity: O(V) -> The queue needs to store all the vertices of the graph. So the space required is O(V)
 * 
 * GFG Solution:
 * class Solution
  {
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ansArr = new int[V];
        int[] inOrder = new int[V];
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        //Step 1: Calculating the inorder
        for(ArrayList<Integer> arr:adj){
            for(Integer i: arr){
                inOrder[i]++;
            }
        }
        
        //Step 2: By BFS
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i: inOrder){
            if(inOrder[i] == 0)
                q.add(i);
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int a = q.peek();
            q.poll();
            answer.add(a);
            
            for(int neighbour: adj.get(a)){
                inOrder[neighbour]--;
                if(inOrder[neighbour] == 0)
                    q.add(neighbour);
            }
            count++;
        }
        if (count != V) {
            return ansArr;
        }
        
        for(int i=0; i<answer.size(); i++)
            ansArr[i] = answer.get(i);
        return ansArr;
    }
  }
 */

package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
@SuppressWarnings("unchecked")
public class GraphTopologicalSortingKanh{
    int v;
    ArrayList<Integer>[] arr;
    GraphTopologicalSortingKanh(int v){
        this.v = v;
        arr = new ArrayList[v];
        for(int i=0; i<v; i++){
            arr[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int a, int b){
        arr[a].add(b);
    }
    
    public static void main(String[] args) {
        GraphTopologicalSortingKanh t = new GraphTopologicalSortingKanh(6);
        t.addEdge(0, 3);
        t.addEdge(0, 2);
        t.addEdge(3, 1);
        t.addEdge(2, 3);
        t.addEdge(2, 1);
        t.addEdge(5, 1);
        t.addEdge(1, 4);
        t.addEdge(5, 4);

        t.topologicalSort();
    }

    public void topologicalSort() 
    {
        int[] inOrder = new int[v];
        ArrayList<Integer> answer = new ArrayList<>();
        //Step1: Calculating inorder
        for(int i=0; i<arr.length; i++){
            ArrayList<Integer> arr1 = arr[i];
            for(Integer j:arr1){
                inOrder[j]++;
            }
        }
        
        //Step2: Similar to BFS
        Queue<Integer> q = new LinkedList<Integer>();
        //1. Start with inorder = 0
        for(int i=0; i<inOrder.length; i++){
            if(inOrder[i] == 0)
                q.add(i);
        }
        
        //2. DFS + Reduction in inorder array
        int count = 0;
        while (!q.isEmpty()) {
            int a = q.peek();
            q.poll();
            //answer.add(a);
            System.out.println(a);
            for(int neighbour:arr[a]){
                inOrder[neighbour]--;
                if(inOrder[neighbour] == 0)
                    q.add(neighbour);
            }
            count++;
        }
        if (count != v) {
            System.out.println("Cycle in a graph");;
        }
    }
} 