package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    Test(){

    }
    public static void main(String[] args) {
        int[][] arr = {{}, {}, {}};
        for(int i=0; i<arr.length; i++)
            bfs(arr, n, i);
    }

    public static void bfs(int[][] arr, int n, int v) {
        boolean[] isVisisted = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        while(!q.isEmpty()){
            int a = q.peek();
            q.poll();
            for(int i=0;i<arr[a].length;i++)
            {
                if(!isVisited[i])
                    q.add(i);
            }
        }

    }
}
