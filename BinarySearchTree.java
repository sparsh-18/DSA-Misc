public class BinarySearchTree {
    TreeNode root;
    BinarySearchTree() {
        root = null;
    }

    void add(int n) {
        root=addInBst(root,n);
    }

    public TreeNode addInBst(TreeNode root, int n) {
        if (root == null) {
            root = new TreeNode(n);
            return root;
        }
        else {
            if (n <= root.value){
                root.left=addInBst(root.left, n);
            }
            else {
                root.right=addInBst(root.right, n);
            }
            return root;
        }
    }

    void isPresent(int n){
        if(findintree(root,n)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }

    public boolean findintree(TreeNode root, int n) {
        if(root != null) {
            if (root.value == n) return true;

            if (n > root.value) return findintree(root.right,n);

            else return findintree(root.left,n);
        } else {
            return false;
        }
    }

    void inorder(TreeNode n) {
        if (n!=null){
            inorder(n.left);
            System.out.print(n.value + " ");
            inorder(n.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree ob = new BinarySearchTree();
        ob.add(10);
        ob.add(30);
        ob.add(5);
        ob.add(15);
        ob.add(7);
        ob.add(40);

        /*
                     10
                 /       \
               5          30
                \        /   \
                 7      15    40
        * */

        ob.inorder(ob.root);

        System.out.println();

        ob.isPresent(7);
    }
}
