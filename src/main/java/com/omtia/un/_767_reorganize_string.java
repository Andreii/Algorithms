/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _767_reorganize_string {
    public String reorganizeString(String s) {
        Map<Character, Integer> occur = new HashMap<>();
        // a: 2
        // b: 1
        for(char c : s.toCharArray()) {
            occur.put(c, occur.getOrDefault(c, 0) + 1);
        }

        if(occur.size() == 1) return "";

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<Character, Integer> entry : occur.entrySet()) {
            pq.offer(entry);
        }

        // pq -> b:1
        // res "ab"
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> first = pq.poll(); // a:1

            if(res.length() == 0 || first.getKey() != res.charAt(res.length() - 1)) {
                res.append(first.getKey());

                first.setValue(first.getValue() - 1);

                if(first.getValue() != 0) {
                    pq.offer(first);
                }
            } else {
                Map.Entry<Character, Integer> second = pq.poll(); //b:1

                if(second == null) return "";

                res.append(second.getKey());

                second.setValue(second.getValue() -1);

                if(second.getValue() != 0) {
                    pq.offer(second);
                }

                pq.offer(first);
            }
        }

        return res.toString();
    }
}
