/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();       // YOUR DEFINITION HERE
    
    private class SlopeOrder implements Comparator<Point> {
        public int compare(Point a, Point b) {
            double slopeA = slopeTo(a);
            double slopeB = slopeTo(b);
            if (slopeA == slopeB) return 0;
            if (slopeA < slopeB) return -1;
            return 1;
            //return a.compareTo(b);
        }
    }

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        if (that == null) throw new java.lang.NullPointerException();
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        if (that == null) throw new java.lang.NullPointerException();
        /* YOUR CODE HERE */
        //double pInfiniteDouble = Double.POSITIVE_INFINITY;
        //double nInfiniteDouble = Double.NEGATIVE_INFINITY;
        if ((that.y - this.y == 0) && (that.x - this.x == 0)) return Double.NEGATIVE_INFINITY;
        //if ((that.y == this.y) && (that.x == this.x)) return Double.NEGATIVE_INFINITY;
        if ((that.y - this.y) == 0) return 0;
        if ((that.x - this.x) == 0) return Double.POSITIVE_INFINITY;
        //if (that.x == this.x) return Double.POSITIVE_INFINITY;
        //double slopeTo = (that.y - this.y)/(that.x - this.x);
        return (double) (that.y - this.y)/(that.x - this.x);
        //return slopeTo;
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
//    public int compareTo(Point that) {
//        if (that == null) throw new java.lang.NullPointerException();
//        /* YOUR CODE HERE */
//        if (this.x < that.x && this.y <= that.y) return -1;
//        if (this.x == that.x && this.y == that.y) return 0;
//        return 1;
//    }
    
    
    public int compareTo(Point that) {
        if (that == null) throw new java.lang.NullPointerException();
        /* YOUR CODE HERE */
        if (this.y > that.y) return 1;
        if (this.y == that.y) {
            if (this.x > that.x) return 1;
        }
        if (this.y == that.y) {
            if (this.x == that.x) return 0;
        }
        return -1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
        
        Point pointA = new Point(0, 0);
        Point pointB = new Point(1, 1);
        Point pointC = new Point(2, 2);
        pointA.drawTo(pointB);
        pointB.drawTo(pointC);
        System.out.println(pointA.slopeTo(pointC));
    }
}