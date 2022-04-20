/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
 *
 * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction,
 * then one square in an orthogonal direction.
 *
 *
 * Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer
 * exists.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 * Example 2:
 *
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 *
 *
 * Constraints:
 *
 * -300 <= x, y <= 300
 * 0 <= |x| + |y| <= 300
 */
public class _1197_minimum_knight_moves {
    class Vertex {
        int x, y;
        public Vertex (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    protected final int[][] MOVES = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};

    public int minKnightMoves(int x, int y) {
        LinkedList<Vertex> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        x = Math.abs(x);
        y = Math.abs(y);

        q.add(new Vertex(0,0));

        int steps = 0;
        while(q.size() > 0) {
            int n = q.size();

            for(int i = 0; i < n; i++) {
                Vertex v = q.pop();

                if(v.x == x && v.y == y) return steps;

                for(int[] move : MOVES) {
                    int nx = v.x + move[0];
                    int ny = v.y + move[1];
                    Vertex nv = new Vertex(nx, ny);
                    if(!visited.contains(nx + "," + ny) && nx >= -1 && ny >= -1) {
                        q.add(nv);
                        visited.add(nx + "," + ny);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
