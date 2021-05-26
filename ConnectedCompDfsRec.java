import java.util.*;
public class ConnectedCompDfsRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter vertices");
        int n = sc.nextInt();

        System.out.println("Enter adj matrix");
        int adj[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = sc.nextInt();
            }
        }

        System.out.println();

        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(adj, visited, n, i);
                System.out.println();
            }
            
        }
    }    

    public static void dfs(int adj[][],boolean visited[], int n, int sn) {
        if(!visited[sn]) {
            visited[sn] = true;
            System.out.print(sn+ "  " );
        }
        for (int i = 0; i < n; i++) {
            if(adj[sn][i] == 1 && sn!=i && !visited[i]) {
                dfs(adj,visited,n,i);
            }
        }
    }
}
