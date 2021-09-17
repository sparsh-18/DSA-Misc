import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}

public class MergeLists {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);

        Collections.sort(intervals, new mysort());

        LinkedList<Interval> a = new LinkedList<>();

        for (Interval e: intervals) {
            if (a.isEmpty() || e.start > a.peekLast().end) {
                a.addLast(e);
            } else {
                Interval in = new Interval(a.peekLast().start, Math.max(a.peekLast().end, e.end));
                a.removeLast();
                a.addLast(in);
            }
        }

        ArrayList<Interval> ar = new ArrayList<>(a);

        return ar;
    }

    public static void main(String[] args) {
        ArrayList<Interval> ar = new ArrayList<>();
        ar.add(new Interval(1,2));
        ar.add(new Interval(3,5));
        ar.add(new Interval(6,7));
        ar.add(new Interval(8,10));
        ar.add(new Interval(12,16));

        MergeLists ob = new MergeLists();

        ArrayList<Interval> b = ob.insert(ar, new Interval(4,9));

        for( Interval inn : b) {
            System.out.println(inn.start+" , "+inn.end);
        }
    }
}
class mysort implements Comparator<Interval> {
   @Override
    public int compare(Interval a, Interval b) {
        return a.start > b.start ? 1: -1 ;
    }
}