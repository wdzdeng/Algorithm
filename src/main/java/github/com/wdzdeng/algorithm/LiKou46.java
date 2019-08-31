package github.com.wdzdeng.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LiKou46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length == 0)  return lists;
        recursive(nums,0,lists);
        return lists;
    }
    public static void recursive(int[] nums, int index,List<List<Integer>> lists){
        if (index == nums.length){
            ArrayList<Integer> list = new ArrayList<>();
           for (int i = 0; i<nums.length; ++i){
               list.add(nums[i]);
           }
           lists.add(list);
           return;
        }
        for (int j = index; j<nums.length; ++j){
            swap(nums, index, j);
            recursive(nums, index+1, lists);
            swap(nums, index, j);
        }

    }
    public static void swap(int[] nums, int left, int right){
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

}
