public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int n = a.length;
        long inversions = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    inversions++;
                }
            }
        }

        return inversions;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] permutation = new int[n];

        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }

        int[] result = new int[n];
        int[] temp = new int[n];
        int index = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (k >= i) {
                result[index--] = n - i - 1;
                k -= i;
            } else {
                result[index--] = n - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            temp[result[i]] = permutation[i];
        }

        return temp;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Inversions <n> <k>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] result = generate(n, k);
        for (int value : result) {
            System.out.print(value + " ");
        }

        System.out.println();
    }
}
