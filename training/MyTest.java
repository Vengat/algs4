public class MyTest {
    
    private  int[] whiteSpaces;
    
    public void printWhitSpaces() {  
        System.out.println("Printing the array----");
        for (int i=0; i<whiteSpaces.length; i++) {
            System.out.print(whiteSpaces[i]);
        }
        System.out.println("Printing the array----");
    }

    
    public String printByRule(String input) {
        int myStringLength = input.length();
        String[] myWords = input.split("\\s+");
        StringBuffer sbf = new StringBuffer();
        char[] myCharArray = input.toCharArray();
        
        this.whiteSpaces = getWhiteSpaceDetails(myCharArray);
  
        //printWhitSpaces();
        if(whiteSpaces[0] > 0) sbf.append(insertSpace());
        //printWhitSpaces();
        for(int i=0; i<myWords.length; i++) {
            if (myWords[i].isEmpty()) continue;
            if((i % 2) == 0) {
                sbf.append(myWords[i].toUpperCase());
                sbf.append(insertSpace());
                //printWhitSpaces();
            } else {
                sbf.append(new StringBuffer(myWords[i]).reverse().toString());
                sbf.append(insertSpace());
                //printWhitSpaces();
            }
        }
        //printWhitSpaces();
        sbf.append(insertSpace());
        //printWhitSpaces();
        //System.out.println("&"+sbf.toString()+"&");
        return sbf.toString();
    }
    
    public String insertSpace() {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < this.whiteSpaces.length; i++) {
            if (this.whiteSpaces[i] > 0) {
                for (int j = 0; j < this.whiteSpaces[i]; j++) {
                    sbf.append(" ");
                }
                this.whiteSpaces[i] = 0;
                break;
            }          
        }
        return sbf.toString();
    }
    
    public int[] getWhiteSpaceDetails(char[] myCharArray) {
        int[] whiteSpaces = new int[myCharArray.length];
        int count = 0;
        int startIndex = 0;
        for(int i=0; i<myCharArray.length; i++) {
            int j = 0;
            if(myCharArray[i] == ' ') {
                count++;
                //startIndex = i;
            } else {
                whiteSpaces[startIndex] = count;
                count = 0;
                startIndex = i;
            }
            if (count == 1) startIndex = i;
        }
        whiteSpaces[startIndex] = count;
        return whiteSpaces;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(new MyTest().printByRule("    this  is a test    ")); //      siht IS a    TEST
        //System.out.println(new MyTest().printByRule("    India is my country ok ok     .All    Indians           "));
        System.out.println(new MyTest().printByRule("tHis Ramar test    world. Bangalore is     a great      place "));
        //System.out.println(new MyTest().printByRule("At the start of each day, we all have to waste a good amount of time just filtering out spam. Tomorrow, this process might take even longer than usual, because there is a pretty good chance that the Telecom Regulatory Authority of India (Trai) just published your email address along with your name."));
   }
}
