import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;
/*************************************************************************
 * Name: Vengat Ramanan Ramar
 * Email:vengatramanan@gmail.com
 *
 * Compilation:  javac Brute.java
 * Execution:
 * Dependencies: 
 *
 * Description: 
 *
 *************************************************************************/

public class Fast2 {
    
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] pts = new Point[N];
        //Point[] sortedPts = new Point[N];
        
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(new Color(150, 35, 31));
        
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            //System.out.print("("+x+", "+y+")");
            //if (i < (N-1)) System.out.print(" -> ");
            pts[i] = new Point(x, y);
            pts[i].draw();      
        }
        
        for (int i = 0; i < N; i++) {
            Arrays.sort(pts, i+1, N, pts[i].SLOPE_ORDER);
            //Arrays.sort(pts, pts[i].SLOPE_ORDER);
            ArrayList<Point> collinearPointsForThisPoint = new ArrayList<Point>();
            //collinearPointsForThisPoint.add(pts[i]);
            for (int j = 0; j < N-1; j++) { 
                if (j == i) continue;
                if (pts[i].SLOPE_ORDER.compare(pts[j], pts[j+1]) == 0) {
                    if (j == i+1) {
                        collinearPointsForThisPoint.add(pts[i]);
                        collinearPointsForThisPoint.add(pts[j]); 
                    }
                    collinearPointsForThisPoint.add(pts[j+1]); 
                }            
            }
            Collections.sort(collinearPointsForThisPoint);
            if (collinearPointsForThisPoint.size() >= 3) {
                collinearPointsForThisPoint.get(0).drawTo(collinearPointsForThisPoint.get(collinearPointsForThisPoint.size()-1));
                int collinearPointsForThisPointSize = 0;
                for (Point point: collinearPointsForThisPoint) {
                    collinearPointsForThisPointSize++;
                    if (collinearPointsForThisPointSize < collinearPointsForThisPoint.size()) {
                        System.out.printf("%s ->", point);
                    } else {
                        System.out.printf("%s", point);
                    }                    
                }
            }
        }
        
    }
}
