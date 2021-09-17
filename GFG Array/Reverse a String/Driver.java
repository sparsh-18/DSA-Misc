// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        StringBuilder sb = new StringBuilder(str);
        int l = sb.length();
        for(int i= 0; i< l/2; i++) {
            char ch = sb.charAt(l-1-i);
            sb.deleteCharAt(l-i-1);
            sb.insert(l-i-1, sb.charAt(i));
            sb.deleteCharAt(i);
            sb.insert(i, ch);
        }
        return sb.toString();
    }
}
