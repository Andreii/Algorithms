package algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinCut {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/act/mds/projects/git/algo/general/src/algorithms/kargerMinCut.txt"));
        List<List<Integer>> adjacentList = new ArrayList<>(200);


        String line = bufferedReader.readLine();

        while(line != null) {
            List<Integer> columns = Arrays.stream(line.split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

            columns.remove(0);
            adjacentList.add(columns);

            line = bufferedReader.readLine();
        }

        int minCut = minCut(adjacentList);

        for(int i = 0; i < adjacentList.size(); i++) {
            for (int j = 0; j < adjacentList.get(i).size(); j++) {
                System.out.printf("%d ", adjacentList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static int minCut(List<List<Integer>> adjList) {

        List<Integer> visitedRow = new ArrayList<>();
        List<Integer> rowList = new ArrayList<>();
        for(int i = 0; i < adjList.size(); i++) {
            rowList.add(i);
        }

        while(rowList.size() > 2) {
            int rowRandomInteger = (int) (Math.random() * (rowList.size()) - 1);
            int rowRandom = rowList.get(rowRandomInteger);
            int colRandom = adjList.get(rowRandom).get((int) (Math.random() * (adjList.get(rowRandom).size()) - 1)) -1;
            visitedRow.add(rowRandom);
            List<Integer> mergedRowCol = new ArrayList<>();
            List<Integer> colList = adjList.get(colRandom).stream().filter(v -> v != rowRandom + 1).collect(Collectors.toList());
            mergedRowCol.addAll(adjList.get(rowRandom).stream().filter(v -> v != colRandom + 1).collect(Collectors.toList()));
            mergedRowCol.addAll(colList);
            adjList.set(rowRandom, mergedRowCol);

            for(Integer col : colList.stream().distinct().collect(Collectors.toList())) {
                List<Integer> column = adjList.get(col - 1);
                column.replaceAll( v -> v == colRandom + 1 ? rowRandom : v);
            }

            rowList = rowList.stream().filter(v -> v != colRandom).collect(Collectors.toList());
            adjList.set(colRandom, new ArrayList<>());
        }

        return adjList.get(0).size();
    }
}
