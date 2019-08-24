package github.com.wdzdeng.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumber {
    public static String printMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int i: numbers){
            list.add(Integer.toString(i));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuffer sb = new StringBuffer();
        list.forEach(it -> sb.append(it));
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] strs = new int[]{3,32,321};
        System.out.println(printMinNumber(strs));
    }
}
