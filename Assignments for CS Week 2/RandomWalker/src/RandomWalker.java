public class RandomWalker {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java RandomWalker <r>");
            return;
        }

        try {
            int r = Integer.parseInt(args[0]);
            int x = 0;
            int y = 0;
            int steps = 0;

            System.out.println("(0, 0)");

            while (Math.abs(x) + Math.abs(y) < r) {
                int randomDirection = (int) (Math.random() * 4); // 0: north, 1: east, 2: south, 3: west

                switch (randomDirection) {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x++;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                        x--;
                        break;
                }

                steps++;
                System.out.println("(" + x + ", " + y + ")");
            }

            System.out.println("steps = " + steps);

            // Check correctness of inputs
            if (x == 0 && y == 0) {
                System.out.println("Inputs are correct. Starting point is the origin (0, 0).");
            } else {
                System.out.println("Error: Incorrect starting point.");
            }

            // Check consistency in the number of steps and points
            if (steps == Math.abs(x) + Math.abs(y)) {
                System.out.println("Consistency check passed. Number of steps is consistent with the number of points.");
            } else {
                System.out.println("Error: Inconsistent number of steps and points.");
            }

            if (r <= 0) {
                System.out.println("Error: r must be a positive integer.");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid integer for r.");
        }
    }
}
