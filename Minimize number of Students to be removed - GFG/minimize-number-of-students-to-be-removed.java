//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N) {
        // code here
        
        int lis = findLis(H, N);
        
        return N-lis;
    }
    
    private int findLis(int ar[], int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            int l = temp.size();
            
            if(l==0 || ar[i] > temp.get(l-1))
                temp.add(ar[i]);
            
            else {
                int ind = Collections.binarySearch(temp, ar[i]);
                if(ind < 0)
                    ind = -1*ind -1;
                
                temp.set(ind, ar[i]);
            }
        }
        
        return temp.size();
    }
};