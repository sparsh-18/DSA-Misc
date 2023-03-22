//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	    // code here
        Stack<Character> st = new Stack<>();
        
        if(X >= Y) {
            long c1 = calc(S, "pr", st);
            StringBuffer sb = new StringBuffer();
            while(!st.isEmpty()) {
                sb.append(st.pop());
            }
            sb.reverse();
            long c2 = calc(sb.toString(), "rp", st);
            
            return c1*X+c2*Y;
        } else {
            long c1 = calc(S, "rp", st);
            StringBuffer sb = new StringBuffer();
            while(!st.isEmpty()) {
                sb.append(st.pop());
            }
            sb.reverse();
            long c2 = calc(sb.toString(), "pr", st);
            
            return c1*Y+c2*X;
        }
	}
	
	private static long calc(String s, String rep, Stack<Character> st) {
	    char a = rep.charAt(0), b = rep.charAt(1);
	    
	    long count = 0;
	    
	    for(int i=0; i<s.length(); i++) {
	        char ch = s.charAt(i);
	        
	        if(!st.isEmpty() && ch == b && st.peek() == a) {
	            st.pop();
	            count++;
	            continue;
	        }
	        
	        st.push(ch);
	    }
	    
	    return count;
	}
} 
