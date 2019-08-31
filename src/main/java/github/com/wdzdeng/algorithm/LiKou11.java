package github.com.wdzdeng.algorithm;

public class LiKou11 {
    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) return -1;
        int l = 0;
        int r = height.length -1;
        int max = 0;
        while (l < r){
            max = Math.max(max, Math.min(height[l], height[r])*(r - l));
            if (height[l] > height[r]) r --;
            else l++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
