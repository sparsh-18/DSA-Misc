class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}
public class BinaryTreeTraversal {
    TreeNode root;

    void inorder(TreeNode n) {
        if (n!=null){
            inorder(n.left);
            System.out.print(n.value + " ");
            inorder(n.right);
        }
    }

    void preorder(TreeNode n) {
        if (n!=null) {
            System.out.print(n.value+" ");
            preorder(n.left);
            preorder(n.right);
        }
    }

    void postorder(TreeNode n) {
        if (n!=null) {
            postorder(n.left);
            postorder(n.right);
            System.out.print(n.value+" ");
        }
    }

    public static void main(String[] args) {
        // Creating a binary tree
        /*
                    1
               2          3
             4   5      6    7
        * */

        BinaryTreeTraversal ob = new BinaryTreeTraversal();

        ob.root = new TreeNode(1);
        ob.root.left = new TreeNode(2);
        ob.root.right = new TreeNode(3);
        ob.root.left.left = new TreeNode(4);
        ob.root.left.right = new TreeNode(5);
        ob.root.right.left = new TreeNode(6);
        ob.root.right.right = new TreeNode(7);

        System.out.println("In order");
        ob.inorder(ob.root);

        System.out.println("\nPre order");
        ob.preorder(ob.root);

        System.out.println("\nPost order");
        ob.postorder(ob.root);
    }
}
