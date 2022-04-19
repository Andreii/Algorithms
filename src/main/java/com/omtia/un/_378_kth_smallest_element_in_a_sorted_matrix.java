package com.omtia.un;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest
 * element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * You must find a solution with a memory complexity better than O(n2).
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * Example 2:
 *
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
 * 1 <= k <= n2
 *
 *
 * Follow up:
 *
 * Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
 * Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may
 * find reading this paper fun.
 */
public class _378_kth_smallest_element_in_a_sorted_matrix {
    // TC: O(n^2 log k)
    // SC: O(k) if k=n^2 then O(n^2)
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        if(n == 1) return matrix[0][0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                k+1,
                (a,b) -> b-a
        );

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                pq.offer(matrix[i][j]);
                if(pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.poll();
    }

    static class QueueObject {
        private final int value, row, column;
        public QueueObject(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }

        public int getValue() {
            return value;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

    // x = Math.min(n,k)
    // TC: O(x + k log x)
    // SC: O(x)
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        if(n == 1) return matrix[0][0];

        PriorityQueue<QueueObject> pq = new PriorityQueue<>(
                Math.min(n,k), Comparator.comparingInt(QueueObject::getValue)
        );

        for(int row = 0; row < Math.min(n,k); row++) {
            pq.offer(new QueueObject(matrix[row][0], row, 0));
        }

        QueueObject curr = pq.peek();

        while( k-- > 0) {
            curr = pq.poll();

            int row = curr.getRow(), column = curr.getColumn();

            if(column < n-1) {
                pq.offer(new QueueObject(matrix[row][column + 1], row, column + 1));
            }
        }

        return curr.getValue();
    }
}
