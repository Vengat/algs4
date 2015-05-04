public class KeyIndexedCounting {
    
    int[] count;
    int N;
    int[] myArray;
    int[] aux;
    int[] R;
    public KeyIndexedCounting(int[] R, int[] myArray) {
        this.count = new int[R.length+1];
        this.N = myArray.length;
        this.myArray = myArray;
        aux = new int[N];
        this.R = R;
    }
    
    public int[] sortedArray() {
        //a=0 b=1 c=2 d=3 e=4 f=5
        //egs a,a,b,c,c,d, e, f,f,f,f
        //we will end up with count = {0, 2, 1, 2, 1, 1, 4} Frquencies of each letter
        //First/0 th index is not populated. We start from the I st index 
        for (int i = 0; i < this.myArray.length; i++) {
            count[myArray[i]+1]++;
        }
        
        //Make a cumulus of the values 0 2 3 5 6 7 11
        // 2 letters less tha, b, 3 letters less than c etc
        for (int r = 0 ; r < R.length; r++) {
            count[r+1] = count[r+1] + count[r];    
        }
        
        //Now we have to sort according to the frequency distribution in the count array
        //count = {0, 2, 3, 5, 6, 7, 11} From the above array we know that there are 2 chars lesser than b so b starts from 2
        //3 numbers less than c so c starts from 3 5 numbers less than d, so d starts from 5th index
        //Now we have the myArray with the chars and count array with frequency
        //for egs count[1] = 2 ...so aux[0] and aux[1] will have a in them and aux[2] will have b
        //
        for (int k = 0; k < myArray.length; k++) {
            aux[count[myArray[k]]++] = myArray[k];
        }
        
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = aux[i];
        }
        return myArray;
    }
   
}               