package encrypt1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Init ob = new Init();
		final long start = ob.take_input();
		final long end = System.currentTimeMillis();
		System.out.println("\nEncryption time : "+(end - start)+" msec\n");
	}

}
