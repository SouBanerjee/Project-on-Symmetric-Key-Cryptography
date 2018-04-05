package test;

import random.Random_;
import array.Array_int;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array_int rand1=new Array_int(4),rand2=new Array_int(4),random=new Array_int(8);
		Random_ ob=new Random_();
		for(int i=0;i<4;i++)
		{
			ob.random_sequence(rand1, rand2, random);
			System.out.println("\n");
			for(int j=0;j<8;j++)
				System.out.print(" "+random.arr[j]+" ");
			System.out.println();
		}
	}

}
