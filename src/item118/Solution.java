package item118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            for (int j = 1; j < i; j++) {
                l.add(j, list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            if (i != 0) {
                l.add(1);
            }
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        Solution s = new Solution();
        list = s.generate(5);
        System.out.println(list);
    }
}
