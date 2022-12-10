//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String buildLowestNumber(String str, int N) {
        // code here
        
        Stack<Character> st= new Stack<>();
        
        if(N == str.length())
            return "0";
        
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            while(!st.isEmpty() && st.peek() > ch && N>0) {
                N--;
                st.pop();
            }
            
            st.push(ch);
        }
        
        while(N-->0)
            st.pop();
        
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        
        while(sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        
        if(sb.length() == 0)
            return "0";
        return sb.toString();
    }
}