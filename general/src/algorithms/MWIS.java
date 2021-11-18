package algorithms;

//This file describes the weights of the vertices in a path graph (with the weights listed in the order in which vertices appear in the path). It has the following format:
//
//[number_of_vertices]
//
//[weight of first vertex]
//
//[weight of second vertex]
//
//...
//
//For example, the third line of the file is "6395702," indicating that the weight of the second vertex of the graph is 6395702.
//
//Your task in this problem is to run the dynamic programming algorithm (and the reconstruction procedure) from lecture
// on this data set.  The question is: of the vertices 1, 2, 3, 4, 17, 117, 517, and 997, which ones belong to the
// maximum-weight independent set?  (By "vertex 1" we mean the first vertex of the graph---there is no vertex 0.)
//
// In the box below, enter a 8-bit string, where the ith bit should be 1 if the ith of these 8 vertices is in the
// maximum-weight independent set, and 0 otherwise. For example, if you think that the vertices 1, 4, 17, and 517 are
// in the maximum-weight independent set and the other four vertices are not, then you should enter the string 10011010
// in the box below.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MWIS {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new File("general/resources/mwis.txt"));
//            Scanner scanner = new Scanner(new File("general/resources/mwis_1.txt")); // 0101010101
//            Scanner scanner = new Scanner(new File("general/resources/mwis_2.txt")); // 1010010010
//            Scanner scanner = new Scanner(new File("general/resources/mwis_small.txt"));

            int vertices_count = Integer.parseInt(scanner.nextLine());
            long[] weights = new long[vertices_count+1];

            int loop = 1;
            while(scanner.hasNext()) {
                weights[loop++] = Long.parseLong(scanner.nextLine());
            }

            long[] A = new long[vertices_count+1];
            long[] solution = new long[vertices_count+1];

            A[0] = 0;
            A[1] = weights[1];

            for(int i = 2; i <= vertices_count; i++) {
                A[i] = Math.max(A[i-1], A[i-2] + weights[i]);
            }

            int i = vertices_count;
            while(i >= 1) {
                if(i==1) { solution[1] = 1; break; }
                if(A[i-1] >= A[i-2] + weights[i]) {
                    i--;
                } else {
                    solution[i] = 1;
                    i-=2;
                }
            }

//            int[] vertices_index_to_check = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            int[] vertices_index_to_check = new int[] { 1, 2, 3, 4, 17, 117, 517, 997 };

            for(int vertex : vertices_index_to_check) {
                System.out.print(solution[vertex]);
            }
        } catch (FileNotFoundException e ) { /* ignore */ }
    }
}
