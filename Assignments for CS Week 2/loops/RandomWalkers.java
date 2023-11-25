public class RandomWalkers {
    public static void main(String[] args) {

        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int totalSteps = 0;

        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;

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
            }

            totalSteps += steps;
        }

        double averageSteps = (double) totalSteps / trials;

        System.out.println("Average number of steps = " + averageSteps);

    }
}
