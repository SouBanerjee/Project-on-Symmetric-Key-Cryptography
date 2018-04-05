package random;

import java.util.Random;

import binary_decimal_conversion.Binary_decimal;

import array.Array_int;

/**
 * This class is used to generate random sequence used for shuffling the initial
 * spiral matrix
 */
public class Random_ {

	/**
	 * This function genarates the random sequence in binary format to shuffle the initial spiral matrix
	 * @param rand1 this is a one dimentional array which is used as an auxiliary array
	 *              to generate the random sequence
	 * @param rand2 this is a one dimentional array which contains the generated random sequence
	 *              in decimal format
	 * @param random this is a one dimentional array which contains the genearted random
	 *               sequence in binary format
	 */
	public void random_sequence(Array_int rand1, Array_int rand2, Array_int random)
	{
		for(int i = 0; i < 4; i++)
			rand1.arr[i] = i;
		int m = 4, k;
		Random rand = new Random();
		for(int i = 0; i < 4; i++)
		{
			k = (int)rand.nextInt(m);
			rand2.arr[i] = rand1.arr[k];
			for(int j = k; j < m-1; j++){
				rand1.arr[j] = rand1.arr[j+1];
			}
			m--;
		}
		Binary_decimal ob1 = new Binary_decimal();
		for(int i = 0; i < 4; i++)
			ob1.decimal_to_binary(random, 2*i, 2*i+1, rand2.arr[i]);
	}
	
}
