package un;

import java.util.LinkedList;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from
 * the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
 * of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the
 * same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 *
 * Return the modified image after performing the flood fill.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels
 * connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * Example 2:
 *
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * Output: [[2,2,2],[2,2,2]]
 *
 *
 * Constraints:
 *
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], newColor < 216
 * 0 <= sr < m
 * 0 <= sc < n
 */
public class _733_flood_fill {
    class Tuple {
        int r,c = 0;
        public Tuple (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null) return new int[0][0];

        LinkedList<Tuple> q = new LinkedList<>();

        int[][] coords = {{0,1},{1,0},{0,-1},{-1,0}};

        int maxRow = image.length;
        int maxCol = image[0].length;

        boolean[][] visited = new boolean[maxRow][maxCol];

        q.add(new Tuple(sr,sc));
        while(!q.isEmpty()) {

            int n = q.size();

            for(int i = 0; i < n; i++) {
                Tuple curr = q.pop();

                int currVal = image[curr.r][curr.c];

                image[curr.r][curr.c] = newColor;

                for(int[] coord : coords) {
                    int newRow = curr.r + coord[0];
                    int newCol = curr.c + coord[1];

                    if(0 <= newRow && newRow <= maxRow - 1 &&
                            0 <= newCol && newCol <= maxCol - 1
                    ) {
                        int newVal = image[newRow][newCol];
                        if(newVal == currVal && !visited[newRow][newCol]) {
                            q.add(new Tuple(newRow,newCol));
                            visited[newRow][newCol] = true;
                        }
                    }
                }
            }
        }

        return image;
    }
}
