
/*
 * Question: Find the number of islands
 * Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.
 * Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
 * 
 * GFG Solution:
 * class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid){
        int answer = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n; i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    answer++;
                    numIslandsUtil(grid, i, j, n, m);
                }
            }
        }
        return answer;
    }
    
    public void numIslandsUtil(char[][] grid,int i,int j,int row,int column){
        grid[i][j] = '0';
        if(isValid(grid, i+1, j, row,column))
            numIslandsUtil(grid, i+1, j, row, column);
        if(isValid(grid, i-1, j, row,column))
            numIslandsUtil(grid, i-1, j, row, column);
        if(isValid(grid, i, j+1, row,column))
            numIslandsUtil(grid, i, j+1, row, column);
        if(isValid(grid, i, j-1, row,column))
            numIslandsUtil(grid, i, j-1, row, column);
        //for digonals
        if(isValid(grid, i+1, j+1, row,column))
            numIslandsUtil(grid, i+1, j+1, row, column);
        if(isValid(grid, i-1, j-1, row,column))
            numIslandsUtil(grid, i-1, j-1, row, column);
        if(isValid(grid, i+1, j-1, row,column))
            numIslandsUtil(grid, i+1, j-1, row, column);
        if(isValid(grid, i-1, j+1, row,column))
            numIslandsUtil(grid, i-1, j+1, row, column);
    }
    
    public boolean isValid(char[][] grid,int i,int j,int row,int column){
        if(i>=0 && i<row && j>=0 && j<column && grid[i][j] == '1')
            return true;
        return false;
    }
  }
 */
package Graph;
public class GraphIslandProblem 
{
    public static void main(String[] args) {
        char[][] grid ={ {'1','1','0','0','0'},
                         {'1','1','0','0','0'}, 
                         {'0','0','1','0','0'}, 
                         {'0','0','0','1','1'} };
        int answer = 0;
        //Length of rows i.e. 4
        for(int i=0;i<grid.length;i++){ 
            //Length of columns i.e. 5
            for(int j=0;j<grid[0].length;j++){ 
                if(grid[i][j] == '1'){
                    answer++;
                    numOfIslands(grid, i, j, grid.length, grid[0].length);
                }
            }
        }
        System.out.println(answer);
    }

    public static void numOfIslands(char[][] grid, int i, int j, int row, int column) {
        //We transform visited values from "1" to "0" so that 
        //they shouldn't take part in operation afterwards
        grid[i][j] = '0';

        //Check for valid neighbours toi traverse with conditions
        //1. Neighbour value should be '1'
        //2. Neighbour should be within grid size
        if(isValid(grid, i+1, j, row, column))
            numOfIslands(grid, i+1, j, row, column);

        if(isValid(grid, i-1, j, row, column))
            numOfIslands(grid, i-1, j, row, column);

        if(isValid(grid, i, j+1, row, column))
            numOfIslands(grid, i, j+1, row, column);

        if(isValid(grid, i, j-1, row, column))
            numOfIslands(grid, i, j-1, row, column);
    }

    private static boolean isValid(char[][] grid, int i, int j, int row, int column) {
        if(i >=0 && i<row && j>=0 && j<column && grid[i][j] == '1')
            return true;
        return false;
    }    
}
