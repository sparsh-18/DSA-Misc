//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int removals(int[] arr, int n, int k) {
        // code here
        
        Arrays.sort(arr);
        
        int dp[][] = new int[n][n];
        
        for(int d=1; d<n; d++) {
            int i=0, j=i+d;
            while(i<n && j<n){
                int left = 1 + dp[i][j-1];
                int bottom = 1 + dp[i+1][j];
                int diag = 2 + dp[i+1][j-1];
                
                int min = Math.min(left, Math.min(bottom, diag));
                
                if(arr[j]-arr[i] <= k)
                    min = Math.min(0, min);
                
                dp[i][j] = min;
                
                i++;
                j++;
            }
        }
        
        return dp[0][n-1];
    }
}