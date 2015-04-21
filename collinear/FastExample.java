import java.util.Arrays;
public class FastExample {
    
 public static void main(String[] args)
    {
        int nPoints,x,y,i,j,k,l,cont,m,n=0;
        double value;
        Point [] points;
        Point [] orderedPoints;
        
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        try 
        {
            In in = new In(args[0]);
            nPoints = Integer.parseInt(in.readLine());
            points = new Point[nPoints];
            for(i=0;i<nPoints;i++)
            {
                x=Integer.parseInt(in.readString());
                y=Integer.parseInt(in.readString());
                points[i] = new Point(x,y);
                points[i].draw();
            }

            for(i=1;i<=nPoints-3;i++)
         {
                k=nPoints-i;
                orderedPoints= new Point[k];
                System.arraycopy(points, 0, orderedPoints, 0, k);
                Arrays.sort(orderedPoints,0,k,points[k].SLOPE_ORDER);
                j=0;
                do
                {
                    cont=1;
                    m=j;                    
                    value=points[k].slopeTo(orderedPoints[j++]);
                    while(j<k&&points[k].slopeTo(orderedPoints[j])==value){cont++;n=j;j++;}
                    if(cont>=3)
                    {
                        StdOut.print(points[k].toString()); 
                        for(l=m;l<=n;l++)
                        {
                         StdOut.print(" -> " + orderedPoints[l].toString()); 
       points[k].drawTo(orderedPoints[l]);
                        }
                        StdOut.println();
                    }
                }while(j<k);
            }    
        }
  catch (Exception e) { System.out.println(e); }
   }
}