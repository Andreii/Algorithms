/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.module3_greedy.week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This file describes a set of jobs with positive and integral weights and lengths.  It has the format
 *
 * [number_of_jobs]
 *
 * [job_1_weight] [job_1_length]
 *
 * [job_2_weight] [job_2_length]
 *
 * ...
 *
 * For example, the third line of the file is "74 59", indicating that the second job has weight 74 and length 59.
 *
 * You should NOT assume that edge weights or lengths are distinct.
 *
 * Your task in this problem is to run the greedy algorithm that schedules jobs in decreasing order of the difference
 * (weight - length).  Recall from lecture that this algorithm is not always optimal.  IMPORTANT: if two jobs have equal
 * difference (weight - length), you should schedule the job with higher weight first.  Beware: if you break ties in a
 * different way, you are likely to get the wrong answer.  You should report the sum of weighted completion times of
 * the resulting schedule --- a positive integer --- in the box below.
 *
 * ADVICE: If you get the wrong answer, try out some small test cases to debug your algorithm (and post your test cases
 * to the discussion forum).
 */
public class WeightedSum {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("algorithms_illuminated/resources/jobs.txt");

        Scanner scanner = new Scanner(file);

        TreeMap<Float, ArrayList<ArrayList<Integer>>> job_dif = new TreeMap<>(Collections.reverseOrder());

        int count = Integer.parseInt(scanner.nextLine());

        while(scanner.hasNext()) {
            String[] props = scanner.nextLine().split(" ");
            int job_weight = Integer.parseInt(props[0]);
            int job_length = Integer.parseInt(props[1]);
            Float diff = (float) job_weight / job_length;

            if(job_dif.containsKey(diff)) {
                ArrayList<ArrayList<Integer>> value = job_dif.get(diff);
                value.add( new ArrayList<>() {{ add(job_weight); add(job_length); }});
            } else {
                job_dif.put(diff, new ArrayList<>() {{
                    add( new ArrayList<>() {{ add(job_weight); add(job_length); }} );
                }});
            }
        }

        long result = 0L;
        long time = 0L;
        int result_count = 0;

        for(Map.Entry<Float, ArrayList<ArrayList<Integer>>> entry : job_dif.entrySet()) {
            System.out.print(entry.getKey());
            ArrayList<ArrayList<Integer>> list_to_process = entry.getValue();
            list_to_process.sort(new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o2.get(0) - o1.get(0);
                }
            });
            for(List<Integer> v : entry.getValue()) {
                System.out.print(v);
                time += v.get(1);
                result += v.get(0) * time;
                result_count++;
            }
            System.out.println();
        }

        System.out.println("Result is: " + result);
        System.out.println("Result count is: " + result_count);
        System.out.println("Desired count is: " + count);
    }
}
