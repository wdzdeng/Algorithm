package github.com.wdzdeng.algorithm;

import java.util.HashSet;

public class InversePairs {
    public static int pairs(int[] array){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < array.length; ++i){
            if (set.contains(array[i])) continue;
            set.add(array[i]);
            HashSet<Integer> current = new HashSet<>();
            for (int j = i+1; j<array.length; ++j){
                if (current.contains(array[j])) continue;
                current.add(array[j]);
                if (array[j] < array[i]) ++count;
            }
        }
        return count%1000000007;
    }
}
