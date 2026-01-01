/** Draws the Koch curve and the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {

        //// Uncomment the first code block to test the curve function.
        //// Uncomment the second code block to test the snowflake function.
        //// Uncomment only one block in each test, and remember to compile
        //// the class whenever you change the test.


        // Tests the curve function:
        // Gets n, x1, y1, x2, y2,
        // and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
        // testing parameters for the curve function
        // int n = 7;
        // double x1 = 0.1;
        // double y1 = 0.0;
        // double x2 = 0.9;
        // double y2 = 0.0;
        // curve(n, x1, y1, x2, y2);

        // Tests the snowflake function:
        // Gets n, and draws a Koch snowflake of depth n in the standard canvas.
        // snowFlake(Integer.parseInt(args[0]));
        snowFlake(7);
    }

    /** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        // Base case: at depth 0, just draw the straight segment.
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        // Compute the division points on the segment.
        double dx = x2 - x1;
        double dy = y2 - y1;

        // Points A, B, D, E (E is just (x2, y2))
        double ax = x1;
        double ay = y1;

        double bx = x1 + dx / 3.0;
        double by = y1 + dy / 3.0;

        double dx3 = x1 + 2.0 * dx / 3.0;
        double dy3 = y1 + 2.0 * dy / 3.0;

        double ex = x2;
        double ey = y2;

        // Point C: the tip of the equilateral "bump"
        double vx = dx3 - bx;         // vector from B to D
        double vy = dy3 - by;

        double cos60 = 0.5;
        double sin60 = Math.sqrt(3) / 2.0;

        // Rotate vector (vx, vy) by +60 degrees and add to B
        double cx = bx + cos60 * vx - sin60 * vy;
        double cy = by + sin60 * vx + cos60 * vy;

        // Recursive calls on the four segments: A-B, B-C, C-D, D-E
        curve(n - 1, ax, ay, bx, by);
        curve(n - 1, bx, by, cx, cy);
        curve(n - 1, cx, cy, dx3, dy3);
        curve(n - 1, dx3, dy3, ex, ey);
    }

    /** Gets n, and draws a Koch snowflake of depth n in the standard canvas. */
    public static void snowFlake(int n) {
        // A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);

        // Define an equilateral triangle in the canvas
        double x1 = 0.1, y1 = 0.2;
        double x2 = 0.9, y2 = 0.2;
        double side = x2 - x1;
        double height = side * Math.sqrt(3) / 2.0;

        double x3 = 0.5;
        double y3 = y1 + height;

        // Draw the three sides as Koch curves
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}
