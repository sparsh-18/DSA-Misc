//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    
	    int sum = 0;
	    for(int e: arr)
	        sum+=e;
	    
	    int dp[][] = new int[n+1][sum+1];
	    
	    for(int r[]: dp)
	        Arrays.fill(r, -1);
	  
	    return calculateDiff(arr, n, sum, dp, sum);
	    
	}
	
	private int calculateDiff(int[] arr, int n, int sum, int[][] dp, int totalSum) {
	    if(n == 0)
	        return Math.abs(2*sum - totalSum);
	   
	    if(dp[n][sum] == -1) {
	        int maxDiff = Math.abs(2*sum - totalSum);
	        
	        int includedDiff = calculateDiff(arr, n-1, sum-arr[n-1], dp, totalSum);
	        int excludedDiff = calculateDiff(arr, n-1, sum, dp, totalSum);
	        
	        return dp[n][sum] = Math.min(maxDiff, Math.min(includedDiff, excludedDiff));
	    }
	    
	    else return dp[n][sum];
	    
	}
	
}

