//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String BalancedString(int N) {
        // code here
        
        if(N % 2 == 0)
            return BalancedStringEven(N);
        else
            return BalancedStringOdd(N);
    }
    
    static String BalancedStringEven(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 26) {
            for(char i='a'; i<='z'; i++)
                sb.append(i);
            n-=26;
        }
        
        for(int i=0; i<n/2; i++) {
            sb.append((char)('a' + i));
        }
        
        for(int i=26-n/2; i<26; i++) {
            sb.append((char)('a' + i));
        }
        
        return sb.toString();
    }
    
    static String BalancedStringOdd(int n) {
        StringBuilder sb = new StringBuilder();
        
        int sum = 0, t=n;
        while(t!=0) {
            sum += (t%10);
            t/=10;
        }
        
        while(n > 26) {
            for(char i='a'; i<='z'; i++)
                sb.append(i);
            n-=26;
        }
        
        int a=0,b=0;
        if(sum %2 == 0) {
            a = (n+1)/2;
            b = (n-1)/2;
        } else {
            a = (n-1)/2;
            b = (n+1)/2;
        }
        
        for(int i=0; i<a; i++) {
            sb.append((char)('a' + i));
        }
        
        for(int i=26-b; i<26; i++) {
            sb.append((char)('a' + i));
        }
        
        return sb.toString();
    }
}