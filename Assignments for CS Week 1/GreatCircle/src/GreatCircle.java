public class GreatCircle {
    public static void main(String[] args) {

            double x1 = Math.toRadians(Double.parseDouble(args[0]));
            double y1 = Math.toRadians(Double.parseDouble(args[1]));
            double x2 = Math.toRadians(Double.parseDouble(args[2]));
            double y2 = Math.toRadians(Double.parseDouble(args[3]));

            double r = 6371.0; // Mean radius of the Earth in kilometers

            double dX = x2 - x1;
            double dY = y2 - y1;

            double a = Math.sin(dX / 2) * Math.sin(dX / 2) + Math.cos(x1) * Math.cos(x2) * Math.sin(dY / 2) * Math.sin(dY / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            double distance = r * c;
            System.out.println(distance + " kilometers");
    }
}
