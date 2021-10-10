package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Prim_MST {

    static class Vertex {
        int node;
        int cost;
        boolean visited = false;
        Vertex(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = null;
        Map<Integer, List<Integer>> adj_list = new HashMap<>();
        Map<String, Integer> costs = new HashMap<>();

        try {
            scanner = new Scanner(new File("general/src/algorithms/edges.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File could not be opened!");
        }

        if(scanner != null && scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
        }

        while(scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            costs.put(line[0] + "_" + line[1], Integer.parseInt(line[2]));
            costs.put(line[1] + "_" + line[0], Integer.parseInt(line[2]));

            Integer start = Integer.parseInt(line[0]);
            Integer end = Integer.parseInt(line[1]);

            if(adj_list.containsKey(start)) {
                List<Integer> list = adj_list.get(start);
                list.add(end);
            } else {
                adj_list.put(start, new ArrayList<>() {{ add(end);}});
            }

            if(adj_list.containsKey(end)) {
                List<Integer> list = adj_list.get(end);
                list.add(start);
            } else {
                adj_list.put(end, new ArrayList<>() {{ add(start);}});
            }
        }

        boolean[] visited = new boolean[adj_list.size() + 2];

        Arrays.fill(visited, false);

        PriorityQueue<Vertex> tree = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.cost - o2.cost;
            }
        });

        int mst_cost = 0;
        tree.add(new Vertex(adj_list.keySet().stream().findFirst().get(), 0));

        while( ! /*NOT*/ tree.isEmpty()) { //  1_4
            Vertex current_vertex = tree.remove();

            if(! /*NOT*/ visited[current_vertex.node]) {
                mst_cost += current_vertex.cost; // 0 4
                visited[current_vertex.node] = true; // v[1] v[2]
                if (adj_list.get(current_vertex.node) == null) continue;
                for(Integer v_node : adj_list.get(current_vertex.node)) { //
                    if(! /*NOT*/ visited[v_node]) {
//                        System.out.println("got  cost " + current_vertex.node + " - " + v_node + " -> " + costs.get(current_vertex.node + "_" + v_node) + " cost_mst: " + mst_cost  );
                        tree.add(new Vertex(v_node, costs.get(current_vertex.node + "_" + v_node)));
                    }
                }
            }
        }

        System.out.println("Total cost is: " + mst_cost);
    }
}
