package github.com.wdzdeng.algorithm;
public class Main3 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4,5,6};
        System.out.println(sumMin(nums));
    }
    private static int sumMin(int[] nums){
        int[] accumulate = new int[nums.length];//空间换时间，用O(1)时间复杂度求和
        accumulate[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            accumulate[i] = nums[i] + accumulate[i-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< nums.length-1; ++i){
            int max = Integer.MIN_VALUE;
            int lSum = getSum(accumulate, 0, i);
            max = Math.max(max, lSum);
            for(int j = i+1; j < nums.length-1; ++j){
                int midSum = getSum(accumulate, i+1,j);
                int rSum = getSum(accumulate, j+1, nums.length-1);
                max = Math.max(Math.max(midSum, rSum),max);
            }
            min = Math.min(min, max);

        }
        return min;
    }
    private static int getSum(int[] accumulate, int left, int right){
        return left == 0 ? accumulate[right] : accumulate[right] - accumulate[left-1];
    }
}