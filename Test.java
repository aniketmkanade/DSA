import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    int v;
    ArrayList<Integer>[] arr;
    Test(int v){
        this.v = v;
        arr = new ArrayList[v];
        for(int i=0; i<v; i++){
            arr[i] = new ArrayList<>();
        }
    }

    void addEdge(int a, int b){
        arr[a].add(b);
    }

    class Pair{
        int i, j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) {
        Test t = new Test(5);
        t.addEdge(0, 1);
        t.addEdge(0, 2);
        t.addEdge(0, 3);
        t.addEdge(2, 4);
        //t.bfs(0);
        //t.dfs();
        //System.out.println(t.isPathExists(0, 4));
        //t.findTheJudge();

        /*char[][] grid = { {'1','1','0','0','0'},
                         {'1','1','0','0','0'}, 
                         {'0','0','1','0','0'}, 
                         {'0','0','0','1','1'} };
        int n = grid.length;
        int m = grid[0].length;
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    answer++;
                    dfsIslands(grid, i, j, n, m);
                }
            }
        }
        System.out.println(answer);*/

        /*int[][] grid = { {1,1,1},{1,1,0},{1,0,1} };
        int n = grid.length;
        int m = grid[0].length;
        t.floodFill(grid,1,1,n,m);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }*/

        /*boolean[] isVisited = new boolean[5];
        boolean ans = false;
        for(int i=0; i<5; i++){
            ans = t.detectCycle(i, -1, isVisited);
        }
        System.out.println(ans);*/

        //t.topologicalSort();

        //System.out.println(t.directedCycle());

        /*String[][] arr2 = {{"x", "x", "x", "x"},
                            {"x", "o", "o", "x"},
                            {"x", "x", "o", "x"},
                            {"x", "o", "x", "x"} };
        t.surroundedRegionUtil(arr2, arr2.length, arr2[0].length);
        for(int i=0; i<arr2.length; i++) {
            for(int j=0; j<arr2[0].length; j++) {
                if(arr2[i][j] == "B")
                    arr2[i][j] = "x";
            }
        }
        for(int i=0; i<arr2.length; i++) {
            for(int j=0; j<arr2[0].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }*/

        
    }

    public void surroundedRegionUtil(String[][] arr2, int n, int m) {
        for(int i=0; i<n; i++){
            if(arr2[i][0].equals("o")){
                arr2[i][0] = "B"; 
                dfs2(arr2, i, 0, n, m);        
            }
            if(arr2[i][n-1].equals("o")){
                arr2[i][n-1] = "B"; 
                dfs2(arr2, i, n-1, n, m);        
            }
        }
        for(int i=0; i<m; i++){
            if(arr2[0][i].equals("o")){
                arr2[0][i] = "B"; 
                dfs2(arr2, 0, i, n, m);        
            }
            if(arr2[n-1][i].equals("o")){
                arr2[n-1][i] = "B"; 
                dfs2(arr2, n-1, i, n, m);        
            }
        }
    }

    public void dfs2(String[][] arr2, int i, int j, int n, int m) {
        arr2[i][j] = "B";
        if(isValid2(arr2,i+1,j,n,m))
            dfs2(arr2,i+1,j,n,m);
        if(isValid2(arr2,i-1,j,n,m))
            dfs2(arr2,i-1,j,n,m);
        if(isValid2(arr2,i,j+1,n,m))
            dfs2(arr2,i,j+1,n,m);
        if(isValid2(arr2,i,j-1,n,m))
            dfs2(arr2,i,j-1,n,m);
    }

    public boolean isValid2(String[][] arr2, int i, int j, int n, int m) {
        if(i>=0 && i<n && j>=0 && j<m && arr2[i][j] == "B")
            return true;
        return false;
    }

    public boolean directedCycle(){
        boolean[] isVisited = new boolean[v];
        boolean[] isStack = new boolean[v];
        boolean ans = false;
        for(int i=0; i<5; i++)
            ans = directedCycleUtil(i, isVisited, isStack);
        return ans;
    }

    public boolean directedCycleUtil(int i, boolean[] isVisited, boolean[] isStack) {
        isVisited[i] = true;
        isStack[i] = true;

        for(int k:arr[i]){
            if(!isVisited[i]){
                if(directedCycleUtil(k, isVisited, isStack)) return true;
            }
            else if(isStack[k])
                return true;
        }

        isVisited[i] = false;
        return false;
    }

    public void topologicalSort() {
        //Step 1: Get inorder
        int[] inOrder = new int[v];
        for(int i=0; i<v; i++) {
            for(int j: arr[i])
                inOrder[j]++;
        }

        //Step 2: BFS
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i : inOrder){
            if(i==0)
                q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int a = q.peek();
            q.poll();
            System.out.println(a);
            for(int i:arr[a]){
                inOrder[i]--;
                if(inOrder[i] == 0)
                    q.add(i);
            }
            count++;
        }
        if(count != v)
            System.out.println("cycle");
    }

    public boolean detectCycle(int i, int parent, boolean[] isVisited) {
        isVisited[i] = true;
        for(int k:arr[i])
        {
            if(!isVisited[k]){
                if(detectCycle(k, i, isVisited))
                    return true;
            }
            else if(k != parent)
                return true;
        }
        return false;
    }

    public void floodFill(int[][] grid, int i, int j, int n, int m) {
        grid[i][j] = 2;
        if(isValidFlood(grid, i-1, j, n, m))
            floodFill(grid, i-1, j, n, m);
        if(isValidFlood(grid, i, j-1, n, m))
            floodFill(grid, i, j-1, n, m);
        if(isValidFlood(grid, i+1, j, n, m))
            floodFill(grid, i+1, j, n, m);
        if(isValidFlood(grid, i, j+1, n, m))
            floodFill(grid, i, j+1, n, m);
    }

    public boolean isValidFlood(int[][] grid, int i, int j, int n, int m) {
        if(i>=0 && i<n && j>=0 && j<m && grid[i][j] == 1)
            return true;
        return false;
    }

    public static void dfsIslands(char[][] grid, int i, int j, int n, int m) {
        grid[i][j] = '0';
        if(isValid(grid, i-1, j, n, m))
            dfsIslands(grid, i-1, j, n, m);
        if(isValid(grid, i, j-1, n, m))
            dfsIslands(grid, i, j-1, n, m);
        if(isValid(grid, i+1, j, n, m))
            dfsIslands(grid, i+1, j, n, m);
        if(isValid(grid, i, j+1, n, m))
            dfsIslands(grid, i, j+1, n, m);
    }

    public static boolean isValid(char[][] grid, int i, int j, int n, int m) {
        if(i>=0 && i<n && j>=0 && j<m && grid[i][j] == '1')
            return true;
        return false;
    }

    public void findTheJudge() {
        int k = 3;
        int arr[][] = {{0,2},{1,2}};
        int[] gains = new int[v];
        for(int i=0; i<arr.length; i++){
            gains[arr[i][0]]--;
            gains[arr[i][1]]++;
        }

        for(int i: gains){
            if(i == k-1)
                System.out.println(i);
        }
    }

    public void bfs(int a) {
        boolean[] isVisited = new boolean[v];
        isVisited[a] = true;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(a);

        while(!q.isEmpty()){
            int top = q.peek();
            q.poll();
            System.out.print(top + " ");

            for(int i:arr[top]){
                q.add(i);
            }
        }
    }

    public void dfs() {
        boolean[] isVisited = new boolean[v];
        for(int i=0; i<v; i++){
            if(!isVisited[i])
                dfsUtil(i, isVisited);
        }
    }

    public void dfsUtil(int k, boolean[] isVisited) {
        isVisited[k] = true;
        System.out.print(k + " ");

        for(int i:arr[k]){
            if(!isVisited[i]){
                dfsUtil(i, isVisited);
            }
        }
    }

    public boolean isPathExists(int s, int d) {
        boolean[] isVisited = new boolean[v];
        isVisited[s] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        while(!q.isEmpty()){
            int a = q.peek();
            q.poll();

            if(a == d) 
                return true;
            
            for(int i: arr[a]){
                if(!isVisited[i])
                    q.add(i);
            }
        }
        return isVisited[d];
    }
}
