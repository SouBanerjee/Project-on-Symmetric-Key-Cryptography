package decryptTimeMatrixHandler;

import array.Array_int;
import array.Array_int_2d;
import binary_decimal_conversion.Binary_decimal;

/**
 * Created by ASUS on 09-03-2017.
 */
public class MatrixHandler
{
    public void combineBlockFromSpiralMatrix(Array_int combine, Array_int_2d spiral)
    {
        int n = 4, a = n / 2, b = a - 1, k = combine.arr.length - 1;
        int i = 0, j = 0, temp = 0, t2 = 0;
        do
        {
            while(j <= n - 1)
            {
                combine.arr[k--] = spiral.arr[i][j];
                j++;
            }
            j--; i++;
            while(i <= n - 1)
            {
                combine.arr[k--] = spiral.arr[i][j];
                i++;
            }
            i--; j--;
            while(j >= t2)
            {
                combine.arr[k--] = spiral.arr[i][j];
                j--;
            }
            j++; i--;
            while(i>temp)
            {
                combine.arr[k--] = spiral.arr[i][j];
                i--;
            }
            i++;
            if(i == a && j == b)
                break;
            i = temp + 1; temp++; j++; t2=j; n--;
        }while(true);
    }

    public void matrixGeneratorFromDataByte(Array_int one, Array_int two, Array_int_2d spiral)
    {
        int k = 0;
        /**
         * First row and last row from left to right
         */
        for(int i = 0; i <= 4; i += 3){
            for(int j = 0; j < 4; j++){
                spiral.arr[i][j] = one.arr[k++];
            }
        }
        k=0;
        /**
         * Third and second row from right to left
         */
        for(int i = 2; i >= 1; i--){
            for(int j = 3; j >= 0; j--){
                spiral.arr[i][j] = two.arr[k++];
            }
        }
    }

    public void spiralMatrixRegenerator(Array_int_2d spiral, Array_int_2d newSpiral,
                                        Array_int keyByte, Binary_decimal ob)
    {
        for(int i = 0; i < (keyByte.arr.length / 2); i++)
        {
            int var = ob.binary_to_decimal(keyByte, 2 * i, 2 * i + 1);
            int j, l, m, u, v, t, t2;
            if(var % 2 != 0){
                j = var - 1; l = var;
                t2 = var % 2 + 1; m = 3;
            }else{
                j = var; l = var + 1;
                t2 = var % 2; m = 1;
            }
            if(i % 2 != 0){
                t = u = 2;
            }else{
                t = u = 0;
            }
            if(i <= 1){
                v = 0;
            }else{
                v = 2;
            }
            for(; j <= l; j++){
                for(int k = t2; k <= m; k++){
                    newSpiral.arr[j][k] = spiral.arr[v][u];
                    u++;
                }
                v++;
                u = t;
            }
        }
    }
}
