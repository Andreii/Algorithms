package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WeightedSum {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/andrei/IdeaProjects/algo/general/src/algorithms/jobs.txt");

        Scanner scanner = new Scanner(file);

        Integer count = Integer.valueOf(scanner.nextLine());

        TreeMap<Integer, SortedSet<Integer>> job_dif = new TreeMap<>(Collections.reverseOrder());

        List<List<Integer>> job_diff = new ArrayList<>();

        while(scanner.hasNext()) {
            String[] props = scanner.nextLine().split(" ");
            Integer job_weight = Integer.parseInt(props[0]);
            Integer job_length = Integer.parseInt(props[1]);
            Integer diff = job_weight - job_length;

            if(job_dif.containsKey(diff)) {
                SortedSet<Integer> value = job_dif.get(diff);
                value.add(job_weight);
                job_dif.put(diff, value);
            } else {
                job_dif.put(diff, new TreeSet<>(Collections.reverseOrder()) {{ add( job_weight); }});
            }
        }

        Long result = 0L;

        for(Map.Entry<Integer, SortedSet<Integer>> entry : job_dif.entrySet()) {

            for(Integer v : entry.getValue()) {
                result += entry.getKey() * v;
            }
        }

        System.out.println("Result is: " + result);
    }
}
