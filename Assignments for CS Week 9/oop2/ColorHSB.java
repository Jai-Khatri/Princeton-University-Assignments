public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100) {
            throw new IllegalArgumentException("Invalid HSB components");
        }
        this.hue = h;
        this.saturation = s;
        this.brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        int dHue = Math.min((hue - that.hue) * (hue - that.hue), (360 - Math.abs(hue - that.hue)) * (360 - Math.abs(hue - that.hue)));
        int dSaturation = (saturation - that.saturation) * (saturation - that.saturation);
        int dBrightness = (brightness - that.brightness) * (brightness - that.brightness);

        return dHue + dSaturation + dBrightness;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java ColorHSB <hue> <saturation> <brightness>");
            return;
        }

        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB targetColor = new ColorHSB(h, s, b);

        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int hue = StdIn.readInt();
            int saturation = StdIn.readInt();
            int brightness = StdIn.readInt();

            ColorHSB currentColor = new ColorHSB(hue, saturation, brightness);

            if (currentColor.distanceSquaredTo(targetColor) <  currentColor.distanceSquaredTo(targetColor)) {
                System.out.println(colorName + " " + currentColor.toString());
            }
        }
    }
}
