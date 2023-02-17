/*
 * GFG Problem: Rotten Oranges
 * Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
 * 0 : Empty cell
 * 1 : Cells have fresh oranges
 * 2 : Cells have rotten oranges
 * 
 * We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 */
package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphRottingOranges {
    static class Pair{
        int i,j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) {
        int[][] arr = { {2,1,1},
                        {0,1,1},
                        {1,0,1} };
        int n = arr.length;
        int m = arr[0].length;
        int time = 0;

        Queue<Pair> q = new LinkedList<Pair>();
        int count = 0;

        //Step1: Add all elements with "2" to queue
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 2)
                    q.add(new Pair(i,j));
                else if(arr[i][j] == 1)
                    count++;
            }
        }

        //Step2: Checking if any "1" present at beginning
        if(count == 0){
            System.out.println(0);
            return;
        }

        //Step3: BFS + 
        while(!q.isEmpty())
        {
            int size_q = q.size();
            q.poll();
            int temp = 0;

            while(size_q != 0)
            {
                Pair p = q.peek();
                q.poll();

                int x1 = p.i;
                int y1 = p.j;

                int[] ax = {1,-1,0,0};
                int[] ay = {0,0,1,-1};

                for(int z=0; z<ax.length; z++)
                {
                    int x = ax[z] + x1;
                    int y = ay[z] + y1;
                    
                    if(isValid(x, y, n, m, arr))
                    {
                        temp++;
                        arr[x][y] = 2;
                        q.add(new Pair(x, y));
                    }
                }
                size_q--;
            }
            if(temp!=0)
                temp++;
        }
        
        // Checking if 1 still exists
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1){
                    System.out.println(-1);
                    return;
                }
            }
        }
    }

    public static boolean isValid(int i, int j, int n, int m, int[][] arr) {
        if(i>=0 && i<n && j>=0 && j<m && arr[i][j]==1)
            return true;
        return false;
    }   
}
