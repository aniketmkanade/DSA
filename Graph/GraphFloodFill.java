/*
 * GFG Problem: Flood Fill Algorithm
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * 
 * Time Complexity: O(row*Column)
 * Space Complexity: O(row + column)
 * 
 * Solution:
 * class Solution
  {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int oldColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        if(newColor == oldColor)
            return image;
        floodFillUtil(image, sr, sc, n, m, newColor, oldColor);
        return image;
    }
    
    public void floodFillUtil(int[][] image, int sr, int sc, int n, int m, int newColor, int oldColor)
    {
        image[sr][sc] = newColor;
        
        if(isValid(image, sr+1, sc, n, m, newColor, oldColor))
            floodFillUtil(image, sr+1, sc, n, m, newColor, oldColor);
        if(isValid(image, sr, sc+1, n, m, newColor, oldColor))
            floodFillUtil(image, sr, sc+1, n, m, newColor, oldColor);
        if(isValid(image, sr-1, sc, n, m, newColor, oldColor))
            floodFillUtil(image, sr-1, sc, n, m, newColor, oldColor);
        if(isValid(image, sr, sc-1, n, m, newColor, oldColor))
            floodFillUtil(image, sr, sc-1, n, m, newColor, oldColor);
        
    }
    
    public boolean isValid(int[][] image, int sr, int sc, int n, int m, int newColor, int oldColor){
        if(sr>=0 && sr<n && sc>=0 && sc<m && image[sr][sc] == oldColor)
            return true;
        return false;
    }
  }
 */
package Graph;
public class GraphFloodFill {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{1,1,0},{1,0,1}};

        int n = grid.length-1;
        int m = grid[0].length-1;
        int answer = 0;
        int color = 1;
        int newColor = 2;

        if(newColor == color)
            return;
        floadFill(grid, 1, 1, n, m, color, newColor);

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void floadFill(int[][] grid, int i, int j, int n, int m, int color, int newColor) {
        grid[i][j] = newColor;

        if(isValid(grid,i+1,j,n,m,color,newColor))
            floadFill(grid, i+1, j, n, m, color, newColor);
        if(isValid(grid,i,j+1,n,m,color,newColor))
            floadFill(grid, i, j+1, n, m, color, newColor);
        if(isValid(grid,i-1,j,n,m,color,newColor))
            floadFill(grid, i-1, j, n, m, color, newColor);
        if(isValid(grid,i,j-1,n,m,color,newColor))
            floadFill(grid, i, j-1, n, m, color, newColor);

    }

    private static boolean isValid(int[][] grid, int i, int j, int n, int m, int color, int newColor) {
        if(i>=0 && i<n && j>=0 && j<m && grid[i][j] == color)
            return true;
        return false;
    }
}
