public class RevesPuzzle {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java RevesPuzzle <n>");
        }

        int n = Integer.parseInt(args[0]);
        if (n <= 0) {
            System.out.println("Please enter a positive integer for n.");
        }

        solveRevesPuzzle(n, 'A', 'D', 'B', 'C');
    }

    private static void move(int disc, char from, char to) {
        System.out.println("Move disc " + disc + " from " + from + " to " + to);
    }

    private static void solveRevesPuzzle(int n, char start, char dest, char temp1, char temp2) {
        if (n == 1) {
            move(1, start, dest);
        } else if (n == 2) {
            move(1, start, temp1);
            move(2, start, dest);
            move(1, temp1, dest);
        } else {
            int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

            solveRevesPuzzle(k, start, temp1, temp2, dest);
            solveRevesPuzzle(n - k, start, dest, temp2, temp1);
            solveRevesPuzzle(k, temp1, dest, start, temp2);
        }
    }
}
