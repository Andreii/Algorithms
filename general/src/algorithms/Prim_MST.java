package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prim_MST {
    public static void main(String[] args) {

        Scanner scanner = null;
        Integer edges, vertexes;

        ArrayList<ArrayList<Integer>> edgesList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("general/src/algorithms/edges.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File could not be opened!");
        }

        if(scanner != null && scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            vertexes = Integer.parseInt(line[0]);
            edges = Integer.parseInt(line[1]);
        }

        while(scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            edgesList.add(new ArrayList<>() {{
                add(Integer.parseInt(line[0]));
                add(Integer.parseInt(line[1]));
                add(Integer.parseInt(line[2]));
            }});
        }

        int index = 0;
        for( ArrayList<Integer> edge : edgesList) {
//            System.out.printf(" Edge %d - start %d - end %d - cost %d \n", index++, edge.get(0), edge.get(1), edge.get(2));
        }
    }
}
