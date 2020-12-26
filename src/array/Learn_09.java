package array;

import java.util.HashMap;

/**
 * @Author xiaobai
 * @Date 2020/12/17 20:16
 * @Version 1.0
 */
public class Learn_09 {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}

        };
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {

        HashMap<Character, Integer> horizontal = new HashMap<>();
        HashMap<Character, Integer> vertical = new HashMap<>();
        HashMap<Character, Integer> grid = new HashMap<>();
        boolean flag = true;
        //扫描行
        for (int i = 0; i < 9 && flag; i++) {
            flag = scanning(board, i, i + 1, 0, 9);
        }
        //扫描列
        for (int i = 0; i < 9 && flag; i++) {
            flag = scanning(board, 0, 9, i, i + 1);
        }
        //扫描格子
        for (int i = 0; i < 9 && flag; i += 3) {
            for (int j = 0; j < 9 && flag; j += 3) {
                flag = scanning(board, i, i + 3, j, j + 3);
            }
        }
        return flag;
    }

    public static boolean scanning(char[][] board, int x1, int x2, int y1, int y2){
        HashMap<Character, Integer> map = new HashMap<>();
        char item = '#';
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                item = board[i][j];
                if (!map.containsKey(item)){
                    map.put(item, 0);
                }else{
                    if (item == '.'){
                        continue;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
