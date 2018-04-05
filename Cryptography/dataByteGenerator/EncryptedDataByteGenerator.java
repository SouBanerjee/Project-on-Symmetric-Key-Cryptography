package dataByteGenerator;

import array.Array_int;
import array.Array_int_2d;

/**
 * Created by ASUS on 19-02-2017.
 */
public class EncryptedDataByteGenerator
{
    public void extractionOfDataBytesFromMatrix(Array_int_2d newSpiral, Array_int one,
                                                Array_int two)
    {
        int k = 0;
        /**
         * First row and last row from left to right
         */
        for(int i = 0; i <= 4; i += 3){
            for(int j = 0; j < 4; j++){
                one.arr[k++] = newSpiral.arr[i][j];
            }
        }
        k=0;
        /**
         * Third and second row from right to left
         */
        for(int i = 2; i >= 1; i--){
            for(int j = 3; j >= 0; j--){
                two.arr[k++] = newSpiral.arr[i][j];
            }
        }
        /*System.out.println("\nDataByte one\n");
        for(int i = 0; i < one.arr.length; i++)
        {
            System.out.print(one.arr[i]+"  ");
        }
        System.out.println("\nDataByte two\n");
        for(int i = 0; i < two.arr.length; i++)
        {
            System.out.print(two.arr[i]+"  ");
        }*/
    }
}
