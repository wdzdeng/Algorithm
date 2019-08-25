package github.com.wdzdeng.algorithm;

public class ReverseSentence {
    public static String reverse(String str) {
        String[] strings = str.split(" ");
        System.out.println(strings);
        int l = 0;
        int r = strings.length-1;
        while(1<r){
            String temp = strings[l];
            strings[l] = strings[r];
            strings[r] = temp;
            ++l;
            --r;
        }
        StringBuffer sb = new StringBuffer();
        for (String s: strings){
            sb.append(s+" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverse("I am a student"));
    }
}
