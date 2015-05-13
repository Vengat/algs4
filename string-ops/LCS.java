

class LCS {
    
    public String[] convertString(String x) {
        String[] a = new String[x.length()];
        for (int i = 0; i < x.length(); i++) {
            a[i] = x.substring(i, i+1);
        }
        return a;
    }
    
    public LCSTables lcsLength(String w, String x) {
        String[] a = convertString(w);
        String[] b = convertString(x);
        int[][] c = new int[a.length][b.length];
        String[][] d = new String[a.length][b.length];
        
        for (int i = 1; i < a.length; i++) {
            c[i][0] = 0;
        }
        
        for (int j = 0; j < b.length; j++) {
            c[0][j] = 0;
        }
        
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if(a[i-1].equals(b[j-1])) {
                    c[i][j] = 1 + c[i-1][j-1];
                    d[i][j] = "\\";
                } else if(c[i-1][j] >= c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                    d[i][j] = "|";
                } else {
                    c[i][j] = c[i][j-1];
                    d[i][j] = "<-";
                }
            }
        }
        
        return new LCSTables(c, d);           
    }
    
    public void printLCS(LCSTables t, String[] w, int i, int j) {
        if (i == 0) return;
        if (j == 0) return;

        if (t.b[i][j].equals("\\")) {
            printLCS(t, w, i-1, j-1);
            System.out.print(w[i]);
        } else if (t.b[i][j].equals("|")) {
            printLCS(t, w, i-1, j);
        } else {
            printLCS(t, w, i, j-1);
        } 
    }
    
    public static void main(String[] args) {
        
        LCS lcs = new LCS();
        String w = "ABCBDAB";
        String x = "BDCABA";
        LCSTables lcsTables = lcs.lcsLength(w, x);
        lcs.printLCS(lcsTables, lcs.convertString(w), lcs.convertString(w).length-1, lcs.convertString(x).length-1);
    }
}