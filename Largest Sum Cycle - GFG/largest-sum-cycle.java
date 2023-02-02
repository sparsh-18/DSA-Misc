//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long ans = -1;
    public long largesSumCycle(int N, int Edge[]){
        ans = -1;
        boolean[] vis = new boolean[N], pathvis = new boolean[N];
        
        for(int i=0; i<N; i++) {
            if(!vis[i])
                dfs(i, N, Edge, vis, pathvis);
        }
        
        return ans;
    }
    
    private void dfs(int i, int N, int Edge[], boolean vis[], boolean pathvis[]) {
        vis[i] = true;
        pathvis[i] = true;
        
        int adj = Edge[i];
        
        if(adj != -1){
        
            if(!vis[adj]) {
                dfs(adj, N, Edge, vis, pathvis);
            }
            else if(pathvis[adj]) {
                
                long sum = 0l;
                int c = adj;
                
                do {
                    sum += c;
                    c = Edge[c];
                }while(c!=adj);
                
                ans = Math.max(sum, ans);
            }
            
        }
        
        pathvis[i] = false;
    }
}