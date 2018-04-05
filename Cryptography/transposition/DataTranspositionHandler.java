package transposition;

import array.Array_int;

/**
 * Created by ASUS on 22-02-2017.
 */
public class DataTranspositionHandler
{
    /**
     * This function performs data transposition operation between first data byte and second data byte of
     * partially encrypted plain text
     * @param keyByteOne is the first data byte of the symmetric key
     * @param keyByteTwo is the second data byte of the symmetric key
     * @param one is first data byte of the partially encrypted plain text
     * @param two is second data byte of the partially encrypted plain text
     */
    public void transpositionHandler(int keyByteOne, int keyByteTwo, Array_int one, Array_int two)
    {
        if((keyByteOne ^ keyByteTwo) % 2 != 0 )
        {
            evenOneOddTwo(one, two);
        }
        else
        {
            oddOneEvenTwo(one, two);
        }
        /*System.out.println("\nAfter transposition operation\nsuch that even - odd or odd - even");
        System.out.println("\nDataByte one\n");
        for(int i = 0; i < one.arr.length; i++)
        {
            System.out.print(one.arr[i]+"  ");
        }
        System.out.println("\nDataByte two\n");
        for(int i = 0; i < two.arr.length; i++)
        {
            System.out.print(two.arr[i]+"  ");
        }
        System.out.println();*/
    }

    public void oddOneEvenTwo(Array_int one, Array_int two)
    {
        int temp;
        for(int i = 6; i >= 0; i -= 2){
            temp = two.arr[i];
            two.arr[i] = one.arr[i + 1];
            one.arr[i + 1] = temp;
        }
    }

    public void evenOneOddTwo(Array_int one, Array_int two)
    {
        int temp;
        for(int i = 7; i >= 1; i -= 2)
        {
            temp = one.arr[i];
            one.arr[i] = two.arr[i - 1];
            two.arr[i - 1] = temp;
        }
    }
}
