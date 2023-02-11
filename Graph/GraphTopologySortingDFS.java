package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class GraphTopologySortingDFS {
    ArrayList<Integer>[] arr;
    int v;
    GraphTopologySortingDFS(int v){
        this.v = v;
        arr = new ArrayList[v];
        for(int i=0; i<v; i++)
            arr[i] = new ArrayList<>();
    }

    public void addEdge(int a, int b){
        arr[a].add(b);
    }

    public static void main(String[] args) {
        GraphTopologySortingDFS t = new GraphTopologySortingDFS(6);
        t.addEdge(0, 3);
        t.addEdge(0, 2);
        t.addEdge(3, 1);
        t.addEdge(2, 3);
        t.addEdge(2, 1);
        t.addEdge(5, 1);
        t.addEdge(1, 4);
        t.addEdge(5, 4);

        t.topologicalSortDFS(); 
    }

    public void topologicalSortDFS() {
        boolean[] isVisited = new boolean[v];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<v; i++){
            if(!isVisited[i])
                topologicalSortDFSUtil(i, isVisited, st);
        }

        while(!st.empty()){
            System.out.println(st.peek() + " ");
            st.pop();
        }
    }

    public void topologicalSortDFSUtil(int i, boolean[] isVisited, Stack<Integer> st) {
        isVisited[i] = true;
        
        for(int neighbour: arr[i]){
            if(!isVisited[neighbour])
                topologicalSortDFSUtil(neighbour, isVisited, st);
        }
        st.push(i);
    }
}
