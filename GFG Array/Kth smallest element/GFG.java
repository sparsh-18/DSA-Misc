// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        //using treemap as it store keys in sorted order
        
        TreeMap<Integer, Integer> tp = new TreeMap<>();
        int total = 0;
        for (int e: arr) {
            if (tp.containsKey(e)) {
                int c = tp.get(e) + 1;
                tp.put(e, c);
            }
            else {
                tp.put(e, 1);
            }
           
        }
        
        int f = 0;
        for(Map.Entry mp: tp.entrySet()) {
            f += (int)mp.getValue();
            if(f>=k) {
                return (int)mp.getKey();
            }
        }
        return -1;
    } 
}
