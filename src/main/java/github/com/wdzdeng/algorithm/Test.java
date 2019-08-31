package github.com.wdzdeng.algorithm;

public class Test {
    int[] numbers = new int[1024];
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("t1");
        thread.start();
    }
}
