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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        // Code here
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        fill(n, new ArrayList<Integer>(), ans);
        // System.out.println(ans);
        return ans;
    }
    
    private void fill(int n, ArrayList<Integer> a, ArrayList<ArrayList<Integer>> ans) {
        if(n == 0) {
            ans.add(new ArrayList<>(a));
            // System.out.println(ans);
            return;
        }
        
        for(int i=n; i>=1; i--) {
            if(a.size() == 0 || i <= a.get(a.size()-1)) {
                a.add(i);
                fill(n-i, a, ans);
                a.remove(a.size()-1);
            }
            // else {
            //     if(i <= a.get(a.size()-1)) {
            //         a.add(i);
            //         fill(n-i, a, ans);
            //         a.remove(a.size()-1);
            //     }
            // }
        }
        
    }
    
}
