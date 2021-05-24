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

        int minCut = Integer.MAX_VALUE;
        for(int i = 0; i < 1_000_00; i++) {
            minCut = Math.min(minCut, minCut(new ArrayList<>(adjacentList)));
            System.out.println(minCut);
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
