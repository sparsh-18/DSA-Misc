//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        
        ArrayList<Node> ans = new ArrayList<>();
        
        int a[] = new int[26];
        int n = s.length();
        
        for(int i=0; i<n; i++) {
            a[s.charAt(i)-'a']++;
        }
        
        Node r = head, l = head;
        int b[] = new int[26];
        int count = 0;
        
        while(l != null && count<n) {
            b[l.data-'a']++;
            count++;
            l=l.next;
        }
        
        while(r != null) {
            if(count == n) {
                if(checkEqual(a, b)) {
                    Node result = createList(r, n);
                    ans.add(result);
                    r = l;
                    count = 0;
                    b = new int[26];
                }
                else {
                    b[r.data-'a']--;
                    count--;
                    r = r.next;
                }
            }
            else {
                if(l == null)
                    break;
                    
                b[l.data-'a']++;
                count++;
                l=l.next;
            }
        }
        
        return ans;
    }
    
    private static Node createList(Node head, int s) {
        if(head == null)
            return null;
        Node t = head;
        Node h = new Node(t.data);
        Node newHead = h;
        s--;
        
        while(s-->0 && t.next!=null) {
            t=t.next;
            Node temp = new Node(t.data);
            h.next = temp;
            h = h.next;
        }
        
        return newHead;
    }
    
    private static boolean checkEqual(int a[], int b[]) {
        for(int i=0; i<26; i++) {
            if(a[i] != b[i])
                return false;
        }
        
        return true;
    }
}