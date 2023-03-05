//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int i=0, j=0;
        // boolean f = false;
        while(i<S.length() && j<T.length()) {
            char cs = S.charAt(i), ct = T.charAt(j);
            
            if(Character.isDigit(ct)) {
                int c = (int)(ct-'0');
                int t = j+1;
                while(t<T.length() && Character.isDigit(T.charAt(t))) {
                    c = c*10 + (int)(T.charAt(t)-'0');
                    t++;
                }
                j=t;
                i+=c;
            } else {
                // f=true;
                if(ct == cs) {
                    i++;
                    j++;
                } else
                    return 0;
            }
            // j++;
        }
        
        return (i == S.length() && j == T.length()) ? 1 : 0;
    }
}