package encrypt1;

import bitWiseOperation.BitWiseOperationHandler;
import cryptographicInverseCalculator.InverseCalculator;
import dataByteGenerator.EncryptedDataByteGenerator;
import encryptionModule.CipherCreatorModule;
import random.Random_;
import spiral.Matrix_operations;
import binary_decimal_conversion.Binary_decimal;
import array.Array_int;
import array.Array_int_2d;
import thirdByte.ThirdByteSymmetricKey1;
import transposition.DataTranspositionHandler;
import xorOperation.XorOperationHandler;

import java.util.Vector;

public class Encrypt {
	
	public void encryption(int a, int b, Array_int combine1, Array_int combine2, Array_int rand1, Array_int rand2,
						   Array_int keyByte1, Array_int keyByte2, Array_int xorHandler, Array_int one, Array_int two,
						   Array_int symmetricKey, Array_int_2d spiral, Array_int_2d newSpiral, Binary_decimal o1,
						   Matrix_operations o2, Random_ o3, XorOperationHandler o4, BitWiseOperationHandler o5,
						   ThirdByteSymmetricKey1 o6, EncryptedDataByteGenerator o7, DataTranspositionHandler o8,
						   CipherCreatorModule o9, InverseCalculator o10, Vector<Integer> v)
	{
		o1.decimal_to_binary(combine1, 0, 7, a); o1.decimal_to_binary(combine1, 8, 15, b);
		o2.matrix_create(combine1, spiral); o3.random_sequence(rand1, rand2, keyByte1);
		//check 1 complete
		int k = 0;
		symmetricKey.arr[k++] = o1.binary_to_decimal(keyByte1, 0, 7);//1st byte of symmetric key
		//System.out.println("\nSymmetric 1 : "+symmetricKey.arr[k - 1]);
		//System.out.println("\nCheck 1\n");
		o2.new_matrix_(spiral, newSpiral, keyByte1);
		//check 2 complete
		o4.xorRowWise(newSpiral, keyByte1, 0, 3, xorHandler, o5);
		o4.xorColumnWise(newSpiral, keyByte1, 4, 7, xorHandler, o5);
		symmetricKey.arr[k++] = o1.binary_to_decimal(keyByte1, 0, 7);//second byte of symmetric key
		//System.out.println("\nSymmetric 2 : "+symmetricKey.arr[k - 1]);
		//System.out.println("\nCheck 2\n");
		o6.generateByteThree(combine1, keyByte2, rand1);
		symmetricKey.arr[k++] = o1.binary_to_decimal(keyByte2, 0, 7);//third byte of symmetric key
		//System.out.println("\nSymmetric 3 : "+symmetricKey.arr[k - 1]);
		//System.out.println("\nCheck 3\n");
		o7.extractionOfDataBytesFromMatrix(newSpiral, one, two);
		//System.out.println("\nCheck 4\n");
		//for(int i = 0; i < k; i++)
			//System.out.println(symmetricKey.arr[i]);
		//System.out.println();
		o8.transpositionHandler(symmetricKey.arr[0], symmetricKey.arr[1], one, two);
		//o1.decimal_to_binary(keyByte1, 0, 7, symmetricKey.arr[0]);
		o9.stageOne(keyByte1, keyByte2, one, two, o5);
		o9.stageTwo(one, two, symmetricKey, k, o10, v, o1, combine1, combine2, o5);
	}
	
}