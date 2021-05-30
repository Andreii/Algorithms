package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Kosaraju {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, List<Integer>> adjList = new HashMap<>(875_714);
        Scanner in = new Scanner(new File("/home/act/mds/projects/git/algo/general/src/algorithms/SCC.txt"));

        while(in.hasNext()) {
            String line = in.nextLine();
            int v = Integer.parseInt(line.split("\\s")[0]);
            int w = Integer.parseInt(line.split("\\s")[1]);
            List<Integer> wVertexes = adjList.get(v) == null ? new ArrayList<>() : adjList.get(v);
            wVertexes.add(w);
            adjList.put(v, wVertexes);
        }

        System.out.println(adjList.get(6).toString());
    }
}
