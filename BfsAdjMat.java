import java.util.*;
public class BfsAdjMat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter no of vertices");
        int n = sc.nextInt();

        System.out.println("Enter adj matrix");

        int adjmat[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjmat[i][j] = sc.nextInt();
            }   
        }
        System.out.println("\n Matrix:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjmat[i][j]+"\t");
            }   
            System.out.println();
        }

        Bfs(adjmat,n, 0);
    }

    public static void Bfs(int[][] adjmat, int n,int startnode) {
        boolean visited[] = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        q.add(startnode);
        visited[startnode] = true;

        while(q.size() != 0) {
            
            int ele = q.remove();
            // visited[ele] = true;
            System.out.print(ele+"  ");

            for (int i = 0; i < n; i++) {
                if(adjmat[ele][i] == 1  && !visited[i] && ele!=i){
                    q.add(i);
                    visited[i] = true;
                }    
            }
        }

    }
}
