//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int N, int A[][])
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        
        int sum = 0, i = 0, j = 0;
        
        while(sum <= N*N-1) {
            int x = i, y = j;
            
            while(inRange(x,N) && inRange(y,N) && x+y == sum) {
                ans.add(A[x][y]);
                x++;
                y--;
            }
            
            sum++;
            
            if(sum < N) {
                j++;
                i=0;
            } else{
                i++;
                j=N-1;
            }
        }
        
        return ans;
    }
    
    static boolean inRange(int i, int n) {
        return (i >=0 && i < n);
    }
}
