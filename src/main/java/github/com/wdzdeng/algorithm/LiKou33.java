package github.com.wdzdeng.algorithm;

public class LiKou33 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length<1) return -1;
        int rotateIndex = searchRotate(nums, 0, nums.length-1);
        if (target == nums[rotateIndex]) return rotateIndex;
        int l = 0;
        int r = nums.length-1;
        if (target <= nums[r]){
            l = rotateIndex+1;
            while (l <= r){
                int mid = (l+r)/2;
                if(nums[mid] == target) return mid;
                if (nums[mid]>target) r = mid-1;
                else l = mid+1;
            }
        }
        else {
            r = rotateIndex -1;
            while (l <= r){
                int mid = (l+r)/2;
                if(nums[mid] == target) return mid;
                if (nums[mid]>target) r = mid-1;
                else l = mid+1;
            }
        }
        return -1;
    }
    public static int searchRotate(int[] nums, int left, int right){
        if (nums[right] > nums[left]) return 0;
        left = 1;
        while (right >= left){
            int mid = (right+right)/2;
            if (nums[mid-1]>nums[mid]) return mid;
            if (nums[left] > nums[mid] ) right = mid-1;
            else left = mid+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,1};
        System.out.println(search(a, 1));
    }

}
