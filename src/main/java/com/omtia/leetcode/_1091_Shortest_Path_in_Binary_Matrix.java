/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import java.util.LinkedList;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear
 * path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e.,
 * (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge
 * or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * Example 3:
 *
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 *
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 */
public class _1091_Shortest_Path_in_Binary_Matrix {
    class Point {
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // TC: O(n)
    // SC: O(n)
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if(grid[0][0] == 1 || grid[ROW-1][COL-1] == 1) return -1;

        LinkedList<Point> q = new LinkedList<>();

        q.offer(new Point(0,0));

        boolean[][] visited = new boolean[ROW][COL];

        visited[0][0] = true;

        int[] new_row = {0, 1,-1, 0,  1, -1, 1, -1};
        int[] new_col = {1, 0, 0,-1,  1, 1, -1, -1};

        int res = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Point curr = q.poll();

                if(curr.x == ROW-1 && curr.y == COL-1) return res+1;

                for(int j = 0; j < 8; j++) {
                    int new_x = new_row[j] + curr.x;
                    int new_y = new_col[j] + curr.y;

                    if(new_x < ROW && new_x >= 0 &&
                            new_y < COL && new_y >= 0 && grid[new_x][new_y] != 1 && !visited[new_x][new_y]) {
                        visited[new_x][new_y] = true;
                        q.offer(new Point(new_x,new_y));
                    }
                }
            }

            res++;
        }

        return -1;
    }
}
