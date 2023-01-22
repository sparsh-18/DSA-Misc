//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int K;
            K = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.solve(N, K, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int solve(int N, int K, int[] arr) {
        // code here
        int sum = findSum(arr);
        
        int prefixSum[] = computeSum(N, arr);
        
        ArrayList<Integer> factors = computeFactors(sum);
        
        Collections.sort(factors);
        Collections.reverse(factors);
        
        for(int factor: factors) {
            int count = 0;
            for(int e: prefixSum) {
                if(e%factor == 0)
                    count++;
            }
            
            if(count >= K)
                return factor;
        }
        
        return -1;
    }
    
    private static int findSum(int arr[]) {
        int sum=0;
        
        for(int e: arr)
            sum+=e;
        
        return sum;
    }
    
    private static int[] computeSum(int n, int ar[]) {
        int ps[] = new int[n];
        ps[0] = ar[0];
        
        for(int i=1; i<n; i++) {
            ps[i] = ps[i-1] + ar[i];
        }
        
        return ps;
    }
    
    private static ArrayList<Integer> computeFactors(int sum) {
        ArrayList<Integer> factors = new ArrayList<>();
        
        for(int i=1; i*i <= sum; i++) {
            if(sum % i == 0) {
                factors.add(i);
                factors.add(sum/i);
            }
        }
        
        return factors;
    }
}
        
