package github.com.wdzdeng.algorithm;

public class LiKou79 {
    static final int[][] step = {{0,1}, {0,-1},{1,0}, {-1,0}};
    public static boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] target = new boolean[x][y];
        for (int i = 0; i < x; ++i){
            for (int j = 0; j < y; ++j){
               if (backtrack(i,j, x, y, board, word, 0, target)) return true;
            }
        }
        return false;
    }
    private static boolean backtrack(int row, int col, int x, int y, char[][] board, String word,int index, boolean[][] b){
        if (word.length() <= index) return true;
        System.out.println(row + " " +col);
        if (row <0 || col < 0 ||row >= x || col >= y || b[row][col] || word.charAt(index) != board[row][col] ) return false;
        b[row][col] = true;
        for(int[] next : step){
            if (backtrack(row+next[0], col+next[1], x, y, board, word, index+1, b)) return true;
        }
        b[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = {{'a'}};
        String word = "ab";
        System.out.println(exist(chars, word));


    }

}
