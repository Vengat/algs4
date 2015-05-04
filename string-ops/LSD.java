public class LSD {
    
    public String[] lsdSort(String[] a, int lengthOfString) {
        //String s= "Hello";
        //System.out.println(s.length() + s.charAt(4));
        int R = 256;
        int N = a.length;
        String[] aux = new String[N];
        
        for (int d = lengthOfString-1; d >= 0; d--) {
            int[] count = new int[R+1];
            
            for (int i=0; i<N; i++) {
                count[a[i].charAt(d)+1]++;
            }
            
            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }
            
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
            System.out.println("-----------");
            System.out.println("d = "+d);
            for (int i=0; i<a.length;i++) {
                System.out.println(a[i]);
            }
            System.out.println("-----------");
       }
        return a;
    }  
    
    public static void main (String[] args) {
        //int i =5;
        //System.out.println(i++);
        //System.out.println(i++);
        
        String[] a = {"abd", "zds", "tys", "tac", "ere"};
        
        LSD lsd = new LSD();
        
        String[] b = lsd.lsdSort(a, 3);
        
        for (int i=0; i<b.length; i++) {
            System.out.println(b[i]);
        }
    }

   
}