public class GeneralizedHarmonic {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java GeneralizedHarmonic <n> <r>");
            return;
        }

        double n = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);

        if (r == 0) {
            r = n;
            System.out.println(r);
            return;
        }

        if(r < 0){
            if(r % 2 == 0){
              r = r * -3 - 1;
            }
            else{
                r = r * -3;
            }
            System.out.println(r);
        }
        double harmonicNumber = 0.0;

        for (int i = 1; i <= n; i++) {
            harmonicNumber += 1.0 / Math.pow(i, r);
        }

        System.out.println(harmonicNumber);
    }
}
