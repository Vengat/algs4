import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;
/*************************************************************************
  * Name: Vengat Ramanan Ramar
  * Email:vengatramanan@gmail.com
  *
  * Compilation:  javac Fast.java
  * Execution:
  * Dependencies: 
  *
  * Description: 
  *
  *************************************************************************/

public class Fast {
    
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] pts = new Point[N];
        
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(new Color(150, 35, 31));
        
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            pts[i] = new Point(x, y);
            pts[i].draw();      
        }
        
        for (int i = 0; i < N; i++) {
            //Arrays.sort(pts, i+1, N, pts[i].SLOPE_ORDER);
            //Arrays.sort(pts, pts[i].SLOPE_ORDER);
            Point[] sortedPts = null;
            sortedPts = Arrays.copyOf(pts, N);
            Arrays.sort(sortedPts, sortedPts[i].SLOPE_ORDER);
            ArrayList<Point> collinearPointsForThisPoint = new ArrayList<Point>();
            
            int l = 1;
            int m = l + 1;
            while (l < N-2) {
                //System.out.println(m);
                //if (l == m) m++;
                if (sortedPts[0].slopeTo(sortedPts[l]) == sortedPts[0].slopeTo(sortedPts[m])) {
                    if (collinearPointsForThisPoint.size() == 0) {
                        collinearPointsForThisPoint.add(sortedPts[0]);
                        collinearPointsForThisPoint.add(sortedPts[l]); 
                    }    
                    collinearPointsForThisPoint.add(sortedPts[m]);
                }
                m++;
                if (m >= N) {
                    l++;
                    m = l + 1;
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
                        System.out.println("");
                        collinearPointsForThisPoint.clear();
                    }
                }
            }
        }
        
    }
}
