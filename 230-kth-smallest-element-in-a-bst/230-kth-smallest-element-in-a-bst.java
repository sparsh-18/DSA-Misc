/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Ans ans = new Ans(k);
        
        kthSmall(root, ans);
        
        return ans.data;
    }
    
    private void kthSmall(TreeNode root, Ans ans) {
        if(root == null)
            return;
        
//         if(ans.count == 0) {
//             ans.data = root.val;
//             return;
//         }
            
        kthSmall(root.left, ans);
        
        if(ans.count == 1) {
            ans.data = root.val;
            ans.count--;
            return;
        }
        
        if(ans.count == 0)
            return;
        
        ans.count--;
        
        kthSmall(root.right, ans);
    }
}

class Ans {
    int count;
    int data;
    public Ans(int k) {
        count = k;
        data = Integer.MAX_VALUE;
    }
}