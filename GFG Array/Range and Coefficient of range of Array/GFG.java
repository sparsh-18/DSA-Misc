/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		int a[] = {15, 16, 10, 9, 6, 7, 17};
		
		int max = a[0], min = a[0];
		
		for(int e: a) {
		    if(e < min)
		        min = e;
		    if(e > max)
		        max = e;
		}
		
		System.out.println("Range: "+(max-min));
		System.out.println("Coeff of Range: "+(max-min)*1.0/(max+min));
	}
}
