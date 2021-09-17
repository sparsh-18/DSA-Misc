/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    public static boolean findxinkindowSize(int n, int arr[], int x, int k) {
        boolean found = false;
        int rem = arr.length % k;
        outer: for(int i = 0; i<arr.length -rem; i+=k) {
            int j = i;
            while(j<i+k) {
                if(arr[j] == x) {
                    found = true;
                    continue outer;
                }
                j++;
            }
            if(j == i+k){ found = false; break;}
        }
        if(found && rem!=0) {
            int i =arr.length-rem; 
            while (i<arr.length) {
                if(arr[i] == x){ found = true; break;}
                i++;
            }
            
            if(i == arr.length) found = false;
        }

        return found;
    }
    
	public static void main(String args[])
    {
        int arr[] = new int[] { 3, 5, 2, 4,  9,  3,
                                1, 7, 31, 13, 1, 3 };
        int x = 3, k = 4;
        int n = arr.length;
        if (findxinkindowSize(n, arr, x, k))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

