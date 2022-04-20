/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _973_k_closest_points_to_origin {
    // TC: O(n log n) -> could go to O(n log k) if we reduce PQ to support k elements
    // SC: O(n) can make it to k if we limit PQ size
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        for(int i = 0; i < n; i ++) {
            int[] point = points[i];
            pq.add(new Point(point, getDistance(point[0], point[1])));
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll().point;
        }

        return res;
    }

    public int getDistance(int x, int y) {
        return x*x + y*y;
    }

    public class Point {
        int[] point;
        int dist;

        public Point(int[] point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }
}
