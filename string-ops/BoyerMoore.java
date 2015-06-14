//VengatRamananRamar

//Ramar

//RamanVengatRamar in this case we need to shift completely to V

//RamarVengat 
//Ramar  

//skip m=2, a=1, r=5

class BoyerMoore {
    
    private int R = 256;
    private int right[]= new int[R];
    private int M, N;
    private String pattern;
    private String text;
    
    public BoyerMoore(String pattern, String text) {
        this.text = text;
        this.pattern = pattern;
        M = pattern.length();
        N = text.length();
       // computeShiftTable();
    }
    
    public void computeShiftTable() {
        
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }
        
        for (int j = 0; j < M; j++) {
            System.out.println(pattern.charAt(j));
            right[pattern.charAt(j)] = j;
        }
    }

    public int search() {
        int skip;
        for (int i = 0; i <= N-M; i = i+skip) {
            skip = 0;
            for (int j = M-1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i+j)) {
                    skip = Math.max(1, j - right[text.charAt(i+j)]);
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return N;
    }
    
    
    public static void main(String[] args) {
        BoyerMoore bm = new BoyerMoore("ramar", "vengatramarramananramar");
        bm.computeShiftTable();
        int x = bm.search();
        System.out.println(x);
    }
    
}