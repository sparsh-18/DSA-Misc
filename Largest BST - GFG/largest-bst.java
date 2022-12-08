//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        Wrap ans = largestBstHelper(root);
        return ans.n;
    }
    
    static Wrap largestBstHelper(Node root) {
        if(root == null)
            return new Wrap(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        
        Wrap l = largestBstHelper(root.left);
        Wrap r = largestBstHelper(root.right);
        
        int min, max, n;
        boolean isBST;
        
        if(l.isBST && r.isBST && l.max < root.data && r.min > root.data) {
            min = Math.min(root.data, l.min);
            max = Math.max(root.data, r.max);
            n = l.n+r.n+1;
            isBST = true;
        } else {
            min = Math.min(root.data, Math.min(l.min, r.min));
            max = Math.max(root.data, Math.max(l.max, r.max));
            n = Math.max(l.n, r.n);
            isBST = false;
        }
        
        return new Wrap(min, max, n, isBST);
    }
    
}

class Wrap {
    int min, max, n;
    boolean isBST;
    public Wrap(int min, int max, int n, boolean isBST) {
        this.min=min;
        this.max=max;
        this.n=n;
        this.isBST=isBST;
    }
}