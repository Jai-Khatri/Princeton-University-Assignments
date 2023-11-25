public class Ramanujan {

    // Returns true if n is a Ramanujan number, and false otherwise.
    public static boolean isRamanujan(long n) {
        long limit = (long) Math.cbrt(n); // Cube root of n as the limit for the search space

        for (long a = 1; a <= limit; a++) {
            long aCube = a * a * a;
            long bCube = n - aCube;

            long b = (long) Math.cbrt(bCube);

            if (b >= a && b * b * b == bCube) {
                return true; // Found a pair (a, b) such that a^3 + b^3 = n
            }
        }

        return false;
    }

    // Takes a long integer command-line argument n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Ramanujan <number>");
            return;
        }

        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
