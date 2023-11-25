public class DiscreteDistribution {
    public static void main(String[] args) {

            int m = Integer.parseInt(args[0]);

            // Initialize an array to store cumulative sums
            int[] cumulativeSums = new int[args.length - 1];
            cumulativeSums[0] = Integer.parseInt(args[1]);

            // Calculate cumulative sums
            for (int i = 2; i < args.length; i++) {
                cumulativeSums[i - 1] = cumulativeSums[i - 2] + Integer.parseInt(args[i]);
            }

            // Generate random indices
            for (int j = 0; j < m; j++) {
                int totalSum = cumulativeSums[cumulativeSums.length - 1];
                int randomValue = (int) (Math.random() * totalSum);

                int randomIndex;
                for (randomIndex = 0; randomIndex < cumulativeSums.length; randomIndex++) {
                    if (randomValue < cumulativeSums[randomIndex]) {
                        break;
                    }
                }

                System.out.print(randomIndex + " "); // Indices start from 1
            }


    }
}
