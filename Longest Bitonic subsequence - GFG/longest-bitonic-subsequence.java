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
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        
        // 2021-10-29
        
        int n = nums.length;
        
        int lis[] = new int[n], lds[] = new int[n];
        
        for(int i=0; i<n; i++) {
            int max = 0;
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i])
                    max = Math.max(max, lis[j]);
            }
            lis[i] = max+1;
        }
       
        for(int i=n-1; i>=0; i--) {
            int max = 0;
            for(int j=n-1; j>i; j--){
                if(nums[j] < nums[i])
                    max = Math.max(max, lds[j]);
            }
            lds[i] = max+1;
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++)
            ans = Math.max(ans, lis[i]+lds[i]-1);
        
        return ans;
        
        
        
        // // TLE 250/300
        
        // int ans = 0;
        
        // for(int i=0; i<nums.length; i++)
        //     ans = Math.max(ans, lengthBitonicHelper(nums, i));
        
        // return ans;
    }
    
//     private int lengthBitonicHelper(int nums[], int i) {
//         int dp[][] = new int[nums.length][2];
        
//         for(int a[]: dp)
//             Arrays.fill(a, -1);
            
//         dp[nums.length-1][0] = 1;
//         dp[nums.length-1][1] = 1;
        
//         return lengthBitonic(nums, i, 0, dp);
//     }
    
//     private int lengthBitonic(int nums[], int i, int flag, int dp[][]) {
//         if(i == nums.length)
//             return 0;
        
//         if(dp[i][flag] != -1)
//             return dp[i][flag];
        
//         int sum = 0;
        
//         for(int j=i+1; j<nums.length; j++) {
//             if(nums[j] > nums[i] && flag != 1)
//                 sum = Math.max(sum, lengthBitonic(nums, j, 0, dp));
//             else if(nums[j] < nums[i])
//                 sum = Math.max(sum, lengthBitonic(nums, j, 1, dp));
//         }
        
//         return dp[i][flag] = sum + 1;
//     }

}