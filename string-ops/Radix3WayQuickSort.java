class Radix3WayQuickSort {
    
     private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        return -1;
    }
    
    public void quickSort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }
    
    public void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) return;
        int lt = lo;
        int gt = hi;
        
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) {
                String tmp = a[lo];
                a[lo] = a[i];
                a[i] = tmp;
                lt++;
                i++;
            } else if (t > v) {
                String tmp = a[hi];
                a[hi] = a[i];
                a[i] = tmp;
                gt--;
            } else {
                i++;
            }
        }
        
        sort(a, lo, lt-1, d);
        if (v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, hi, d);
        
        System.out.println("******************");
        for (int k = 0; k < a.length; k++) {
            System.out.println(a[k]);
        }
        System.out.println("******************");
    }
    
    public static void main(String[] args) {
        String[] a= {"ann", "ant", "abc", "about", "abyss", "aboot", "sea", "seal", "seashell", "seaside", "segue", "sekal", "the", "zeus"};
        new Radix3WayQuickSort().quickSort(a);
    }
    
}