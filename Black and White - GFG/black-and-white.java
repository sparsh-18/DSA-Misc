//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M)
    {
        // add your code here
        long mod = 1000000007L;
        
        long ans = 0L;
        
        int dirs[][] = {{1,2}, {-1,2}, {1,-2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                long count=0l;
                
                for(int dir[]: dirs) {
                    if(inRange(i+dir[0], j+dir[1], N, M))
                        count++;
                }
                
                ans = (ans%mod + (N*M - count-1)%mod) % mod;
            }
        }
        
        return ans%mod;
    }
    
    static boolean inRange(int i, int j, int n, int m) {
        return (i>=0 && i<n && j>=0 && j<m);
    }
}