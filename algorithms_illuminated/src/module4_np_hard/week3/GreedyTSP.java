package module4_np_hard.week3;

import java.io.File;
import java.util.*;

/**
 * The first line indicates the number of cities. Each city is a point in the plane, and each subsequent line indicates
 * the x- and y-coordinates of a single city.
 *
 * The distance between two cities is defined as the Euclidean distance --- that is, two cities at locations (x,y)(x,y)
 * and (z,w)(z,w) have distance \sqrt{(x-z)^2 + (y-w)^2}
 * (x−z)
 * 2
 *  +(y−w)
 * 2
 *
 * ​
 *   between them.
 *
 * You should implement the nearest neighbor heuristic:
 *
 * Start the tour at the first city.
 *
 * Repeatedly visit the closest city that the tour hasn't visited yet.  In case of a tie, go to the closest city with
 * the lowest index.  For example, if both the third and fifth cities have the same distance from the first city (and
 * are closer than any other city), then the tour should begin by going from the first city to the third city.
 *
 * Once every city has been visited exactly once, return to the first city to complete the tour.
 *
 * In the box below, enter the cost of the traveling salesman tour computed by the nearest neighbor heuristic for this
 * instance, rounded down to the nearest integer.
 *
 * [Hint: when constructing the tour, you might find it simpler to work with squared Euclidean distances (i.e., the
 * formula above but without the square root) than Euclidean distances.  But don't forget to report the length of the
 * tour in terms of standard Euclidean distance.]
 */
public class GreedyTSP {
    static class City {
        double x,y; int i;
        City(int i, double x, double y) {
            this.i = i;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/nn.txt"));
//        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/nn_test.txt")); // 15.23606797749979
//        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/nn_test2.txt")); // 23.397658069412095
//        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/nn_test3.txt")); // 623487.9596431205
//        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/nn_test4.txt")); // 7060869.071875891

        int n = Integer.parseInt(scanner.nextLine());

        List<City> cities = new ArrayList<>();
        int max = Integer.MAX_VALUE; // for checking first max items
        while(scanner.hasNext()) {
            if(max == 0) {
                break;
            }
            String[] coords = scanner.nextLine().split(" ");
            cities.add(new City(
                    Integer.parseInt(coords[0]),
                    Double.parseDouble(coords[1]),
                    Double.parseDouble(coords[2]))
            );
            max--;
        }

        double result = 0;

        var o = new Object() {
            City curr = cities.get(0), start = cities.get(0), next;
        };
        cities.remove(0);

        while(cities.size() > 0) {
            cities.sort((c1, c2) -> {
                double dist1 = distNoSqrt(o.curr, c1);
                double dist2 = distNoSqrt(o.curr, c2);

                if(dist1 == dist2) {
                    return c1.i - c2.i;
                } else if(dist1 < dist2) {
                    return -1;
                } else {
                    return 1;
                }
            });
            o.next = cities.get(0);
            cities.remove(0);
            result += dist(o.curr, o.next);
//            System.out.printf("(%d, %f)\n", o.next.i, result);
            o.curr = o.next;
        }

        result += dist(o.curr, o.start);
        System.out.println("Greedy TSP is: " + result);
    }

    public static double dist(City a, City b) {
        return Math.sqrt(distNoSqrt(a,b));
    }
    public static double distNoSqrt(City a, City b) {
        return Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2);
    }
}
