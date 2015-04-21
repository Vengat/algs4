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

public class Fast1 {
    
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
            //pts[i].draw();      
        }
        
        for (int i = 0; i < N; i++) {
            //Arrays.sort(pts, i+1, N, pts[i].SLOPE_ORDER);
            //Arrays.sort(pts, pts[i].SLOPE_ORDER);
            //System.out.println("-----------");
            System.out.print(pts[i]);
            //System.out.println("-----------");
        }
        System.out.println("");
        System.out.println("-----------");
        
        for (int i = 0; i < N; i++) {
            //Arrays.sort(pts, i+1, N, pts[i].SLOPE_ORDER);
            System.out.print("i "+i+" pts[i] "+pts[i]);
            System.out.println("");
            Point[] sortedArray = null;
            sortedArray = Arrays.copyOf(pts, N);
            Arrays.sort(sortedArray, sortedArray[i].SLOPE_ORDER);
            System.out.print("i =0 pts[i] after sort "+sortedArray[0]);
            System.out.println("");
            System.out.print("i "+i+" pts[i] after sort "+sortedArray[i]);
            System.out.println("");
            //System.out.println("-----------");
            //for (int j = 0; j < N; j++) {
            //    System.out.print("***"+pts[j]+" ");
            //}            
            //System.out.println("-----------");
        }
        
    }
}
