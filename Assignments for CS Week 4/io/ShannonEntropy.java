public class ShannonEntropy {
    public static void main(String[] args) {

            int m = Integer.parseInt(args[0]);

            int[] frequencies = new int[m + 1];
            int totalCount = 0;

            while (!StdIn.isEmpty()) {
                int value = StdIn.readInt();
                if (value >= 1 && value <= m) {
                    frequencies[value]++;
                    totalCount++;
                }
            }

            double entropy = 0.0;

            for (int i = 1; i <= m; i++) {
                double pi = (double) frequencies[i] / totalCount;
                if (pi > 0) {
                    entropy -= pi * (Math.log(pi) / Math.log(2));
                }
            }

            // Print Shannon entropy with 4 digits after the decimal point
            System.out.printf("%.4f\n", entropy);


    }
}
