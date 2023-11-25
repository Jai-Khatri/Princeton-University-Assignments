public class TrinomialBrute {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;
        return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java TrinomialBrute <n> <k>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        // Validate input
        if (n < 0) {
            System.out.println("Please enter a non-negative integer for n.");
            return;
        }

        // Compute and print the trinomial coefficient
        System.out.println(trinomial(n, k));
    }
}
