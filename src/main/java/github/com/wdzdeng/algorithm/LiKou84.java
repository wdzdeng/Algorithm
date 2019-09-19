package github.com.wdzdeng.algorithm;

public class LiKou84 {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; ++i){
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; ++j){
                minHeight = Math.min(minHeight, heights[j]);
                max = Math.max(max, minHeight*(j-i+1));
            }
        }
        return max;

    }
    public static int largestRectangleArea2(int[] heights) {
        return recursive(0, heights.length-1, heights);

    }
    public static int recursive(int left, int right, int[] h){
        if (left > right) return -1;
        if (left == right) return h[left];
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; ++i){
            if (min > h[i]){
                min = h[i];
                minIndex = i;
            }
        }
        int v1 = min*(right - left+1);
        int v2 = recursive(left, minIndex-1, h);
        int v3 = recursive(minIndex+1, right, h);
        return Math.max(v1, Math.max(v2, v3));
    }



    public static void main(String[] args) {
        int[] h = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(h));
    }
}
