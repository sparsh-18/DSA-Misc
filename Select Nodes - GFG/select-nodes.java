//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int[][]edge=new int[N-1][2];
            for(int i=0;i<N-1;i++)
            {
                String input[] = read.readLine().trim().split("\\s+");
                edge[i][0]=Integer.parseInt(input[0]);
                edge[i][1]=Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            out.println(ob.countVertex(N, edge));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    public int countVertex(int N, int[][] edges){
        // code here
        
        boolean vis[] = new boolean[N+1];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<=N; i++)
            adj.add(new ArrayList<>());
        
        for(int edge[]: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Ans a = new Ans();
        
        dfs(1, adj, vis, a);
        
        return a.count;
    }
    
    private boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean vis[], Ans a) {
        vis[i] = true;
        boolean sel = false;
        
        for(int neigh: adj.get(i)) {
            if(!vis[neigh]) {
                boolean isChildSelect = dfs(neigh, adj, vis, a);
                
                if(!isChildSelect)
                    sel = true;
            }
        }
        
        if(sel) a.count++;
        
        return sel;
    }
}

class Ans {
    int count;
    public Ans() {
        count = 0;
    }
}

//{ Driver Code Starts.

// } Driver Code Ends