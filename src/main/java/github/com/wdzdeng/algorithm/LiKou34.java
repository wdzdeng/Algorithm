package github.com.wdzdeng.algorithm;

public class LiKou34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int left = -1;
        int right = -1;
        int l = 0;
        int r = nums.length -1;
        while (l <= r){
            int mid = (l + r)/2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                int l2 = 0;
                int r2 = mid -1;
                while (l2 <= r2){
                    int mid2 = (l2 + r2)/2;
                    if (nums[mid2] == target) {
                        left = mid2;
                        r2 = mid2 - 1;
                    }else {
                        l2 = mid2 + 1;
                    }
                }
                int l3 = mid + 1;
                int r3 = nums.length -1;
                while (l3 <= r3){
                    int mid3 = (l3 + r3)/2;
                    if (nums[mid3] == target) {
                        right = mid3;
                        l3 = mid3 + 1;
                    }else {
                        r3 = mid3 - 1;
                    }
                }
                break;
            }
            if (nums[mid] < target) l = mid + 1;
            else r = mid-1;
        }
        return new int[]{left,right};
    }
}
