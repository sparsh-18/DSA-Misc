import java.util.*;

public class GraphDfs {
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

        System.out.println("\n DFS iterator traversal:\n Enter start node\n\n");
        int startnode = sc.nextInt();
        dfs(adj, V ,startnode);

        System.out.println("\n DFS recursion traversal:\n Enter start node\n\n");
        startnode = sc.nextInt();
        dfs_rec(adj,startnode, V);
    }

    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int v, int startnode) {

        boolean visited[] = new boolean[v];

        Stack st = new Stack();

        st.push(startnode);

        while(!st.empty()) {
            int s = (int)st.pop();

            if(!visited[s]) {
                System.out.print(s+" ");
                visited[s] = true;
            }

            ArrayList<Integer> a = adj.get(s);

            for (Integer e : a) {
                if(!visited[e]){
                    st.push(e);
                }
            }
        }
    }

    public static void dfs_rec(ArrayList<ArrayList<Integer>> adj,int startnode, int V) {
        boolean visited[] = new boolean[V];
        dfs_rec_fun(adj,startnode, visited); //this function is used for recursion because boolean visited array was not in main
    }

    private static void dfs_rec_fun(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;
            System.out.print(node+", ");
        }
        ArrayList<Integer> a = adj.get(node);
        for (Integer e : a) {
            if(!visited[e]) {
                dfs_rec_fun(adj,e,visited);
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
