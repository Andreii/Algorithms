package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WeightedSum {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/andrei/IdeaProjects/algo/general/src/algorithms/jobs_small.txt");

        Scanner scanner = new Scanner(file);

        TreeMap<Integer, SortedSet<List<Integer>>> job_dif = new TreeMap<>(Collections.reverseOrder());

        Integer count = Integer.valueOf(scanner.nextLine());

        while(scanner.hasNext()) {
            String[] props = scanner.nextLine().split(" ");
            Integer job_weight = Integer.parseInt(props[0]);
            Integer job_length = Integer.parseInt(props[1]);
            Integer diff = job_weight - job_length;

            if(job_dif.containsKey(diff)) {
                SortedSet<List<Integer>> value = job_dif.get(diff);
                value.add( new ArrayList<>() {{ add(job_weight); add(job_length); }});
            } else {
                job_dif.put(diff, new TreeSet<>(new Comparator<List<Integer>>() {
                    @Override
                    public int compare(List<Integer> o1, List<Integer> o2) {
                        return o2.get(0) - o1.get(0);
                    }
                }) {{
                    add( new ArrayList<>() {{ add(job_weight); add(job_length); }} );
                }});
            }
        }

        Long result = 0L;
        Long time = 0L;

        for(Map.Entry<Integer, SortedSet<List<Integer>>> entry : job_dif.entrySet()) {
            System.out.print(entry.getKey());
            for(List<Integer> v : entry.getValue()) {
                System.out.print(v);
                time += v.get(1);
                result += v.get(0) * time;
            }
            System.out.println();
        }

        System.out.println("Result is: " + result);
    }
}
