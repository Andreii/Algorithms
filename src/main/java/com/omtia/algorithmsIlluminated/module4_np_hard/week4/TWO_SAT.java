/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.module4_np_hard.week4;

import java.io.File;
import java.util.*;

/**
 * The file format is as follows.  In each instance, the number of variables and the number of clauses is the same,
 * and this number is specified on the first line of the file.  Each subsequent line specifies a clause via its
 * two literals, with a number denoting the variable and a "-" sign denoting logical "not".  For example, the second
 * line of the first data file is "-16808 75250", which indicates the clause \neg x_{16808} \vee x_{75250}¬x
 * -16808 75250 => (non X 16808) OR (X 75250)
 *
 * Your task is to determine which of the 6 instances are satisfiable, and which are unsatisfiable.  In the box below,
 * enter a 6-bit string, where the ith bit should be 1 if the ith instance is satisfiable, and 0 otherwise.  For example,
 * if you think that the first 3 instances are satisfiable and the last 3 are not, then you should enter the string 111000
 * in the box below.
 *
 * DISCUSSION: This assignment is deliberately open-ended, and you can implement whichever 2SAT algorithm you want.
 * For example, 2SAT reduces to computing the strongly connected components of a suitable graph (with two vertices per
 * variable and two directed edges per clause, you should think through the details).  This might be an especially
 * attractive option for those of you who coded up an SCC algorithm in Part 2 of this specialization.  Alternatively,
 * you can use Papadimitriou's randomized local search algorithm.  (The algorithm from lecture is probably too slow
 * as stated, so you might want to make one or more simple modifications to it --- even if this means breaking the
 * analysis given in lecture --- to ensure that it runs in a reasonable amount of time.)  A third approach is
 * via backtracking.  In lecture we mentioned this approach only in passing; see Chapter 9 of the
 * Dasgupta-Papadimitriou-Vazirani book, for example, for more details.
 *
 */
public class TWO_SAT {

    protected static Map<Integer, List<Integer>> adj = new HashMap<>();
    protected static Map<Integer, Boolean> visited = new HashMap<>();
    protected static Stack<Integer> topology = new Stack<>();
    protected static Map<Integer, Integer> scc = new HashMap<>();
    protected static int counter = 1;

    static class Clause {
        Integer l1, l2;
        Clause(Integer l1, Integer l2) {
            this.l1 = l1;
            this.l2 = l2;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/2sat1.txt"));
//        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/2sat_small.txt")); 1
//        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/2sat_small2.txt")); 0

        // number of vertexes
        int n = scanner.nextInt();
        // number of clauses is equal to vertexes
        int m = n;

        List<Clause> clauses = new ArrayList<>();

        while(scanner.hasNext()) {
            clauses.add(new Clause(scanner.nextInt(), scanner.nextInt()));
        }

        for(int i = -n; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        if(isSatisfiable(n, clauses)) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
    }

    protected static void dfsTolopogy(int v) {
        if(visited.getOrDefault(v, false)) {
            return;
        }

        visited.put(v, true);

        for(int i = 0; i < adj.get(v).size(); i++) {
            dfsTolopogy(adj.get(v).get(i));
        }

        topology.add(v);
    }

    protected static void dfsSecond(int v) {
        if(visited.getOrDefault(v, false)) {
            return;
        }

        visited.put(v, true);

        for(int i = 0; i < adj.get(v).size(); i++) {
            dfsSecond(adj.get(v).get(i));
        }

        scc.put(v, counter);
    }

    protected static void addEdge(Integer t, Integer u) {
        adj.get(-t).add(u);
        adj.get(-u).add(t);
    }

    protected static void reverseGraph() {
        Map<Integer, List<Integer>> reversedAdj = new HashMap<>();

        int n = adj.size() / 2;

        // init adj array
        for(int i = -n; i <= n; i++) {
            reversedAdj.put(i, new ArrayList<>());
        }

        for(int i = -n; i <= n; i++) {
            if(i == 0) continue;;
            for(int j = 0; j < adj.get(i).size(); j++) {
                reversedAdj.get(adj.get(i).get(j)).add(i);
            }
        }

        adj = reversedAdj;
    }

    protected static boolean isSatisfiable(int n, List<Clause> clauses) {

        for(Clause clause : clauses) {
            addEdge(clause.l1, clause.l2);
        }

        // topology sort
        for(int i = -n; i <= n; i++) {
            if(i == 0) continue;
            if(!visited.getOrDefault(i, false)) {
                dfsTolopogy(i);
            }
        }

        // reverse edges
        reverseGraph();
        visited = new HashMap<>();

        // compute scc
        while(!topology.isEmpty()) {
            int top = topology.pop();

            if(!visited.getOrDefault(top, false)) {
                int finalCounter = counter;
                dfsSecond(top);
                counter++;
            }
        }

        // index out of bounds
        for(int i = 1; i <= n; i++) {
            if(scc.containsKey(i) && scc.containsKey(-i) && scc.get(i).equals(scc.get(-i))) {
                return false;
            }
        }

        return true;
    }
}
