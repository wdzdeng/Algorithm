package github.com.wdzdeng.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Backtrack_1 {
    public List<List<Integer>> liKou39(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> list1 = new LinkedList<>();
        List<List<Integer>> list2 = new LinkedList<>();
        for (int k = 0; k < candidates.length; ++k){
            backtrack(candidates, k, target, list1, list2);
        }

        return list2;
    }
    public static void backtrack(int[] candidates,int index, int current, LinkedList<Integer> list1,List<List<Integer>> list2){
        if (index == candidates.length) return;
        current -= candidates[index];
        if (current < 0) return;
        list1.add(candidates[index]);
        if (current == 0) list2.add(new LinkedList<>(list1));
        else {
            for (int j = index; j<candidates.length; ++j){
                backtrack(candidates, j, current, list1, list2);
            }
        }
        list1.removeLast();
    }
}
