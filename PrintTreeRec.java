import java.util.ArrayList;
import java.util.Scanner;

class Treenode<T> {
    T data;
    ArrayList<Treenode<T>> children;

    public Treenode(T data){
        this.data = data;
        children = new ArrayList<>();
    }
}

public class PrintTreeRec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Treenode<Integer> root = takeInput(sc);

        printRec(root);
    }

    private static void printRec(Treenode<Integer> root) {
        StringBuffer sb = new StringBuffer();
        sb.append(root.data);
        sb.append(": ");

        for (Treenode<Integer> t:
             root.children) {
            sb.append(t.data);
            sb.append(" ");
        }

        System.out.println(sb.toString());

        for (Treenode<Integer> t:
                root.children) {
            printRec(t);
        }
    }

    private static Treenode<Integer> takeInput(Scanner sc) {
        System.out.println("Enter value to be inserted");
        int n = sc.nextInt();
        Treenode<Integer> t = new Treenode<>(n);

        System.out.println("Enter number of children of "+n);
        int c = sc.nextInt();

        for (int i = 0; i < c; i++) {
            Treenode<Integer> child = takeInput(sc);
            t.children.add(child);
        }
        return t;
    }
}
