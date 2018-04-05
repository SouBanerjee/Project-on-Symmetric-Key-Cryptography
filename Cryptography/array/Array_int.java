package array;

/**
 * This class is used to create a one dimentional array of int type
 */
public class Array_int {
	
	public int []arr;// one dimentional array declaration

	/**
	 * Default constructor
	 */
	public Array_int()
	{
		arr = null;
	}

	/**
	 * Parameterised constructor
	 * @param n is an integer literal used to initialize a one
	 *          dimentional array of size n
	 */
	public Array_int(int n)
	{
		arr = new int [n];
	}
}
