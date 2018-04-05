package bitWiseOperation;

import array.Array_int;

/**
 * Created by ASUS on 19-02-2017.
 */
public class BitWiseOperationHandler
{
    public void bitWiseXorHandler(Array_int keyByte, int keylb, int keyub,
                                  Array_int xorHandler, int xorlb, int xorub)
    {
        for(int i = keylb, j = xorlb; i <= keyub && j <= xorub; i++, j++)
        {
            keyByte.arr[i] = keyByte.arr[i] ^ xorHandler.arr[j];
        }
    }
}
