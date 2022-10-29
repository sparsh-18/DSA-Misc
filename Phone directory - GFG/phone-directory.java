//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        
        TrieNode root = new TrieNode('\0');
        
        for(String str: contact) {
            insertTrie(str, root);
        }
        
        // ArrayList<String> l = new ArrayList<>();
        // TrieNode t = searchPrefix("geei", root);
        // getWords(t, l, new StringBuilder());
        
        // for(String i: l) System.out.println(i);
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        for(int i=1; i<=s.length(); i++) {
            String str = s.substring(0, i);
            
            ArrayList<String> list = new ArrayList<>();
            
            TrieNode prefixNode = searchPrefix(str, root);
            StringBuilder sb = new StringBuilder(str.substring(0, str.length()-1));
            
            getWords(prefixNode, list, sb);
            
            if(list.size() > 0)
                ans.add(list);
            else {
                list.add("0");
                ans.add(list);
            }
                
        }
        
        return ans;
        
    }
    
    static void getWords(TrieNode node, ArrayList<String> list, StringBuilder sb) {
        if(node == null)
            return;
            
        sb.append(node.value);
        
        if(node.isWord) {
            list.add(sb.toString());
        }
        
        for(TrieNode child: node.children) {
            if(child != null) {
                getWords(child, list, sb);
            }
        }
        
        sb.deleteCharAt(sb.length()-1);
    }
    
    static TrieNode searchPrefix(String s, TrieNode root) {
        if(root == null)
            return null;
            
        if(s.length() == 0)
            return root;
        
        char ch = s.charAt(0);
        int index = ch-'a';
        
        TrieNode child = root.children[index];
        
        if(child != null)
            return searchPrefix(s.substring(1), child);
        else
            return null;
    }
    
    static void insertTrie(String s, TrieNode root) {
        if(s.length() == 0) {
            root.isWord = true;
            return;
        }
        
        char ch = s.charAt(0);
        int index = ch-'a';
        
        if(root.children[index] == null) {
            TrieNode child = new TrieNode(ch);
            root.children[index] = child;
            root.childCount++;
        }
        
        insertTrie(s.substring(1), root.children[index]);
    }
}

class TrieNode {
    char value;
    boolean isWord;
    TrieNode[] children;
    int childCount;
    
    public TrieNode(char v) {
        value=v;
        isWord=false;
        children = new TrieNode[26];
        childCount=0;
    }
}