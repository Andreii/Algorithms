package com.omtia.leetcode;

/**
 * https://leetcode.com/problems/word-search/
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
// WIP !!
public class _79_word_search {
    protected static final int[][] COORDS = {{1,0},{0,1},{-1,0},{0,-1}};

    protected boolean dfs(char[][]board, int i, int j, int index_word, String word, boolean[][] visited) {
        if(index_word > word.length() -1) return false;
        if(board[i][j] != word.charAt(index_word)) return false;

        if(index_word == word.length() - 1) return true;

        if(visited[i][j]) return false;

        for(int z = 0; z < COORDS.length; z++) {
            int new_i = Math.min(board.length-1, Math.max(0, i + COORDS[z][0]));
            int new_j = Math.min(board[i].length-1, Math.max(0, j + COORDS[z][1]));

            visited[new_i][new_j] = true;
            if(dfs(board, new_i, new_j, index_word + 1, word, visited)) return true;
            visited[new_i][new_j] = false;
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(dfs(board, i, j, 0,  word, new boolean[board.length][board[i].length])) return true;
            }
        }
        return false;
    }
}
