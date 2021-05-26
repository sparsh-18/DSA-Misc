import java.util.ArrayList;

public class GraphAdjList {
    public static void main(String[] args) {
        
        int V = 8; //number of vertices
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V); //Arraylist of Arraylists holding adjacent vertices

        //adding V number of empty arraylists
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,5,7);
        addEdge(adj,0,1);
        addEdge(adj,0,4);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,1,4);
        addEdge(adj,2,3);
        addEdge(adj,3,4);

        printAdjList(adj);

    }

    private static void printAdjList(ArrayList<ArrayList<Integer>> adj) {
        int index=0;
        for (ArrayList<Integer> arrayList : adj) {
            System.out.print("head "+(index++));
            for (int e : arrayList) {
                System.out.print(" --> "+e);
            }
            System.out.println();
        }
    }

    //undirected graph
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j); //adding j in i's list as adjacent
        adj.get(j).add(i); //adding i in j's list as adjacent
    }
    
    
}
