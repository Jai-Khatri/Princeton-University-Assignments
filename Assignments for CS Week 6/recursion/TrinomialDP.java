public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // Create a 2D array to store the trinomial coefficients
        long[][] trinomials = new long[n + 1][2 * n + 3];

        // Base case: T(0, 0) = 1
        trinomials[0][n + 1] = 1;

        // Fill in the array using dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = -i; j <= i; j++) {
                trinomials[i][j + n + 1] =
                        trinomials[i - 1][j - 1 + n + 1] +
                                trinomials[i - 1][j + n + 1] +
                                trinomials[i - 1][j + 1 + n + 1];
            }
        }

        // The result is in the center of the array
        return trinomials[n][k + n + 1];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java TrinomialDP <n> <k>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        // Validate input
        if (n < 0 || k < -n || k > n) {
            System.out.println("Please enter valid values for n and k.");
            return;
        }

        // Compute and print the trinomial coefficient
        long result = trinomial(n, k);
        System.out.println(result);
    }
}
