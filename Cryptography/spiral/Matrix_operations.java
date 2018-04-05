package spiral;

import array.Array_int;
import array.Array_int_2d;

/**
 * This class is used to create initial spiral matrix and shuffled matrix from
 * initial spiral matrix
 */
public class Matrix_operations {

	/**
	 * This function creates a spiral matrix for 16 bits block
	 * generated by binary representation of two bytes of plain text file
	 * @param combine is a one dimentional array which holds the 16 bits block representation of
	 *                two bytes of plain text file
	 * @param spiral ia a spiral matrix genarated by 16 bits block representation of
	 *               two bytes of plain text file, taken from LSB to MSB
	 */
	public void matrix_create(Array_int combine, Array_int_2d spiral)
	{
		int n = 4, a = 2, b = a - 1, i = 0, j = 0, k = 15, t1 = 0, t2 = 0;
		while(true)///this do..while loop generates the whole spiral matrix
		{	while(j <= n-1)// top row
			{
				spiral.arr[i][j] = combine.arr[k]; k--; j++;
			}
			j--; i++;
			while(i <= n-1)// right column
			{
				spiral.arr[i][j] = combine.arr[k]; k--; i++;
			}
			i--; j--;
			while(j >= t2)// bottom row
			{
				spiral.arr[i][j] = combine.arr[k]; k--; j--;
			}
			j++; i--;
			while(i > t1)// left column
			{
				spiral.arr[i][j] = combine.arr[k]; k--; i--;
			}
			i++;
			if(i == a && j == b)// whenever spiral matrix becomes full
				break;
			i = t1 + 1; t1++; j++; t2 = j; n--;
		}
		/*System.out.println("\nInitial spiral matrix\n");
		for(int x = 0; x < 4; x++)
		{
			for(int y = 0; y < 4; y++)
			{
				System.out.print(spiral.arr[x][y]+"  ");
			}
			System.out.println();
		}*/
	}

	/**
	 * This function genarates randomly shuffled spiral matrix from
	 * the initially generated spiral matrix
	 * @param spiral is a two dimentional array which represents the initial spiral matrix
	 * @param spiral_new is a two dimentional array which represents the represents the randomly
	 *                   shuffled spiral matrix
	 * @param random ia a one dimentional array which corresponds the randomly shuffled position
	 *               of the initial spiral matrix and the content of this array will be stored as
	 *               first byte of symmetric key : 1
	 */
	public void new_matrix_(Array_int_2d spiral, Array_int_2d spiral_new, Array_int random)
	{
		//int s[]=random.arr;
		for(int i = 0; i < random.arr.length / 2; i++){
			int var = 2 * random.arr[2 * i] + random.arr[2 * i + 1], j, k,
					l, m, u, v, t, t2;
			if(var % 2 == 0){
				u = var; t = v = 0;
			}else{
				u = var - 1; t = v = var % 2 + 1;
			}
			if(i >= 2){
				j = 2; l = 3;
			}else{
				j = 0; l = 1;
			}
			if(i % 2 == 0){
				t2 = k = 0; m = 1;
			}else{
				t2 = k = 2; m = 3;
			}
			for(; j <= l; j++){
				for(k = t2; k <=m; k++){
					spiral_new.arr[j][k] = spiral.arr[u][v]; v++;
				}
				u++; v = t;
			}
		}
		/*System.out.println("\nRandomly Shuffled matrix\n");
		for(int x = 0; x < 4; x++)
		{
			for(int y = 0; y < 4; y++)
			{
				System.out.print(spiral_new.arr[x][y]+"  ");
			}
			System.out.println();
		}*/
	}
	
}