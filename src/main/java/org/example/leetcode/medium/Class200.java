package org.example.leetcode.medium;


/**
 * @author walker.dou
 */
public class Class200 {
    public int numIslands(char[][] grid) {
        int size = 0;
        final int width = grid[0].length;
        final int height = grid.length;
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (grid[x][y] == '1') {
                    size++;
                    grid[x][y] = '2';
                    handle(x - 1, y, grid, width, height);
                    handle(x, y - 1, grid, width, height);
                    handle(x + 1, y, grid, width, height);
                    handle(x, y + 1, grid, width, height);
                }
            }
        }
        return size;
    }

    private void handle(int x, int y, char[][] grid, int width, int height) {
        if (x < 0 || y < 0 || x >= height || y >= width) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
            handle(x - 1, y, grid, width, height);
            handle(x, y - 1, grid, width, height);
            handle(x + 1, y, grid, width, height);
            handle(x, y + 1, grid, width, height);
        }
    }
}
