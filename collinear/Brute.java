import java.util.Arrays;
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

public class Brute {
    
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
            //System.out.print("("+x+", "+y+")");
            //if (i < (N-1)) System.out.print(" -> ");
            pts[i] = new Point(x, y);
            pts[i].draw();      
        }
        
        for (int i = 0; i < N-3; i++) {
            for (int j = i + 1; j < N-2; j++) {
                //if (j == i) continue;
                for (int k = j + 1; k < N-1; k++) {
                    //if (k == j) continue;
                    //if (!collinear(new Point[] {pts[i], pts[j], pts[k]})) continue;
                    for (int l = k + 1; l < N; l++) {
                        //if (l == k) continue;
                        if (collinear(new Point[] {pts[i], pts[j], pts[k], pts[l]})) {
                        //pts[i].drawTo(pts[j]);
                        //pts[i].drawTo(pts[k]);
                        //pts[i].drawTo(pts[l]);
                        Point[] arr = new Point[]{ pts[i], pts[j], pts[k], pts[l] };
                        Arrays.sort(arr);
                        arr[0].drawTo(arr[3]);
                        System.out.printf("%s -> %s -> %s -> %s", pts[i], pts[j], pts[k], pts[l]);
                        System.out.println("");
                        }
                    }
                }
            }
        }
      
    }
    
    private static boolean collinear(Point[] points) 
    {
        double refSlopeTo = points[0].slopeTo(points[1]);
        for (int i = 2; i < points.length; i++) {
            if (points[0].slopeTo(points[i]) != refSlopeTo) return false;            
        }
        return true;
    }
    
    
}
