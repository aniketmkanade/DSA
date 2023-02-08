/*
 * Find the town judge 
 * Everyone trusts judge but judge trusts no one
 */
package Graph;
public class GraphFindTheJudge 
{
    public static void main(String[] args) {
        int v = 3;
        int[][] arr = {{1,3},{2,3}};
        System.out.println(findJudge(v, arr));;
    }

    private static int findJudge(int v, int[][] arr) {
        // Here, nodes are 1,2,3 and not 0,1,2
        int trustGains[] = new int[v+1];

        // calculate gains indexes{0,1} -> values{1,3} 
        for(int[] i: arr){
            trustGains[i[0]]--;
            trustGains[i[1]]++;
        } 

        // Default value is -1
        int judge= -1;

        // Checks if gains equals to v-1 i.e. [inDegree - outDegree = n-1]   
        for(int i=1; i<=v; i++){
            if(trustGains[i] == v-1)
                judge = i;
        }
        return judge;
    }
}