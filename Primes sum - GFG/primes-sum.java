//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String isSumOfTwo(int N){
        // code here
        boolean sieve[] = buildSieve(N);
        
        for(int i=2; i<N; i++){
            // System.out.println(i+"\t"+sieve[i]);
            if(sieve[i] && sieve[N-i])
                return "Yes";
        }
        return "No";
    }
    
    static boolean[] buildSieve(int N) {
        boolean sieve[] = new boolean[N+1];
        Arrays.fill(sieve, true);
        
        sieve[0] = false;
        sieve[1] = false;
        
        for(int i=2; i<=N; i++) {
            if(!sieve[i])
                continue;
                
            int times = 2;
            while(times*i <= N) {
                sieve[times*i] = false;
                times++;
            }
            
        }
        
        return sieve;
    }
}