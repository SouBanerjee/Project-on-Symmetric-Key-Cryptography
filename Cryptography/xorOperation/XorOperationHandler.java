package xorOperation;

import array.Array_int;
import array.Array_int_2d;
import bitWiseOperation.BitWiseOperationHandler;

/**
 * Created by ASUS on 19-02-2017.
 */
public class XorOperationHandler
{
    public void xorRowWise(Array_int_2d newSpiral, Array_int keyByte, int lb, int ub,
                           Array_int xorHandler, BitWiseOperationHandler o1)
    {
        int k = 0, l = lb;
        for(int i = 0; i < 4; i++){
            if(i == 0){
                for(int j = 0; j < 4; j++){
                    keyByte.arr[l++] = newSpiral.arr[i][j];
                }
            }else{
                k=0;
                for(int j = 0; j < 4; j++){
                    xorHandler.arr[k++] = newSpiral.arr[i][j];
                }
                o1.bitWiseXorHandler(keyByte, lb, ub, xorHandler, 0, 3);
                /*a=d1.binary_to_decimal(result);
                b=d1.binary_to_decimal(temp);
                a=(a^b);
                result=d2.decimal_to_binary(a, 4, 0);//(a);*/
            }
        }
    }

    public void xorColumnWise(Array_int_2d newSpiral, Array_int keyByte, int lb, int ub,
                              Array_int xorHandler, BitWiseOperationHandler o1)
    {
        int k = 0, l = lb;
        for(int i = 0; i < 4; i++){
            if(i == 0){
                for(int j = 3; j >= 0; j--){
                    keyByte.arr[l++]=newSpiral.arr[j][i];
                }
            }else{
                k=0;
                for(int j = 3; j >= 0; j--){
                    xorHandler.arr[k++] = newSpiral.arr[j][i];
                }
                o1.bitWiseXorHandler(keyByte, lb, ub, xorHandler, 0, 3);
                /*a=d2.binary_to_decimal(result);
                b=d2.binary_to_decimal(temp);
                a=(a^b);
                result=d1.decimal_to_binary(a, 4, 0);//(a);*/
            }
        }
        //return result;
    }
}
