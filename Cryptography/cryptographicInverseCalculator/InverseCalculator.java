package cryptographicInverseCalculator;

/**
 * Created by ASUS on 08-03-2017.
 */
public class InverseCalculator
{
    public int multiplicativeInverse(int n, int b)
    {
        int r1 = n, r2 = b;
        int t1 = 0, t2 = 1;
        int q = 0, r = 0, t = 0;
        while(r2 > 0)
        {
            q = r1 / r2;
            r = r1 - q * r2;
            r1 = r2;
            r2 = r;
            t = t1 - q * t2;
            t1 = t2;
            t2 = t;
        }
        if(r1 != 1)
        {
            if(b == 0)
                return 0;
            else
            {
                System.out.println("\nSoumya something happend wrong, take necessary steps");
                System.out.println("\nN : "+n+"\tB : "+b+"\n");
                return -1;
            }
        }
        else
        {
            if(t1 < 0)
                return (n + t1);
            else
                return t1;
        }
    }
}
