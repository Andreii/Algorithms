package algorithms;

import java.io.File;
import java.util.*;

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
        Scanner scanner = new Scanner(new File("general/resources/nn.txt"));
//        Scanner scanner = new Scanner(new File("general/resources/nn_test.txt")); // 15.23606797749979
//        Scanner scanner = new Scanner(new File("general/resources/nn_test2.txt")); // 23.397658069412095
//        Scanner scanner = new Scanner(new File("general/resources/nn_test3.txt")); // 623487.9596431205
//        Scanner scanner = new Scanner(new File("general/resources/nn_test4.txt")); // 7060869.071875891

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
