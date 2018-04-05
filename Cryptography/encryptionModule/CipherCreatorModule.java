package encryptionModule;

import array.Array_int;
import binary_decimal_conversion.Binary_decimal;
import bitWiseOperation.BitWiseOperationHandler;
import cryptographicInverseCalculator.InverseCalculator;

//import java.util.Map;
import java.util.Vector;

/**
 * Created by ASUS on 08-03-2017.
 */
public class CipherCreatorModule
{
    public void stageOne(Array_int keyByte1, Array_int keyByte2, Array_int one, Array_int two,
                         BitWiseOperationHandler ob)
    {
        ob.bitWiseXorHandler(one, 0, one.arr.length - 1,
                keyByte1, 0, keyByte1.arr.length - 1);
        ob.bitWiseXorHandler(two, 0, two.arr.length - 1,
                keyByte2, 0, keyByte2.arr.length - 1);
        Binary_decimal o = new Binary_decimal();
        //System.out.println("\nDataByte one after XOR with symmetric key two : "+o.binary_to_decimal(one, 0, 7)+"\n");
        //System.out.println("\nDataByte two after XOR with symmetric key three : "+o.binary_to_decimal(two, 0, 7)+"\n");
    }

    public void stageTwo(Array_int one, Array_int two, Array_int symmetricKey, int keyIndex,
                         InverseCalculator ob1, Vector<Integer> v, Binary_decimal ob2,
                         Array_int combine1, Array_int combine2, BitWiseOperationHandler ob3)
    {
        int x, y1;
        int oneEquivalent = x = ob2.binary_to_decimal(one, 0, 7),
                twoEquivalent = y1 = ob2.binary_to_decimal(two, 0, 7);
        //System.out.println("\nDataByte one : "+oneEquivalent+"\nDataByte two : "+twoEquivalent+"\n");
        oneEquivalent = ob1.multiplicativeInverse(257, oneEquivalent);
        twoEquivalent = ob1.multiplicativeInverse(257, twoEquivalent);
        //System.out.println("\nMultiplicative Inverse of "+x+" : "+oneEquivalent);
        //System.out.println("\nMultiplicative Inverse of "+y1+" : "+twoEquivalent+"\n");
        ob2.decimal_to_binary(combine1, 0, 7, oneEquivalent);
        ob2.decimal_to_binary(combine1, 8, 15, twoEquivalent);
        //System.out.println("\nTotal number of primes : "+v.size()+"\n");
        int y = ob2.binary_to_decimal(combine1, 0, 15) % v.size();
        y = (int)v.get(y);
        ob2.decimal_to_binary(combine2, 0, 15, y);//leftmost 8 bits are known as M and rightmost 8 bits are known as N
        ob3.bitWiseXorHandler(combine1, 0, 7, combine2, 8, 15);//U
        ob3.bitWiseXorHandler(combine1, 8, 15,combine2, 0, 7);//V
        symmetricKey.arr[keyIndex++] = ob2.binary_to_decimal(combine2, 8, 15);//4th byte of symmetric key
        //System.out.println("\nSymmetric 4 : "+symmetricKey.arr[keyIndex - 1]);
        symmetricKey.arr[keyIndex++] = ob2.binary_to_decimal(combine2, 0, 7);//5th byte of symmetric key
        //System.out.println("\nSymmetric 5 : "+symmetricKey.arr[keyIndex - 1]);
        //System.out.println("\nBefore 2's Complement : "+ob2.binary_to_decimal(combine1, 8, 15)+"\n");
        twosComplement(combine1, 8, 15);
        //System.out.println("\nAfter 2's Complement : "+ob2.binary_to_decimal(combine1, 8, 15)+"\n");
        ob3.bitWiseXorHandler(combine1, 0, 7, combine1, 8, 15);
        symmetricKey.arr[keyIndex++] = ob2.binary_to_decimal(combine1, 8, 15);
        //System.out.println("\nSymmetric 6 : "+symmetricKey.arr[keyIndex - 1]);
        //copy(one, 0, 7, combine1, 0, 7);
        manyToOne(ob2.binary_to_decimal(combine1, 0, 7),symmetricKey, keyIndex);
    }

    /*public void copy(Array_int one, int olb, int oub, Array_int combine, int clb, int cub)
    {
        for(int i = olb, j = clb; i <= oub && j <= cub; i++, j++)
        {
            one.arr[i] = combine.arr[j];
        }
    }*/

    public void twosComplement(Array_int v, int lb, int ub)
    {
        for(int i = lb; i <= ub; i++)
        {
            if(v.arr[i] == 0)
                v.arr[i] = 1;
            else
                v.arr[i] = 0;
        }
        int carry = 1;
        for(int i = ub; i >= lb; i--)
        {
            if(v.arr[i] == 1)
            {
                if(carry == 1)
                    v.arr[i] = 0;
                else
                    break;
            }
            else
            {
                if(carry == 1)
                    v.arr[i] = 1;
                break;
            }
        }
    }

    public int squareRoot(int n)
    {
        double x = Math.sqrt(n);
        int y = (int)x;
        if(x - (double)y > 0)
            return (y + 1);
        else
            return y;
    }

    public void manyToOne(int t, Array_int symmetricKey, int keyIndex)
    {
        int y = squareRoot(t);
        symmetricKey.arr[keyIndex++] = y;
        //System.out.println("\nSymmetric 7 : "+symmetricKey.arr[keyIndex - 1]+"\n");
        int x = y*y - t;
        symmetricKey.arr[keyIndex] = y*y - (int) Math.pow((int)(y/2), 2) + x;
        //System.out.println("\nCipher : "+symmetricKey.arr[keyIndex]+"\n");
    }
}
