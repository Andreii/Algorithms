package com.omtia.un;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So
 * it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class _207_Course_schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        HashMap<Integer,Integer> indegree = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
            indegree.put(i,0);
        }

        for(int[] prereq : prerequisites) {
            int u = prereq[0];
            int v = prereq[1];

            adj.get(u).add(v);
            indegree.put(v, indegree.get(v) + 1);
        }

        LinkedList<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            Integer u = q.pop();

            res.add(u);
            for(Integer v : adj.get(u)) {
                indegree.put(v, indegree.get(v) - 1);
                if(indegree.get(v) == 0)
                    q.add(v);
            }
        }

        return res.size() == numCourses;
    }
}
