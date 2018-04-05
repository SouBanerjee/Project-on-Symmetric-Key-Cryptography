package decrypt1;

/**
 * Created by ASUS on 09-03-2017.
 */
public class Main
{
    public static void main(String []args) throws Exception
    {
        Init ob = new Init();
        final long start = ob.take_input();
        final long end = System.currentTimeMillis();
        System.out.println("\nDecryption time : "+(end - start)+" msec\n");
    }
}
