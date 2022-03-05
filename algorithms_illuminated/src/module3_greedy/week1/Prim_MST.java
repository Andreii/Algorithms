package module3_greedy.week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Prim_MST {

    static class Vertex {
        int node;
        int cost;
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
            scanner = new Scanner(new File("algorithms_illuminated/resources/edges.txt"));
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

        boolean[] visited = new boolean[adj_list.size() + 5];
        Arrays.fill(visited, false);

        PriorityQueue<Vertex> tree = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex v1, Vertex v2) {
                return v1.cost - v2.cost;
            }
        }) {{
            add(new Vertex(adj_list.keySet().stream().findFirst().get(), 0));
        }};

        int mst_cost = 0;

        while( ! /*NOT*/ tree.isEmpty()) {
            Vertex v = tree.remove();

            if( !/*NOT*/ visited[v.node]) {
                visited[v.node] = true;
                mst_cost += v.cost;
                for(Integer adjacent : adj_list.get(v.node)) {
                    if( !/*NOT*/ visited[adjacent] ) {
                        tree.add(new Vertex(adjacent, costs.get(v.node + "_" + adjacent)));
                    }
                }
            }
        }

        System.out.println("Total cost is: " + mst_cost);
    }
}
