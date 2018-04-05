package test;

import java.util.Scanner;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("\nString - ");
		Scanner i=new Scanner(System.in);
		String s=i.nextLine();
		System.out.println("\nInput String - "+s);
		String a=s+"_cipher.txt",b=s+"_sym1.txt";
		System.out.println("\nCipher - "+a+"\n\nSymmetric - "+b);
		i.close();
	}

}