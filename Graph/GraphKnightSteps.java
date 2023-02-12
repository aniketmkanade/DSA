/*
 * GFG Problem: Knight Walk
 * Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.If it cannot reach the target position return -1.
 * Note:
 * The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.
 * 
 * Time Complexity: O(V*E)
 * Space Complexity: O(V*E)
 * 
 * 
 */
package Graph;
import java.util.LinkedList;
import java.util.Queue;

public class GraphKnightSteps {
    static class Pair{
        int first,second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[] knightPosition = {4,5};
        int x1 = knightPosition[0]-1;
        int y1 = knightPosition[1]-1;

        int[] targetPosition = {1,1};
        int tx = targetPosition[0]-1;
        int ty = targetPosition[1]-1;

        if(tx == x1 && ty == y1){
            System.out.println(0);
            return;
        }

        boolean[][] isVisited = new boolean[8][8];
        int[] xa = {1,1,-1,-1,2,-2,2,-2};
        int[] ya = {2,-2,2,-2,1,1,-1,-1};

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x1, y1));
        isVisited[x1][y1] = true;
        
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            ans++;

            while(size != 0) {
                Pair top = q.peek();
                q.poll();

                int x = top.first;
                int y = top.second;
        
                for(int i=0; i<8; i++) {
                    int nx = x + xa[i];
                    int ny = y + ya[i];
                    if(nx == tx && ny == ty) {
                        System.out.println(ans);
                        return;
                    }

                    if(isValid(nx, ny, isVisited)) {
                        isVisited[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
                size--;
            }
        }
        System.out.println(ans);
    }   
    
    static boolean isValid(int x, int y, boolean[][] isVisited){
        if(x>=0 && x<8 && y>=0 && y<8 && isVisited[x][y] == false)
            return true;
        return false;
    }
}
