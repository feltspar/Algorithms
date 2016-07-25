import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author Shubham
 *
 */
public class Transitive {

	/**
	 * 
	 * @param n
	 * @return
	 */
	public int[][] getInit(int n) {
		int[][] in = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					in[i][j] = 1;
			}
		}
		return in;
	}

	/**
	 * 
	 * @param in
	 * @param n
	 */
	void closureFunc(int[][] in, int n) {

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					in[i][j] = (in[i][j]) | (in[i][k] & in[k][j]);
				}
			}
		}
	}

	/**
	 * 
	 * @param a
	 */
	public void print(int[][] a) {
		System.out.print("x  ");
		for (int j = 0; j < a[0].length; j++) {
			System.out.print(j + " ");
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//File f = new File("input.txt");
		Scanner sc = new Scanner(System.in);
		Transitive tc = new Transitive();

		// read the input
		int v = Integer.parseInt((sc.next()));
		int e = Integer.parseInt((sc.next()));
		// matrix of inputs
		int[][] in = tc.getInit(v);
		// fill the matrix
		for (int i = 0; i < e; ++i) {
			int v1 = Integer.parseInt((sc.next()));
			int v2 = Integer.parseInt((sc.next()));
			 int c = Integer.parseInt((sc.next()));// if input does not have
													// cost, comment this
			in[v1][v2] = 1;
			// in[v2][v1] = c;// if directed graph.
		}
		sc.close();
		
		long n = System.currentTimeMillis();
		tc.closureFunc(in, v);
		long n2 = System.currentTimeMillis();
		
		System.out.println("Transitive");
		tc.print(in);
		
		System.out.println("Time taken "+(n2-n));
	}
}
