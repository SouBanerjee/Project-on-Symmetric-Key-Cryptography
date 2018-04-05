package thirdByte;

import array.Array_int;

import java.util.Random;

/**
 * Created by ASUS on 19-02-2017.
 */
public class ThirdByteSymmetricKey1
{
    public void generateByteThree(Array_int combine, Array_int keyByte, Array_int rand)
    {
        int j = 0, k = 15, l = 0;
        Random r = new Random();
        for(int i = 0; i < 4; i++)
        {
            rand.arr[i] = (int)r.nextInt(2);
        }
        for(int i = 0; i < 4; i++){
            keyByte.arr[l++] = combine.arr[j++] ^ combine.arr[k--];
        }
        for(int i = 0; i < 4; i++){
            if(i % 2 == 0){
                keyByte.arr[l++] = combine.arr[j++] | combine.arr[k--];
            }else{
                keyByte.arr[l++] = combine.arr[j++] & combine.arr[k--];
            }
        }
        for(int a = 0, b = 0; b < keyByte.arr.length; b += 2, a++)
        {
            keyByte.arr[b] = keyByte.arr[b] ^ rand.arr[a];
        }
    }
}
