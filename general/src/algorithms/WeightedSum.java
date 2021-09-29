package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class WeightedSum {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/andrei/IdeaProjects/algo/general/src/algorithms/jobs.txt");

        Scanner scanner = new Scanner(file);

        String count = scanner.nextLine();

        TreeMap<Integer, Integer> job_dif = new TreeMap<>();
        List<List<Integer>> job_diff = new ArrayList<>();

        while(scanner.hasNext()) {
            String[] props = scanner.nextLine().split(" ");
            Integer job_weight = Integer.parseInt(props[0]);
            Integer job_length = Integer.parseInt(props[1]);

            job_dif.put(job_weight - job_length, job_weight);

            System.out.println();
        }
    }
}
