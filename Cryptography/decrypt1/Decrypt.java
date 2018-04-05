package decrypt1;

import array.Array_int;
import array.Array_int_2d;
import binary_decimal_conversion.Binary_decimal;
import cryptographicInverseCalculator.InverseCalculator;
import decryptTimeMatrixHandler.MatrixHandler;
import transposition.DataTranspositionHandler;

/**
 * Created by ASUS on 09-03-2017.
 */
public class Decrypt
{
    public void decrypt(Array_int one, Array_int two, Array_int keyByte, Array_int combine, Array_int input,
                        Binary_decimal o1, InverseCalculator o2, DataTranspositionHandler o3, MatrixHandler o4,
                        Array_int_2d spiral, Array_int_2d newSpiral)
    {
        reverseSquareRoot(input);
        //System.out.println("\nCipher after reverse square root : "+input.arr[0]);
        input.arr[0] = input.arr[0] ^ input.arr[6];
        o1.decimal_to_binary(two, 0, 7, input.arr[6]);
        twosComplement(two, 0, 7);
        input.arr[7] = o1.binary_to_decimal(two, 0, 7);
        input.arr[0] = input.arr[0] ^ input.arr[4]; input.arr[7] = input.arr[7] ^ input.arr[5];
        input.arr[0] = o2.multiplicativeInverse(257, input.arr[0]);
        input.arr[7] = o2.multiplicativeInverse(257, input.arr[7]);
        input.arr[0] = input.arr[0] ^ input.arr[2]; input.arr[7] = input.arr[7] ^ input.arr[3];
        o1.decimal_to_binary(one, 0, 7, input.arr[0]);
        o1.decimal_to_binary(two, 0, 7, input.arr[7]);
        o3.transpositionHandler(input.arr[1], input.arr[2], one, two);
        o4.matrixGeneratorFromDataByte(one, two, spiral);
        o1.decimal_to_binary(keyByte, 0, 7, input.arr[1]);
        o4.spiralMatrixRegenerator(spiral, newSpiral, keyByte, o1);
        o4.combineBlockFromSpiralMatrix(combine, newSpiral);
        input.arr[0] = 255 - o1.binary_to_decimal(combine, 0, 7);
        input.arr[7] = o1.binary_to_decimal(combine, 8, 15);
    }

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

    public void reverseSquareRoot(Array_int input)
    {
        //System.out.println("\nElement : "+input.arr[0]);
        //System.out.println("\nSymmtric 7 : "+input.arr[7]);
        int E = input.arr[0] - (int)Math.pow(input.arr[7], 2) + (int)Math.pow((int)input.arr[7] / 2, 2);
        input.arr[0] = (int)Math.pow(input.arr[7], 2) - E;
    }
}
