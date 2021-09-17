/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        int l = arr.length;
        
        int n =0, p=0;
        
        while (p < l){
            int ch = arr[p];
            
            if(ch < 0) {
                swap(arr,p,n);
                p++;
                n++;
            }
            else if(ch >= 0){
                p++;
            }
        }
        
        for(int e: arr) {
            System.out.print(e+", ");
        }
	}
	
	public static void swap(int arr[], int i, int j) {
	    int t = arr[i];
	    arr[i] = arr[j];
	    arr[j] = t;
	}
}
