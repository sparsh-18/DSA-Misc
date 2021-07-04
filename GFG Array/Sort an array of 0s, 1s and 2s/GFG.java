// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function template for Java

class Solution
{   // using hi mid lo approach 
    public static void sort012(int a[], int n)
    {
        // code here 
        int lo=0, mid=0, hi=n-1;
        
        while (mid <= hi) {
            int ch = a[mid];
            
            if (ch == 0) {
                int t = a[lo];
                a[lo] = ch;
                a[mid] = t;
                mid++;
                lo++;
            }
            else if (ch == 1) {
                mid++;
            }
            else if (ch == 2) {
                int t = a[hi];
                a[hi] = ch;
                a[mid] = t;
                hi--;
            }
        }
        
    }
}

// { Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends
