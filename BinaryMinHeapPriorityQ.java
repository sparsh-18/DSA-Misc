import java.util.PriorityQueue;
import java.util.Scanner;

public class BinaryMinHeapPriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);

        int ch=-1;
        do {
            System.out.println("Enter choice\n1-insert\n2-view\n3-get min\n4-exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    int v = sc.nextInt();
                    pq.add(v);
                    break;

                case 2:
                    for(Integer i: pq) {
                        System.out.print(i+" ");
                    }
                    break;

                case 3:
                    System.out.println(pq.peek());
                    pq.poll();
                    break;
            }
        }while(ch!=4);
    }
}
