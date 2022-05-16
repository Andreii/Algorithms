/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _1091_Shortest_Path_in_Binary_MatrixTest {

    @Test
    void shortestPathBinaryMatrix_shouldWorkForBaseCase() {
        _1091_Shortest_Path_in_Binary_Matrix c = new _1091_Shortest_Path_in_Binary_Matrix();

        int result = c.shortestPathBinaryMatrix(new int[][] {{0,0,0},{1,1,0},{1,1,0}});

        assertThat(result).isEqualTo(4);
    }

    @Test
    void shortestPathBinaryMatrix_shouldFailForNoRoute() {
        _1091_Shortest_Path_in_Binary_Matrix c = new _1091_Shortest_Path_in_Binary_Matrix();

        int result = c.shortestPathBinaryMatrix(new int[][] {{1,0,0},{1,1,0},{1,1,0}});

        assertThat(result).isEqualTo(-1);
    }
}