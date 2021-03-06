public class Subset {
    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        String input = StdIn.readLine();
        String[] segmented = input.split("[\\s]+");

        for (String x: segmented) {
            randomizedQueue.enqueue(x);
        }
                        

        for (int x = 0; x < Integer.parseInt(args[0]); x++) {
            StdOut.println(randomizedQueue.dequeue());
        }
                                
    }
}