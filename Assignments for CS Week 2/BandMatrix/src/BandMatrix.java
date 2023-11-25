public class BandMatrix {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java BandMatrix <n> <width>");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            int width = Integer.parseInt(args[1]);

            if (n <= 0 || width < 0 || width >= n) {
                System.out.println("Error: Invalid input. n should be a positive integer, and width should be a non-negative integer less than n.");
                return;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Math.abs(i - j) > width) {
                        System.out.print("0  ");
                    } else {
                        System.out.print("*  ");
                    }
                }
                System.out.println();
            }
        } catch(NumberFormatException e){
            System.out.println("Error: Invalid input. Please enter valid integers for n and width.");
        }
    }
}
