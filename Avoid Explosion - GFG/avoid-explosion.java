//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int mix[][] = new int[n][2];
            int danger[][] = new int[m][2];

            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                mix[i][0] = Integer.parseInt(s[0]);
                mix[i][1] = Integer.parseInt(s[1]);
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                danger[i][0] = Integer.parseInt(s[0]);
                danger[i][1] = Integer.parseInt(s[1]);
            }
            Solution soln = new Solution();

            ArrayList<String> ans = soln.avoidExlosion(mix, n, danger, m);

            for (String x : ans) ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }

}
// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {
        // Code Here
        ArrayList<String> ans = new ArrayList<>();
        
        int par[] = new int[n+1];
        
        for(int i=1; i<=n; i++)
            par[i] = i;
        
        for(int xy[]: mix) {
            int x = xy[0], y = xy[1];
            int xPar = find(x, par), yPar = find(y, par);
            boolean safe = true;
            
            for(int dxy[]: danger) {
                int dx = dxy[0], dy = dxy[1];
                int dxPar = find(dx, par), dyPar = find(dy, par);
                
                if((xPar == dxPar && yPar == dyPar) || (xPar == dyPar && yPar == dxPar)) {
                    safe = false;
                    break;
                }
            }
            
            if(safe) {
                ans.add("Yes");
                par[yPar] = xPar;
            } else {
                ans.add("No");
            }
        }
        
        return ans;
    }
    
    private int find(int n, int par[]) {
        if(n == par[n])
            return n;
        else
            return par[n] = find(par[n], par);
    }
}
