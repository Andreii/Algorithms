package Arrays_and_Strings;

public class _1_8_Zero_Matrix {
    public static void zeroMatrix(int[][] m) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // check if the matrix has first row zero
        for (int i = 0; i < m.length; ++i) {
            if( m[0][i] == 0 ) {
                rowHasZero = true;
                break;
            }
        }
        // check if the matrix has first col zero
        for (int i = 0; i < m.length; ++i) {
            if( m[i][0] == 0 ) {
                colHasZero = true;
                break;
            }
        }

        // 1 1 1 1 1
        // 1 1 0 1 1
        // 1 1 1 1 1
        // 1 0 1 1 1
        // 1 1 1 1 1

        // find and mark
        findZeroAndMark(m);

        // zero column
        zeroCol(m);

        // zero row
        zeroRow(m);

        // zero first row
        if (rowHasZero) {
            zeroRow(0, m);
        }
        // zero first col
        if (colHasZero) {
            zeroCol(0, m);
        }
    }

    public static void findZeroAndMark(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }
    }

    public static void zeroRow(int[][] m) {
        for(int row = 0; row < m.length; row++) {
            if(m[row][0] == 0) {
                zeroRow(row, m);
            }
        }
    }

    public static void zeroCol(int[][] m) {
        for(int col = 0; col < m.length; col++) {
            if(m[0][col] == 0) {
                zeroCol(col, m);
            }
        }
    }

    static void zeroRow(int row, int[][] m) {
        for (int i = 0; i < m.length; ++i) {
            m[row][i] = 0;
        }
    }

    static void zeroCol(int col, int[][] m) {
        for (int i = 0; i < m.length; ++i) {
            m[i][col] = 0;
        }
    }
}
