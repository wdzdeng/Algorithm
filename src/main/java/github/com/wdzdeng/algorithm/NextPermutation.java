package github.com.wdzdeng.algorithm;

import java.util.Arrays;

public class NextPermutation {
    /**
     * 这是自己的代码
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int index = -1;
        for (int i = nums.length-2; i >= 0 ; --i){
            int currentMax = Integer.MAX_VALUE;
            for (int j = i+1 ; j < nums.length; ++j){
                if (nums[j] > nums[i] && nums[j]<=currentMax){
                    currentMax = nums[j];
                    index = j;
                }
            }
            if (index != -1){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                quickSort(nums,i+1,nums.length-1);
                return;
            }
        }
        if(index == -1) Arrays.sort(nums);
    }
    public static void quickSort(int[] nums, int left, int right){
        if (left>=right) return;
        int l = left;
        int r = right;
        int temp = nums[left];
        while (l<r){
            while (l<r && nums[r]>=temp) --r;
            nums[l] = nums[r];

            while (l<r && nums[l]<=temp) ++l;
            nums[r] = nums[l];
        }
        nums[l] = temp;
        quickSort(nums,left,l-1);
        quickSort(nums, l+1, right);
    }

    /**
     * 这是别人的代码
     * @param nums
     */
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static  void  main(String[] arg){
//        int[] a = new int[]{1,2,3};
//        nextPermutation(a);
//        for (int i: a){
//            System.out.println(i);
//        }
        int[] nums = new int[]{7,4,3,2};
        quickSort(nums,0, nums.length-1);
        for (int i: nums){
            System.out.println(i);
        }
    }
}
