/*
 * GFG Problem: Surrounded Regions
 * Given a matrix of ‘O’ and ‘X’, replace ‘O’ with ‘X’ if surrounded by ‘X’
 * 
 * Time Complexity: O(M*N)
 * Space Complexity: O(M*N)
 */

package Graph;
public class GraphSurroundingRegion {
    public static void main(String[] args) {
        String[][] arr = {{"x", "x", "x", "x"},
                          {"x", "o", "o", "x"},
                          {"x", "x", "o", "x"},
                          {"x", "o", "x", "x"} };
        int n = arr.length; //4
        int m = arr[0].length; //4

        //Step1: Convert corner elements with "o" to "B" and then apply BFS on it
        surroundingRegion(arr, n, m);

        //Step2: Convert all "o" to "x"
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == "o")
                    arr[i][j] = "x";
            }
        }

        //Step3: Convert all "B" to back to "o"
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == "B")
                    arr[i][j] = "o";
            }
        }

        //Step4: Print final output
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void surroundingRegion(String[][] arr, int n, int m) {
        
        for(int i=0; i<n; i++){
            if(arr[i][0] == "o"){
                arr[i][0] = "B";
                dfs(arr, i, 0, n, m);
            }

            if(arr[i][n-1] == "o"){  //[i][3]
                arr[i][n-1] = "B";
                dfs(arr, 0, n-1, n, m);
            }
        }

        for(int i=0; i<m; i++){
            if(arr[0][i] == "o"){
                arr[0][i] = "B";
                dfs(arr, 0, i, n, m);
            }

            if(arr[n-1][i] == "o"){   //[3][i]
                arr[n-1][i] = "B";
                dfs(arr, n-1, i, n, m);
            }
        }
    }

    public static void dfs(String[][] arr, int i, int j, int n, int m) {
        arr[i][j] = "B";
        if(isVisit(arr, i-1, j, n, m))
            dfs(arr, i-1, j, n, m);
        if(isVisit(arr, i+1, j, n, m))
            dfs(arr, i+1, j, n, m);
        if(isVisit(arr, i, j-1, n, m))
            dfs(arr, i, j-1, n, m);
        if(isVisit(arr, i, j+1, n, m))
            dfs(arr, i, j+1, n, m);
    }

    public static boolean isVisit(String[][] arr, int i, int j, int n, int m) {
        if(i>=0 && i<n && j>=0 && j<m && arr[i][j] == "B")
            return true;
        return false;
    }
}
