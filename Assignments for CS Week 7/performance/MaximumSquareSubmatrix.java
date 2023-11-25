public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        if (a == null || a.length == 0 || a[0] == null || a[0].length == 0) {
            return 0; // Handle empty or null matrix
        }

        int n = a.length;
        int m = a[0].length;
        int[][] dp = new int[n][m];
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = a[i][j];
                } else if (a[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }

                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        return maxSize;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1}
        };

        int result = size(matrix);
        System.out.println(result);
    }
}
