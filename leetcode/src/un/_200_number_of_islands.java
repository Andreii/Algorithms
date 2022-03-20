package un;

import java.util.LinkedList;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of i
 * slands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may
 * assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class _200_number_of_islands {
    protected static final int[][] COORDS = {{0,1},{1,0},{-1,0},{0,-1}};

    protected void dfs(char[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') return;

        grid[x][y] = '0';
        for(int[] coord : COORDS)
            dfs(grid, x + coord[0], y + coord[1]);

    }

    static class Coord {
        int x,y;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Input: grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     */
    protected void bfs(char[][] grid, int x, int y) {
        LinkedList<Coord> q = new LinkedList<>();

        q.add(new Coord(x,y));
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                Coord curr = q.pop();
                if(curr.x < 0 || curr.y < 0 ||
                        curr.x >= grid.length || curr.y >= grid[0].length ||
                        grid[curr.x][curr.y] == '0') continue;

                grid[curr.x][curr.y] = '0';
                for(int[] coord : COORDS)
                    q.add(new Coord( curr.x + coord[0], curr.y + coord[1]));
            }
        }
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int x = 0; x < grid.length; x++)
            for(int y = 0; y < grid[0].length; y++) {
                if(grid[x][y] == '1') {
                    bfs(grid,x,y);
                    islands++;
                }
            }

        return islands;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','1'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};

        _200_number_of_islands e = new _200_number_of_islands();

        System.out.println(e.numIslands(grid));
    }
}
