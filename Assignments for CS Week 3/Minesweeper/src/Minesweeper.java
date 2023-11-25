public class Minesweeper {
    public static void main(String[] args) {

            int m = Integer.parseInt(args[0]);
            int n = Integer.parseInt(args[1]);
            int k = Integer.parseInt(args[2]);

            if (m <= 0 || n <= 0 || k < 0 || k >= m * n) {
                System.out.println("Error: Invalid input. Please enter valid positive integers for m, n, and k.");
                return;
            }

            char[][] grid = new char[m][n];

            // Initialize grid with mines
            for (int i = 0; i < k; i++) {
                int randomRow, randomCol;
                do {
                    randomRow = (int) (Math.random() * m);
                    randomCol = (int) (Math.random() * n);
                } while (grid[randomRow][randomCol] == '*');

                grid[randomRow][randomCol] = '*';
            }

            // Fill in the counts for neighboring mines
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] != '*') {
                        int mineCount = 0;

                        for (int i = row - 1; i <= row + 1; i++) {
                            for (int j = col - 1; j <= col + 1; j++) {
                                if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '*') {
                                    mineCount++;
                                }
                            }
                        }

                        grid[row][col] = (char) ('0' + mineCount);
                    }
                }
            }

            // Print the grid
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(grid[i][j] + "  ");
                }
                System.out.println();
            }


    }
}
