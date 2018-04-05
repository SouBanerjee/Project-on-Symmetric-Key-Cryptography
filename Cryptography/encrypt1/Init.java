package encrypt1;

import java.io.*;
import java.util.Vector;

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

public class Init {

	/**
	 * pl is of type String and it stores plain text file name
	 * ci is of type String and it stores cipher text file name
	 * sym is of type String and it stores symmetric key file name
	 */
	private String pl, ci, sym;
	private int index;

	/**
	 * This function takes plain text file name from the user and this plain text file name
	 * is also used to generate cipher text file as well as symmetric key file name
	 */
	public long take_input()
	{
		try(BufferedReader r = new BufferedReader(new InputStreamReader(System.in))){
			System.out.print("\nEnter name of plain text file - ");
			pl = r.readLine();
		}catch(IOException e){
			System.out.println("\nUnable to read plain text file name");
			System.exit(-1);
		}
		//System.out.println("\nPlain text - "+pl);
		String s = copy_name();
		ci = s + "_cipher.txt";
		sym = s + "_sym.txt";
		file_create();
		return file_operation();
	}

	public boolean isPrime(int n)
	{
		if(n < 2)
			return false;
		for(int i = 2; i < n; i++)
		{
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	public long file_operation()
	{
		final long start = System.currentTimeMillis();
		int a = -1, b = -1;
		Array_int combine1 = new Array_int(16), rand1 = new Array_int(4), rand2 = new Array_int(4),
				keyByte1 = new Array_int(8), one = new Array_int(8), two = new Array_int(8),
				symmetricKey = new Array_int(8), xorHandler = new Array_int(4),
				keyByte2 = new Array_int(8), combine2 = new Array_int(16);
		Array_int_2d spiral = new Array_int_2d(4), newSpiral = new Array_int_2d(4);
		//File fp1 = new File(pl), fp2 = new File(ci), fp3 = new File(sym1);
		Encrypt ob1 = new Encrypt(); Binary_decimal ob2 = new Binary_decimal();
		Matrix_operations ob3 = new Matrix_operations(); Random_ ob4 = new Random_();
		XorOperationHandler ob5 = new XorOperationHandler();
		BitWiseOperationHandler ob6 = new BitWiseOperationHandler();
		ThirdByteSymmetricKey1 ob7 = new ThirdByteSymmetricKey1();
		EncryptedDataByteGenerator ob8 = new EncryptedDataByteGenerator();
		DataTranspositionHandler ob9 = new DataTranspositionHandler();
		CipherCreatorModule ob10 = new CipherCreatorModule();
		InverseCalculator ob11 = new InverseCalculator();
		//FileInputStream f1 = null;
		Vector<Integer> v = new Vector<>();
		for(int i = 0; i < (int)Math.pow(2,16) - 1; i++)
		{
			if(isPrime(i))
			{
				v.add(i);
			}
		}
		//FileOutputStream f2 = null, f3 = null;
		try(FileInputStream f1 = new FileInputStream(new File(pl));
		FileOutputStream f2 = new FileOutputStream(new File(ci),true);
		FileOutputStream f3 = new FileOutputStream(new File(sym),true);){
			/*f1=new FileInputStream(fp1);
			f2=new FileOutputStream(fp2,true);
			f3=new FileOutputStream(fp3,true);*/
			while((a = f1.read()) != -1)
			{
				b = f1.read();
				if(b == -1)
					break;
				//System.out.println("\nA : "+a+"\tB : "+b+"\n");
				ob1.encryption(255 - a , b, combine1, combine2, rand1, rand2, keyByte1, keyByte2, xorHandler,
						one, two, symmetricKey, spiral, newSpiral, ob2, ob3, ob4,
						ob5, ob6, ob7, ob8, ob9, ob10, ob11, v);
				f2.write(symmetricKey.arr[7]);
				//f2.write(ob2.binary_to_decimal(two, 0, 7));
				for(int i = 0; i < 7; i++)
					f3.write(symmetricKey.arr[i]);
			}
			if(a != -1 && b == -1)
				b = (int)'O';
			else if(a == -1 && b != -1)
			{
				a = b;
				b = (int)'E';
			}
			//System.out.println("\nA : "+a+"\tB : "+b+"\n");
			ob1.encryption(255 - a, b, combine1, combine2, rand1, rand2, keyByte1, keyByte2, xorHandler,
					one, two, symmetricKey, spiral, newSpiral, ob2, ob3, ob4,
					ob5, ob6, ob7, ob8, ob9, ob10, ob11, v);
			f2.write(symmetricKey.arr[7]);
			//System.out.println("\nCipher : "+symmetricKey.arr[7]+"\n");
			//f2.write(ob2.binary_to_decimal(two, 0, 7));
			for(int i = 0; i < 7; i++)
				f3.write(symmetricKey.arr[i]);
				//System.out.println("Sym - "+i+" : "+symmetricKey.arr[i]);}
			/**
			 * file extension
			 */
			if(this.index != -1)
			{
				String extension = pl.substring(index, pl.length());
				for(int i = 0; i < extension.length(); i++)
				{
					f3.write((int)extension.charAt(i));
				}
			}
		}catch(Exception e){
			System.out.println("\nError in file operation\n\nException - "+e+"\n");
		}
		/*finally {
			try {
				f1.close();
				f2.close();
				f3.close();
			}catch(Exception e)
			{
				System.out.println("\nUnable to close the files\n\nException : "+e);
			}
		}*/
		return start;
	}

	/**
	 * This function creates a new cipher text file and symmetric key file
	 */
	public void file_create()
	{
		File f1 = new File(ci);
		try{
			f1.createNewFile();
		}catch(Exception e){
			System.out.println("\n\nUnable to create file : "+ci+"\n\nError Code : "+e+"\n");
			System.exit(0);
		}
		f1 = new File(sym);
		try{
			f1.createNewFile();
		}catch(Exception e){
			System.out.println("\n\nUnable to create file : "+sym+"\n\nError Code : "+e+"\n");
			System.exit(1);
		}
	}
	
	/*public void print_file_name()
	{
		System.out.println("\nPlain text - "+pl+"\n\nCipher text - "+ci+"\n\nSymmetric 1 - "+sym1);
	}*/

	/**
	 * This function extracts the plain text file name without its so called extension
	 * @return s, is of type String which is basically plain text file name without extension
	 */
	public String copy_name()
	{
		int index = -1;
		for(int i = pl.length()-1; i >= 0; i--)
		{
			if(pl.charAt(i) == '.')
			{
				index = i;
				break;
			}
		}
		String s;
		if(index == -1)
			s = pl;
		else
			s = pl.substring(0, index);//excluding the last index
		this.index = index;
		return s;
	}
	
}