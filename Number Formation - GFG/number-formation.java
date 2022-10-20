//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.getSum(x, y, z));
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

class Solution {
    
    public int getSum(int X, int Y, int Z) {
        // Your code goes here
        
        int mod = 1000000007;
        
        long sum[][][] = new long[X+1][Y+1][Z+1];
        long times[][][] = new long[X+1][Y+1][Z+1];
        
        times[0][0][0] = 1;
        
        long ans = 0;
        
        for(int i=0; i<=X; i++) {
            for(int j=0; j<=Y; j++) {
                for(int k=0; k<=Z; k++) {
                    
                    if(i>0) {
                        sum[i][j][k] +=  (sum[i-1][j][k]*10 % mod + 4 * times[i-1][j][k] % mod) % mod;
                        
                        times[i][j][k] += times[i-1][j][k] % mod;
                    }
                    
                    
                    if(j>0) {
                        sum[i][j][k] +=  (sum[i][j-1][k]*10 % mod + 5 * times[i][j-1][k] % mod) % mod;
                        
                        times[i][j][k] += times[i][j-1][k] % mod;
                    }
                    
                    
                    if(k>0) {
                        sum[i][j][k] +=  (sum[i][j][k-1]*10 % mod + 6 * times[i][j][k-1] % mod) % mod;
                        
                        times[i][j][k] += times[i][j][k-1] % mod;
                    }
                    
                    ans += sum[i][j][k] % mod;
                    ans %= mod;
                }
            }
        }
        
        return (int)ans;
    }
}