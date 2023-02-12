/*
 * GFG Problem: Find size of the largest region in Boolean Matrix
 * Consider a matrix, where each cell contains either a ‘0’ or a ‘1’, and any cell containing a 1 is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. If one or more filled cells are also connected, they form a region. find the size of the largest region.
 * 
 * Time Complexity: O(N*M)
 * Space Complexity: O(N*M)
 * 
 */
package Graph;
public class GraphMaxAreaOfIslend {
    public static void main(String[] args) {
        int[][] arr = { {0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,1,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0} };
        int n = arr.length;
        int m = arr[0].length;

        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 1) {
                    int area = maxArea(arr, i, j, n, m);
                    if(answer < area)
                        answer = area;
                }
            }
        }
        System.out.println(answer);
    }

    public static int maxArea(int[][] arr, int i, int j, int n, int m) {
        arr[i][j] = 0;
        int count = 1;

        if(isValid(arr, i-1, j, n, m))
            count = count + maxArea(arr, i-1, j, n, m);
        if(isValid(arr, i+1, j, n, m))
            count = count + maxArea(arr, i+1, j, n, m);
        if(isValid(arr, i, j-1, n, m))
            count = count + maxArea(arr, i, j-1, n, m);
        if(isValid(arr, i, j+1, n, m))
            count = count +  maxArea(arr, i, j+1, n, m);
        return count;
    }

    public static boolean isValid(int[][] arr, int i, int j, int n, int m) {
        if(i>=0 && i<n && j>=0 && j<m && arr[i][j] == 1)
            return true;
        return false;
    }
}
