package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WeightedSum {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/andrei/IdeaProjects/algo/general/src/algorithms/jobs.txt");

        Scanner scanner = new Scanner(file);

        TreeMap<Integer, ArrayList<ArrayList<Integer>>> job_dif = new TreeMap<>(Collections.reverseOrder());

        Integer count = Integer.valueOf(scanner.nextLine());

        while(scanner.hasNext()) {
            String[] props = scanner.nextLine().split(" ");
            Integer job_weight = Integer.parseInt(props[0]);
            Integer job_length = Integer.parseInt(props[1]);
            Integer diff = job_weight - job_length;

            if(job_dif.containsKey(diff)) {
                ArrayList<ArrayList<Integer>> value = job_dif.get(diff);
                value.add( new ArrayList<>() {{ add(job_weight); add(job_length); }});
            } else {
                job_dif.put(diff, new ArrayList<>() {{
                    add( new ArrayList<>() {{ add(job_weight); add(job_length); }} );
                }});
            }
        }

        Long result = 0L;
        Long time = 0L;
        int result_count = 0;

        for(Map.Entry<Integer, ArrayList<ArrayList<Integer>>> entry : job_dif.entrySet()) {
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
