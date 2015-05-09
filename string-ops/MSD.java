class MSD {
    
    int R = 256;
  
    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        return -1;
    }
    
    public void msdSort(String[] a) {
        int N = a.length;
        String[] aux = new String[N];
        sort(a, aux, 0, N-1, 1);
    }
    
    /*
     * For the first time all of the strings in the array will be sorted by the first character. This happens by the method call in msdSort method
     * After the first iteration we can lineate arrays with same substrings and sort on their secod character and this process would recurse
     */
    public void sort(String[] a, String[] aux, int lo, int hi, int d) {
        
        if (hi <= lo) return;
        //int R = 256;

        int[] count = new int[R+2]; //We have to accomodate end of string value -1 in addition to key indexed counting's extra space
            
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++; //We have to accomodate end of string value -1 in addition to key indexed counting's extra space
        }
        
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }
        
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        
        for (int r = 0; r < R; r++) {
            sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d+1);
        } 
    }
    
    public static void main(String[] args) {
        String[] s= {"ann", "ant", "abc", "about", "abyss", "aboot", "sea", "seal", "seashell", "seaside", "segue", "sekal", "the", "zeus"};
        new MSD().msdSort(s);
    }
    
    
}