package github.com.wdzdeng.algorithm;

public class CanFinish {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] p = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; ++i){
            int last = prerequisites[i][0];
            int first = prerequisites[i][1];
            p[last][first] = 1;
        }
        return true;
    }

}
