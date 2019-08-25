package github.com.wdzdeng.algorithm;

import java.util.Arrays;

public class IsContinuous {
    public boolean continuous(int [] numbers) {
        Arrays.sort(numbers);
        int zeros = 0;
        int gap = 0;
        for(int i = 0; i<numbers.length; ++i){
            if (numbers[i] == 0){
                zeros++;
            }else {
                if (i <= numbers.length-2){
                    if (numbers[i] == numbers[i+1]) return false;
                    gap += numbers[i+1] - numbers[i]-1;
                    if (gap>zeros) return false;
                }
            }
        }
        return true;
    }
}
