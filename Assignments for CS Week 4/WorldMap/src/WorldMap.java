public class WorldMap {
    public static void main(String[] args) {
        // Read width and height
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        // Set canvas size
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        // Read and draw regions
        while (!StdIn.isEmpty()) {
            // Read region name
            String regionName = StdIn.readString();

            // Read number of vertices
            int numVertices = StdIn.readInt();

            // Read and draw the polygon
            double[] xCoordinates = new double[numVertices];
            double[] yCoordinates = new double[numVertices];

            for (int i = 0; i < numVertices; i++) {
                xCoordinates[i] = StdIn.readDouble();
                yCoordinates[i] = StdIn.readDouble();
            }

            StdDraw.polygon(xCoordinates, yCoordinates);
        }
    }
}
