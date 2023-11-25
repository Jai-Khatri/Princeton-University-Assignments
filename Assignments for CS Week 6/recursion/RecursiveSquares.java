public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        double halfLength = length / 2.0;

        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, halfLength);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, halfLength);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) {
            return;
        }

        // Draw the central square
        drawSquare(x, y, length);

        // Calculate the coordinates for the four smaller squares
        double xRight = x + length / 2.0;
        double yTop = y + length / 2.0;

        // Recursively draw the four smaller squares
        draw(n - 1, x, yTop, length / 2.0);      // Top
        draw(n - 1, xRight, y, length / 2.0);    // Right
        draw(n - 1, x, y - length / 2.0, length / 2.0); // Bottom
        draw(n - 1, x - length / 2.0, y, length / 2.0); // Left
    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);


        // Draw the recursive square pattern
        draw(n, 0.5, 0.5, 0.5);
    }
}
