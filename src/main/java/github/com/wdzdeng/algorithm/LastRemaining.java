package github.com.wdzdeng.algorithm;

import java.util.LinkedList;

public class LastRemaining {
    public static int LastRemaining_Solution(int n, int m) {
        if(n<1 || m< 1|| m>n) return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; ++i){
            list.add(i);
        }
        int start = 0;
        while (list.size()> 1){
            start = (start+m-1)%list.size();
            list.remove(start);
        }
        return list.get(0);

    }

    public static void main(String[] args) {
        LastRemaining_Solution(10,5);
    }
}
