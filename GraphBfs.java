import java.util.*;

public class GraphBfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of vertices");
        int V = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        System.out.println("Enter number of adj list");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter edges");
            int a=sc.nextInt(),b=sc.nextInt();
            addEdge(adj,a,b);
        }

        System.out.println("\n\n Adjacency List:");
        printList(adj);

        System.out.println("\n BFS traversal:\n Enter start node\n\n");
        int startnode = sc.nextInt();
        bfs(adj, V ,startnode);

    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj,int V, int startnode) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(startnode);
        visited[startnode] = true;
        
        while (q.size() != 0) {
            int s = q.remove();
            System.out.print(s+" ");

            ArrayList<Integer> a = adj.get(s);
            for(int n: a) {
                if(!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    public static void printList(ArrayList<ArrayList<Integer>> adj) {
        int counter = 0;
        for (ArrayList<Integer> arrayList : adj) {
            System.out.print("head "+ counter++);
            for (int e : arrayList) {
                System.out.print(" --> "+e);
            }
            System.out.println();
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int a, int b) {
        adj.get(a).add(b);
    }    
    
}
