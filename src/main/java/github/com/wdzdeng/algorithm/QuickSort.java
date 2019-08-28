package github.com.wdzdeng.algorithm;

public class QuickSort {
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
}
