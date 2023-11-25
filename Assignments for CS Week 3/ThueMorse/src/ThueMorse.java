public class ThueMorse {
    public static void main(String[] args) {

            int n = Integer.parseInt(args[0]);

            int[] thueMorse = new int[n];

            // Generate Thue-Morse sequence
            for (int i = 0; i < n; i++) {
                thueMorse[i] = Integer.bitCount(i) % 2;
            }

            // Print n-by-n pattern
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (thueMorse[i] == thueMorse[j]) {
                        System.out.print("+  ");
                    } else {
                        System.out.print("-  ");
                    }
                }
                System.out.println();
        }
    }
}
