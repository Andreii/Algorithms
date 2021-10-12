package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Dijkstra {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("general/resources/dijkstra.txt"));
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<String,Integer> lenvw = new HashMap<>();

        while(in.hasNext()) {
            String[] touples = in.nextLine().split("\t");

            int v = Integer.parseInt(touples[0]);
            for(int i = 1; i < touples.length; i++) {
                String[] toupleArr = touples[i].split(",");
                int w = Integer.parseInt(toupleArr[0]);
                int vwLen = Integer.parseInt(toupleArr[1]);

                // build adjancent list
                List<Integer> wElements;
                if(adjList.containsKey(v)) {
                    wElements = adjList.get(v);
                    wElements.add(w);
                } else {
                    wElements = new ArrayList<>() {{ add(w); }};
                }
                adjList.put(v, wElements);


                // build length list
                lenvw.put(
                        Arrays.stream(new int[] {v, w})
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining(",")),
                        vwLen
                );
            }
        }

//        for(Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
//            System.out.println(entry.getKey());
//        }

        for(Map.Entry<String, Integer> entry : lenvw.entrySet()) {
            System.out.printf("%s - %d \n", entry.getKey(), entry.getValue());
        }

        Map<Integer, Integer> shortestPath = dijkstra(adjList, lenvw, 1);

        for(Map.Entry<Integer, Integer> entry : shortestPath.entrySet()) {
            System.out.printf("%d - %d \n", entry.getKey(), entry.getValue());
        }

        int[] wantedLengths = new int[] {7,37,59,82,99,115,133,165,188,197};
        System.out.printf("Length array: %s", Arrays.stream(wantedLengths)
                .map(shortestPath::get)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));

    }

    private static Map<Integer,Integer> dijkstra(Map<Integer, List<Integer>> adjList, Map<String, Integer> lenvw, int start) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer,Integer> len = new HashMap<>();
        visited.add(start);
        len.put(start, 0);

        dfs_dijkstra(adjList,lenvw,len,visited);

        return len;
    }

    private static void dfs_dijkstra(
            Map<Integer, List<Integer>> adjList,
            Map<String, Integer> lenvw,
            Map<Integer,Integer> len,
            Set<Integer> visited
    ) {
        int[] vw = getShortestEdge(adjList, lenvw, len, visited);
        int v = vw[0];
        int w = vw[1];

        if(w != -1) {
            visited.add(w);
            len.put(w, len.get(v) + getVWLength(v, w, lenvw));
            dfs_dijkstra(adjList, lenvw, len, visited);
        }
    }

    private static int getVWLength(int v, int w, Map<String, Integer> lenvw) {
        return lenvw.getOrDefault(
                Arrays.stream(new int[] {v,w})
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(",")), Integer.MAX_VALUE
        );
    }

    private static int[] getShortestEdge (
            Map<Integer, List<Integer>> adjList,
            Map<String, Integer> lenvw,
            Map<Integer, Integer> len,
            Set<Integer> visited
    ) {
        int[] minvw = new int[] {-1,-1};
        int min = Integer.MAX_VALUE;

        for(Integer v : visited) {
            for(Integer w : adjList.get(v)) {
                if(!/*NOT*/visited.contains(w)) {
                    int vwstart = len.get(v) + getVWLength(v,w,lenvw);
                    if( vwstart < min) {
                        min = vwstart;
                        minvw[0] = v;
                        minvw[1] = w;
                    }
                }
            }
        }

        return minvw;
    }
}

