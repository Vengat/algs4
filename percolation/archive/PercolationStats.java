public class PercolationStats {

    private int N;

    private int T;

    //private double percent95;

    private double sumOfOpenSitesInAllT = 0;

    private double[] resultsOfTestsT;

    private Percolation percolation;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0) throw new java.lang.IllegalArgumentException("Grid size needs to be greater than 0");
        if (T <= 0) throw new java.lang.IllegalArgumentException("Number of tests need to be greater than 0");
        this.N = N;
        this.T = T;
        int i, j;
        int numberOfOpenSites = 0;

        resultsOfTestsT = new double[T];

        for (int l = 0; l < this.T; l++) {
            percolation = new Percolation(this.N);
            while (!percolation.percolates()) {
                do {
                    i = StdRandom.uniform(1, N + 1);
                    j = StdRandom.uniform(1, N + 1);
                } while (percolation.isOpen(i, j));
                percolation.open(i, j);
            }
            //System.out.println("Percolation finished for "+T+" test");
            numberOfOpenSites++;
            resultsOfTestsT[l] = (double) numberOfOpenSites / (N * N);
            sumOfOpenSitesInAllT = sumOfOpenSitesInAllT + (double) numberOfOpenSites;
        }


    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(resultsOfTestsT);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(resultsOfTestsT);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt((double) T));
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt((double) T));
    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(N, T);

        System.out.println("mean         =" + percolationStats.mean());
        System.out.println("stdev        =" + percolationStats.stddev());
        System.out.print("95% Confidence level " + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi());

    }// test client, described below
}