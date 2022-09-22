import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    // O(n logK)
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair());
        
        for(int i=0; i<k; i++)
            pq.add(new Pair(arr[i], i));
        
        int ans[] = new int[n-k+1];
        int a = 0;
        
        ans[a++] = pq.peek().e;
        
        for(int i=k; i<n; i++) {
            pq.add(new Pair(arr[i], i));
            while(pq.peek().i <= i-k)
                pq.poll();
            
            ans[a++] = pq.peek().e;
        }
        
        return ans;
    }
}

class Pair implements Comparator<Pair> {
    int e, i;
    public Pair(){}
    public Pair(int e, int i) {
        this.e = e;
        this.i = i;
    }
    public int compare(Pair a, Pair b) {
        return b.e-a.e;
    }
}