package github.com.wdzdeng.algorithm;

import java.util.ArrayList;

public class JianZhi_PrintMatrix {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int len = matrix.length;
        ArrayList<Integer> list = new ArrayList<>();
        if (len == 0) return list;
        if (len == 1) {
            list.add(matrix[0][0]);
            return list;
        }
        int step = (int) Math.ceil(len /2);
        int[][] r = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int j = 0; j <step; ++j){
            int[] start = {j,j};
            for (int i = 0; i< 4; ++i){
                for (int k = 1; k<len; ++k){
                    list.add(matrix[start[0]][start[1]]);
                    start[0] += r[j][0];
                    start[1] += r[j][1];
                    if (start[0] == j && start[1] == j ) break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        printMatrix(nums);
    }
}
