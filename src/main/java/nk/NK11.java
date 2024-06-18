package nk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static nk.NK.print;

public class NK11 {

    public List<int[]> mergeRange(List<int[]> arrays) {
        if (arrays.size() == 0) {
            return new ArrayList<>();
        }
        if (arrays.size() == 1) {
            return new ArrayList<>(arrays);
        }
        arrays.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> ls = new ArrayList<>();
        int[] last = arrays.get(0);
        ls.add(last);
        for (int i = 1; i < arrays.size(); i++) {
            int[] ints = arrays.get(i);
            if (ints[0] >= last[0] && ints[0] <= last[1]) {
                if (ints[1] > last[1]) {
                    last[1] = ints[1];
                }
            } else {
                last = ints;
                ls.add(last);
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        // 4,4,2,5,2,3;; 3
        // 1,1,4,3,2,;;2

        NK11 nk11 = new NK11();
        List<int[]> ls = new ArrayList<>();
        ls.add(new int[]{10, 30});
        ls.add(new int[]{20, 60});
        ls.add(new int[]{80, 100});
        ls.add(new int[]{150, 180});

        List<int[]> ints = nk11.mergeRange(ls);
        print(ints);
    }
}
