package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class463 {

    public static void main(String[] args) {
        final Class463 class463 = new Class463();
        int[][] a = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        class463.islandPerimeter(a);
    }
    /**
     * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
     * 输出：16
     * 解释：它的周长是上面图片中的 16 个黄色的边
     */
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        final int row = grid.length;
        final int height = grid[0].length;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) {
                    count = count + 4;
                    if (x > 0) {
                        if (grid[x - 1][y] == 1) {
                            count--;
                        }
                    }
                    if (y > 0) {
                        if (grid[x][y - 1] == 1) {
                            count--;
                        }
                    }
                    if (x + 1 < row) {
                        if (grid[x + 1][y] == 1) {
                            count--;
                        }
                    }
                    if (y + 1 < height) {
                        if (grid[x][y + 1] == 1) {
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }
}
