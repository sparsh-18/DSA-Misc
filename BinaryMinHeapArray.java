import java.util.ArrayList;
import java.util.Scanner;

public class BinaryMinHeapArray {
    int[] minheap;
    int index;
    int front;

    public BinaryMinHeapArray(int s) {
        minheap = new int[s];
        front = 1;
        index = 0;
        minheap[0] = Integer.MIN_VALUE;
    }

    public void insert(int n) {
        minheap[++index] = n;

        int current = index;

        while(minheap[current] < minheap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void minheapify(int position) {
        if(!leaf(position)) {
            if(minheap[position] < minheap[leftchild(position)] || minheap[position] < minheap[rightchild(position)]) {
                if(minheap[leftchild(position)] < minheap[rightchild(position)]) {
                    swap(position, leftchild(position));
                } else {
                    swap(position, rightchild(position));
                }
               if(parent(position) > 0) minheapify(parent(position));
            }
        }
    }

    public int getmin() {
        if(front > index) return -1;
        int minimumelement = minheap[front];

        minheap[front] = minheap[index];
        index--;

        minheapify(front);

        return minimumelement;
    }

    private int rightchild(int position) {
        return position/2 + 1;
    }

    private int leftchild(int position) {
        return position*2;
    }

    private boolean leaf(int position) {
        if(position > index/2 && position <= index) return true;
        return false;
    }

    private void swap(int current, int parent) {
        int t = minheap[current];
        minheap[current] = minheap[parent];
        minheap[parent] = t;
    }

    private int parent(int current) {
        if(current <= index)
            return current/2;
        else return -1;
    }

    public void print() {
        for(int i: minheap) {
            if(i>0) System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        BinaryMinHeapArray ob = new BinaryMinHeapArray(10);
        Scanner sc = new Scanner(System.in);
        int ch=-1;
        do {
            System.out.println("Enter choice\n1-insert\n2-view\n3-get min\n4-exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    int v = sc.nextInt();
                    ob.insert(v);
                    break;

                case 2:
                    ob.print();
                    break;

                case 3:
                    System.out.println(ob.getmin());
            }
        }while(ch!=4);

    }
}
