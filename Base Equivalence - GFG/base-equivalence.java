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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int m = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.baseEquiv(n,m));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    String baseEquiv(int n, int m)
    {
        // code here
        int s=2, e=32;
        
        
        while(s<=e) {
            int mid = (s+e)/2;
            
            int count = countDigits(n, mid);
            
            // System.out.println(mid+"\t"+count);
            if(count == m)
                return "Yes";
            
            else if(count > m)
                s=mid+1;
            else
                e=mid-1;
        }
        
        return "No";
    }
    
    int countDigits(int n, int b) {
        int c = 0;
        while(n!=0) {
            c++;
            n/=b;
        }   
        return c;
    }
}