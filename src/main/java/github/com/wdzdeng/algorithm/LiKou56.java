package github.com.wdzdeng.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LiKou56 {
    //垃圾代码
    public static int[][] merge1(int[][] intervals) {
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(intervals, (o1,o2)->(o1[1]-o2[1]));
        for (int[] temp: intervals){
            if (list.size() == 0){
                for (int i = temp[0]; i<=temp[1]; ++i){
                    list.add(i);
                }
            }else {
                if (temp[0] < list.getLast() && temp[0] >= list.getFirst()){
                    if (temp[1]<= list.getLast()) continue;
                    for (int i = list.getLast()+1; i<=temp[1]; ++i){
                        list.add(i);
                    }
                    continue;
                }
                if (temp[0]< list.getFirst()){
                    for (int j = list.getFirst()-1; j >= temp[0]; --j){
                        list.addFirst(j);
                    }
                    if (temp[1] > list.getLast()){
                        for (int j = list.getLast()+1 ; j<=temp[1]; ++j){
                            list.add(j);
                        }
                    }
                }else {
                    for (int j = temp[0]; j<= temp[1]; ++j){
                        list.addLast(j);
                    }
                }
            }
        }
        List<int[]> list1 = new ArrayList<>();
        boolean target = true;
        int left = 0;
        int right = 0;
        for (int num: list){
            if (target){
                left = num;
                right = num;
                target = false;
            }else {
                if (num == right+1){
                    right++;
                }else {
                    int[] temp = {left, right};
                    list1.add(temp);
                    left = num;
                    right = num;
                }
            }
        }
        if (left != right){
            int[] temp = {left, right};
            list1.add(temp);
        }

        int[][] merged = new int[list1.size()][2];
        for (int i = 0; i<list1.size(); ++i){
            merged[i] = list1.get(i);
        }
        return merged;
    }
    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals,(o1,o2)->(o1[0]-o2[0]));
        LinkedList<int[]> list = new LinkedList<>();
        int len = intervals.length;
        if (len == 0) return null;
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        for (int i = 1; i<len; ++i){
            int[] a = list.getLast();
            if (intervals[i][0] <= a[1]){
                int[] temp = list.removeLast();
                temp[1] = Math.max(temp[1], intervals[i][1]);
                list.add(temp);
            }else {
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        int[][] merged = new int[list.size()][2];
        for (int i = 0; i<list.size(); ++i){
            merged[i] = list.get(i);
        }
        return merged;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = merge(nums);
        System.out.println(merged.length);
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }

}
