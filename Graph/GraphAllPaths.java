package Graph;
import java.util.ArrayList;
@SuppressWarnings("unchecked")
public class GraphAllPaths {
    int v;
    ArrayList<Integer>[] arr;
    GraphAllPaths(int v){
        this.v = v;
        arr = new ArrayList[v];
        for(int i=0; i<v; i++)
            arr[i] = new ArrayList<>();
    }

    void addEdge(int a, int b){
        arr[a].add(b);
    }

    public static void main(String[] args) {
        GraphAllPaths t = new GraphAllPaths(4);
        t.addEdge(0, 1);
        t.addEdge(1, 2);
        t.addEdge(2, 3);
        t.addEdge(0, 3);
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        t.paths(0, 3, path, answer);
        for(int i=0; i<answer.size(); i++){
            for(int j=0; j<answer.get(i).size(); j++)
                System.out.print(answer.get(i).get(j) + " ");
            System.out.println();
        }
    }

    public void paths(int i, int j, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> answer) {
        path.add(i);
        if(i == j)
            answer.add(path);
        else{
            for(int k=0; k<arr[i].size(); k++){
                paths(k, j, path, answer);
            }
        }
        path.remove(i);
    }
}
