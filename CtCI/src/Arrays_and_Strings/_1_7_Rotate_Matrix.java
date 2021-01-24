package Arrays_and_Strings;

public class _1_7_Rotate_Matrix {
    public static int[][] rotate(int[][] m) {
        // 0 0 0 0 0
        // 0 1 1 1 0
        // 0 1 0 1 0
        // 0 1 1 1 0
        // 0 0 0 0 0

        int n = m.length;

        for( int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - first;

            for (int i = first; i < last; i ++) {
                int offset = i - first;
                // save top
                int top = m[first][i];


                // top = left
                m[first][i] = m[last - offset][first];

                // left = bottom
                m[last - offset][first] = m[last][last - offset];

                // bottom = right
                m[last][last - offset] = m[i][last];

                // right = top
                m[i][last] = top;
            }
        }

        return m;
    }

    public static void printMatrix(int[][] m) {
        for(int i = 0; i < m.length; i++) {
            for( int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
        };

        printMatrix(matrix);

        rotate(matrix);

        printMatrix(matrix);
    }
}
