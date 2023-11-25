public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (x < 0) return 0.0;
        else if (x > 0) return 1.0;
        else return 0.5;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        return Math.tanh(x);
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (x <= -2) return -1.0;
        else if (-2 < x && x < 0) return x + 0.5 * Math.pow(x, 2);
        else if (0 <= x && x < 2) return x - 0.5 * Math.pow(x, 2);
        else return 1.0;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);

        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("  sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("     tanh(" + x + ") = " + tanh(x));
        System.out.println(" softsign(" + x + ") = " + softsign(x));
        System.out.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}
