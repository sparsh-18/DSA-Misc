//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long jumpingNums(long X) {
        // code here
        Queue<Long> q = new LinkedList<>();
        
        for(long i=0; i<=9; i++)
            q.add(i);
            
        long ans = 0l;
        
        while(!q.isEmpty()) {
            long n = q.remove();
            
            if(n > X || n == 0)
                continue;
            
            long last_dig = n % 10;
            
            long n01 = n*10 + last_dig - 1;
            long n02 = n*10 + last_dig + 1;
            
            
            if(n01 <= X && last_dig != 0) {
                q.add(n01);
                ans = Math.max(ans, n01);
            }
                
            
            if(n02 <= X && last_dig != 9) {
                q.add(n02);
                ans = Math.max(ans, n02);
            }
            
        }
        
        return ans;
    }
};