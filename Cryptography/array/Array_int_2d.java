package array;

/**
 * This class is used to create a two dimentional square array of int type......
 */
public class Array_int_2d {
	
	public int [][]arr;// two dimentional array diclaration

	/**
	 * Default constructor
	 */
	public Array_int_2d()
	{
		arr = null;
	}

	/**
	 * Parameterised constructor
	 * @param n is an integer literal which is used to initialize the
	 *          n x n two dimentional array
	 */
	public Array_int_2d(int n)
	{
		arr = new int [n][n];
	}
	
}