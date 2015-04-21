public class Percolation {

    private boolean[][] percolationGrid;
    // create N-by-N grid, with all sites blocked

    //Number of sites
    private int N;

    private WeightedQuickUnionUF quickUnionUF;

    //private int numberOfSites;

    private int numberOfOpenSites = 0;

    private int topVirtualSite, bottomVirtualSite;


    public Percolation(int N) {
        this.N = N;
        quickUnionUF = new WeightedQuickUnionUF((N * N) + 2);
        percolationGrid = new boolean[N][N];
        topVirtualSite = N * N;
        bottomVirtualSite = (N * N) + 1;

        //Connect to the top virtual site. We start from k=1 as 0 is the virtual open site in the quick union find instance
        for (int k = 0; k < N; k++) {
            quickUnionUF.union(topVirtualSite, k);
        }

        //Connect to the bottom virtual site.
        for (int l = (this.topVirtualSite - 1); l > (this.topVirtualSite - (N + 1)); l--) {
            quickUnionUF.union(this.bottomVirtualSite, l);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                percolationGrid[i][j] = false;
            }
        }
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        i = i - 1;
        j = j - 1;
        if (i >= N || i < 0) throw new java.lang.IndexOutOfBoundsException();
        if (j >= N || j < 0) throw new java.lang.IndexOutOfBoundsException();

        if (isOpen(i + 1, j + 1)) return;

        percolationGrid[i][j] = true;

        numberOfOpenSites++;

        if (numberOfOpenSites < 2) return;

        int openedSiteInUFArray = (i * this.N) + j;

        if ((j - 1) >= 0 && (j - 1) < N) {
            if (percolationGrid[i][(j - 1)]) {
                int prevOpenedSiteUFArray = (i * this.N) + (j - 1);
                if (!quickUnionUF.connected(openedSiteInUFArray, prevOpenedSiteUFArray)) {
                    quickUnionUF.union(openedSiteInUFArray, prevOpenedSiteUFArray);  
                }
            }
        }


        if ((j + 1) > 0 && (j + 1) < N) {
            if (percolationGrid[i][(j + 1)]) {
                int prevOpenedSiteUFArray = (i * this.N) + (j + 1);
                if (!quickUnionUF.connected(openedSiteInUFArray, prevOpenedSiteUFArray)) {                    
                    quickUnionUF.union(openedSiteInUFArray, prevOpenedSiteUFArray);
                }
            }
        }


        if ((i - 1) >= 0 && (i - 1) < N) {
            if (percolationGrid[(i - 1)][j]) {
                int prevOpenedSiteUFArray = ((i - 1) * this.N) + j;
                if (!quickUnionUF.connected(openedSiteInUFArray, prevOpenedSiteUFArray)) {
                    quickUnionUF.union(openedSiteInUFArray, prevOpenedSiteUFArray);
                }               
            }
        }

        if ((i + 1) >= 0 && (i + 1) < N) {
            if (percolationGrid[(i + 1)][j]) {
                int prevOpenedSiteUFArray = ((i + 1) * this.N) + j;
                if (!quickUnionUF.connected(openedSiteInUFArray, prevOpenedSiteUFArray)) {
                    quickUnionUF.union(openedSiteInUFArray, prevOpenedSiteUFArray);
                }
            }
        }

    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        int m = i - 1;
        int n = j - 1;
        if (m >= N || m < 0) throw new java.lang.IndexOutOfBoundsException();
        if (n >= N || n < 0) throw new java.lang.IndexOutOfBoundsException();
        return percolationGrid[m][n];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        int m = i - 1;
        int n = j - 1;
        if (m >= N || m < 0) throw new java.lang.IndexOutOfBoundsException();
        if (n >= N || n < 0) throw new java.lang.IndexOutOfBoundsException();
        if (quickUnionUF.connected(topVirtualSite, ((m * this.N) + n)) && isOpen((m+1), (n+1))) return true;
        return false;
    }

    // does the system percolate?
    public boolean percolates() {
        return quickUnionUF.connected(topVirtualSite, bottomVirtualSite);
    }
}
