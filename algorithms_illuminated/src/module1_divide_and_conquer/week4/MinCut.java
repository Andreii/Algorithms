package module1_divide_and_conquer.week4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The file contains the adjacency list representation of a simple undirected graph. There are 200 vertices labeled 1
 * to 200. The first column in the file represents the vertex label, and the particular row (other entries except the
 * first column) tells all the vertices that the vertex is adjacent to. So for example, the 6^{th}6
 * th
 *   row looks like : "6	155	56	52	120	......". This just means that the vertex with label 6 is adjacent to (i.e.,
 *   shares an edge with) the vertices with labels 155,56,52,120,......,etc
 *
 * Your task is to code up and run the randomized contraction algorithm for the min cut problem and use it on the above
 * graph to compute the min cut.  (HINT: Note that you'll have to figure out an implementation of edge contractions.
 * Initially, you might want to do this naively, creating a new graph from the old every time there's an edge
 * contraction.  But you should also think about more efficient implementations.)   (WARNING: As per the video lectures,
 * please make sure to run the algorithm many times with different random seeds, and remember the smallest cut that you
 * ver find.)  Write your numeric answer in the space provided.  So e.g., if your answer is 5, just type 5 in the space
 * provided.
 */
public class MinCut {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("algorithms_illuminated/resources/kargerMinCut.txt"));
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

        int minCut = Integer.MAX_VALUE;
        for(int i = 0; i < 1_000_00; i++) {
            minCut = Math.min(minCut, minCut(new ArrayList<>(adjacentList)));
//            System.out.println(minCut);
        }

        System.out.println(minCut);
    }

    public static int minCut(List<List<Integer>> adjList) {

        List<Integer> rowList = new ArrayList<>();
        for(int i = 0; i < adjList.size(); i++) {
            rowList.add(i+1);
        }

        while(rowList.size() > 2) {
            int rowRandomInteger = (int) (Math.random() * (rowList.size()) - 1);
            int rowRandomValue = rowList.get(rowRandomInteger);
            int rowRandomIndex = rowRandomValue - 1;

            if (adjList.get(rowRandomIndex).size() == 0) {
                rowList = rowList.stream().filter(v -> v != rowRandomValue).collect(Collectors.toList());
                continue;
            }
            int colRandomValue = adjList.get(rowRandomIndex).get((int) (Math.max(Math.random() * (adjList.get(rowRandomIndex).size()),0)));
            int colRandomIndex = colRandomValue - 1;

            List<Integer> mergedRowCol = new ArrayList<>();
            List<Integer> colList = adjList.get(colRandomIndex).stream().filter(v -> v != rowRandomValue).collect(Collectors.toList());
            mergedRowCol.addAll(adjList.get(rowRandomIndex).stream().filter(v -> v != colRandomValue).collect(Collectors.toList()));
            mergedRowCol.addAll(colList.stream().filter(v -> v != rowRandomValue).collect(Collectors.toList()));
            adjList.set(rowRandomIndex, mergedRowCol);

            for(Integer col : colList.stream().distinct().collect(Collectors.toList())) {
                List<Integer> column = adjList.get(col - 1);
                column.replaceAll( v -> v == colRandomValue ? rowRandomValue : v);
            }

            rowList = rowList.stream().filter(v -> v != colRandomValue).collect(Collectors.toList());
            adjList.set(colRandomIndex, new ArrayList<>());
        }

        return adjList.get(rowList.get(0)-1).size();
    }
}
