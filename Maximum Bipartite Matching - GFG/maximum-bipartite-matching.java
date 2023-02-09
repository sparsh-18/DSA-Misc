//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
       }
       out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] G)
    {
        // Code here
        int result = 0, m = G.length, n = G[0].length;
        
        int matchR[] = new int[n];
        Arrays.fill(matchR, -1);
        
        for(int applicant = 0; applicant<m; applicant++) {
            boolean seen[] = new boolean[n];
            Arrays.fill(seen, false);
            
            if(bpm(applicant, seen, matchR, G, n, m))
                result++;
        }
        
        return result;
    }
    
    private boolean bpm(int ap, boolean[] seen, int[] matchR, int G[][], int n, int m) {
        
        for(int job=0; job<n; job++) {
            
            if(G[ap][job] == 1 && !seen[job]) {
                seen[job] = true;
                
                if(matchR[job] < 0) {
                    matchR[job] = ap;
                    return true;
                }
                else if(bpm(matchR[job], seen, matchR, G, n, m)) {
                    matchR[job] = ap;
                    return true;
                }
            }
        }
        
        return false;
    }
}