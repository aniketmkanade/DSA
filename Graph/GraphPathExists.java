/*
 * While going from source to destination, is path possible?
 */
package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
@SuppressWarnings("unchecked")
public class GraphPathExists 
{
    int v;
    ArrayList<Integer>[] arr;
    GraphPathExists(int v){
        this.v = v;
        arr = new ArrayList[v];
        for(int i=0; i<v; i++){
            arr[i] = new ArrayList<>();
        }
    }

    void addEdge(int i, int j){
        arr[i].add(j);
        arr[j].add(i);
    }

    boolean ifGraphExists(int start, int end){
        boolean[] isVisited = new boolean[v];
        Queue<Integer> q = new LinkedList<Integer>();
        isVisited[start] = true;
        q.add(start);

        while (!q.isEmpty()) 
        {
            int top = q.peek();
            q.poll();

            for(int i=0; i<arr[top].size(); i++){
                if(arr[top].get(i) == end)
                    return true;
                if(!isVisited[top]){
                    q.add(arr[top].get(i));
                    isVisited[top] = true;
                }
            }
        }
        return isVisited[end];
    }

    public static void main(String[] args) {
        GraphPathExists t = new GraphPathExists(3);
        t.addEdge(0, 1);
        t.addEdge(1, 2);
        t.addEdge(2, 0);
        System.out.println(t.ifGraphExists(0, 2));;
    }
}
