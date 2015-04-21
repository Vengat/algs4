

public class Example
{
    public void testNestedForContinue()
    {
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (j == 3) continue;
                for (int k = 0; k < 10; k++)
                {
                    System.out.println(i+", "+j+", "+k);
                }               
            }
        }
    }
   
    
    public static void main(String[] args)
    {
        new Example().testNestedForContinue();
    }
}