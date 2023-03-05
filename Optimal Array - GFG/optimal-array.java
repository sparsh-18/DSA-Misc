//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long arr[]=ob.optimalArray(n,a);
            for(long i:arr){
                out.print(i+" ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    public long[] optimalArray(int n,int a[])
    {
        long s=0,s2=0,ans[]=new long[n];
        
        for(int i=1;i<n;i++) {
           // s+=a[i/2];
            //int median=0;
            if((i+1)%2==0) {
                s+=a[i/2];
                s2+=a[i];
                //median = (a[i/2]+a[i/2+1])/2;
            } else {
                //median = a[i/2];
                s2+=a[i]-a[i/2];
            }
            ans[i]=s2-s;
        }
        return ans;
    }
}
        
