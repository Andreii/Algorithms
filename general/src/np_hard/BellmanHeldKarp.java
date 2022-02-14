package np_hard;

import java.io.File;
import java.util.*;

public class BellmanHeldKarp {
    static class Position {
        float x,y;
        Position(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return Float.compare(position.x, x) == 0 && Float.compare(position.y, y) == 0 ||
                    Float.compare(position.x, y) == 0 && Float.compare(position.y, x) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("general/resources/tsp.txt"));

        int n = Integer.parseInt(scanner.nextLine());

        List<Position> cityPositions = new ArrayList<>();
        float[][] dist = new float[n][n];

        while(scanner.hasNext()) {
            String[] cityXY = scanner.nextLine().split(" ");
            cityPositions.add(new Position(Float.parseFloat(cityXY[0]), Float.parseFloat(cityXY[1])));
        }

        for(int i = 0; i < cityPositions.size(); i++) {
            for(int j = 0; j < cityPositions.size(); j++) {
                if(i == j) {
                    continue;
                }

                Position A = cityPositions.get(i);
                Position B = cityPositions.get(j);

                float distance = (float) Math.sqrt(Math.pow(A.x - B.x, 2) + Math.pow(A.y - B.y, 2));

                dist[i][j] = dist[j][i] = distance;
            }
        }

        float MAX = Float.MAX_VALUE;
        float[][] dp = new float[n][1 << n];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], MAX);
        }

        dp[0][1] = 0.0f;
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int last = 0; last < n; last++) {
                if ((mask & (1 << last)) == 0) {
                    continue;
                }
                for (int next = 0; next < n; next++) {
                    if ((mask & (1 << next)) != 0) {
                        continue;
                    }
                    dp[next][mask | (1 << next)] = Math.min(
                            dp[next][mask | (1 << next)],
                            dp[last][mask] + dist[last][next]);
                }
            }
        }

        double res = MAX;
        for (int last = 0; last < n; last++) {
            res = Math.min(res, dist[last][0] + dp[last][(1 << n) - 1]);
        }

        System.out.println(res);
    }
}