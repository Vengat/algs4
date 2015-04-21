import java.lang.Integer;
public class BruteExample{
    public static void main(String[] args)
    {
        int nPoints,i,j,k,l,m,x,y,indexes[];
        double []slopes;
        double s;
        Point [] points;
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        try {
            In in = new In(args[0]);
            nPoints = Integer.parseInt(in.readLine());
            points = new Point[nPoints];
            slopes = new double[nPoints];
            for(i=0;i<nPoints;i++)
            {
                x=Integer.parseInt(in.readString());
                y=Integer.parseInt(in.readString());
                points[i] = new Point(x,y);
                points[i].draw();
            }

        indexes=new int[4];
        for(i=0;i<nPoints;i++)
        {
         for(j=i+1;j<nPoints;j++) 
                slopes[j]=points[i].slopeTo(points[j]);
            
            indexes[0]=i;
            for(j=i+1;j<nPoints-2;j++)
            {
                s=slopes[j];
                indexes[1]=j;
                for(k=j+1;k<nPoints-1;k++)
                {
                    if(s==slopes[k])
                    {
                        indexes[2]=k;
                        for(l=k+1;l<nPoints;l++)
                         if(s==slopes[l])
                         {
                                indexes[3]=l;
                             StdOut.println(points[indexes[0]].toString() + " -> "+points[indexes[1]].toString() + " -> "+points[indexes[2]].toString() + " -> "+points[indexes[3]].toString());
                             for(m=1;m<4;m++) points[indexes[0]].drawTo(points[indexes[m]]);
                         }
                    }
                }
            }
            
        }
        
        
  }
        catch (Exception e) { System.out.println(e); }
        
    }
}