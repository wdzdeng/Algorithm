package github.com.wdzdeng.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LiKou78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<Integer> current = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i){
            current.addLast(nums[i]);
            recursive(nums, i+1, lists, current);
            current.removeLast();
        }
        lists.add(new ArrayList<>());
        return lists;
    }
    private static void recursive(int[] nums, int index, List<List<Integer>> lists, LinkedList<Integer> current){
        List<Integer> list = new ArrayList<>(current);
        lists.add(list);
        if (index == nums.length) return;
        for(int i = index; i < nums.length; ++i){
            current.addLast(nums[i]);
            recursive(nums, i+1, lists, current);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets(nums);
    }
}
