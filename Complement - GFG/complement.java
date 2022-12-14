//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        // code here
        int org1 = 0;
        char ar[] = str.toCharArray();
        
        for(char ch: ar) {
            if(ch == '1')
                org1++;
        }
        int maxFinal = 0, si = -1, ei = -1;
        int max = 0, s = -1, e = -1;
        
        // int count = org1;
        
        // for(int i=0; i<n; i++) {
        //     if(ar[i] == '0') {
        //         count++;
                
        //         if(count > max) {
        //             max = count;
        //             e = i;
        //             if(s == -1)
        //                 s = i;
        //         }
                
        //     } 
            
        //     else {
        //         count--;
                
        //         if(count < org1) {
        //             if(max > maxFinal || (max == maxFinal && (s < si || si == -1))) {
        //                 maxFinal = max;
        //                 si = s;
        //                 ei = e;
        //             }
        //             max = 0;
        //             s = -1;
        //             e = -1;
        //             count = org1;
        //         }
        //     }
            
        // }
        
        // if(max > maxFinal || (max == maxFinal && (s < si || si == -1))) {
        //     maxFinal = max;
        //     si = s;
        //     ei = e;
        // }
        
        int count = 0;
        
        for(int i=0; i<n; i++) {
            char ch = ar[i];
            
            if(ch == '0') count++;
            else count--;
            
            if(count > maxFinal) {
                maxFinal = count;
                ei = i;
                if(s == -1)
                    s = i;
                    
                si = s;
            }
            
            if(count < 0) {
                count = 0;
                s = i+1;
            }
        }
        
        
        Vector<Integer> ans = new Vector<>();
        
        if(si == -1 || ei == -1)
            ans.add(-1);
        else {
            ans.add(si+1);
            ans.add(ei+1);
        }
        
        return ans;
    }
}