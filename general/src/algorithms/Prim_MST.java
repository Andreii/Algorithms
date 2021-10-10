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
        Integer edges, vertexes;

        ArrayList<ArrayList<Integer>> edgesList = new ArrayList<>();
        Map<Integer, List<Integer>> adj_list = new HashMap<>();
        Map<String, Integer> costs = new HashMap<>();
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
            costs.put(line[0] + "_" + line[1], Integer.parseInt(line[2]));
            edgesList.add(new ArrayList<>() {{
                add(Integer.parseInt(line[0]));
                add(Integer.parseInt(line[1]));
                add(Integer.parseInt(line[2]));
            }});
            Integer start = Integer.parseInt(line[0]);
            Integer end = Integer.parseInt(line[1]);

            if(adj_list.containsKey(start)) {
                List<Integer> list = adj_list.get(start);
                list.add(end);
            } else {
                adj_list.put(start, new ArrayList<>() {{ add(end);}});
            }
        }

        List<Integer> X = new ArrayList<>() {{ add(adj_list.keySet().stream().findFirst().get()); }};
        List<List<Integer>> T = new ArrayList<>();
        boolean[] visited = new boolean[adj_list.size()];

        Arrays.fill(visited, false);

        PriorityQueue<Vertex> tree = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.cost - o2.cost;
            }
        });

        int mst_cost = 0;
        tree.add(new Vertex(adj_list.keySet().stream().findFirst().get(), 0));

        while( ! /*NOT*/ tree.isEmpty()) {
            Vertex current_vertex = tree.peek();
            tree.remove();

            if(! /*NOT*/ visited[current_vertex.node]) {
                mst_cost += current_vertex.cost;
                visited[current_vertex.node] = true;
                for(Integer v_node : adj_list.get(current_vertex.node)) {
                    if(! /*NOT*/ visited[v_node]) {
                        visited[v_node] = true;
                        tree.add(new Vertex(v_node, costs.get(current_vertex.node + "_" + v_node)));
                    }
                }
            }
        }

        int index = 0;
        for( ArrayList<Integer> edge : edgesList) {
            System.out.printf(" Edge %d - start %d - end %d - cost %d \n", index++, edge.get(0), edge.get(1), edge.get(2));
        }

        for( Map.Entry<Integer, List<Integer>> entry : adj_list.entrySet()) {
            System.out.printf(" start %d -> %s \n", entry.getKey(), entry.getValue().toString());
        }

        System.out.println("Total cost is: " + mst_cost);
    }
}
