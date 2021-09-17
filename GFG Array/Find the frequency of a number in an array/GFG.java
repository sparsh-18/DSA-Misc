/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		int ar[] = {0, 5, 5, 5, 4};
        int x = 5;
		
		HashMap<Integer,Integer> hp = new HashMap<>();
		
		for (int i: ar) {
		    if(hp.containsKey(i)) {
		        int c = hp.get(i) +1;
		        hp.put(i,c);
		    }else {
		        hp.put(i,1);
		    }
		}
		boolean found=false;
		for (Map.Entry mp: hp.entrySet()) {
		    if ((int)mp.getKey() == x) {
		        System.out.println((int)mp.getValue());
		        found = true;
		    }
		}
		if(!found) System.out.println(-1);
	}
}
