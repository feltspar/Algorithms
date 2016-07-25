import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * this class implements dijkstra's algo
 * 
 * @author Shubham Saxena
 */
public class Dijkstras {

	// inputs
	int[][] in;
	// number of vertices
	int n;
	// output array of distances
	int[] out;

	/**
	 * constructor
	 * 
	 * @param inpput
	 *            matrix
	 */
	public Dijkstras(int[][] in) {
		this.in = in;
		this.n = in.length;
		out = new int[n];
		// start the algorithm
		cal();
	}

	/**
	 * runs diskstra's algorithm
	 */
	public void cal() {
		for (int i = 0; i < n; i++) {
			// for edges not visited
			for (int j = 1; j < n; j++) {
				// if they are connected
				if (in[i][j] != 0) {
					int newd = out[i] + in[i][j];
					// if new distance is lesser
					if ((out[i] != 0 || i == 0)
							&& (out[j] == 0 || out[j] > newd)) {
						// update
						out[j] = newd;

					}
				}

			}
		}
	}

	/**
	 * main method
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		// read the input
		int v = Integer.parseInt((sc.next()));
		int e = Integer.parseInt((sc.next()));
		// matrix of inputs
		int[][] in = new int[v][v];
		// fill the matrix
		for (int i = 0; i < e; ++i) {
			int v1 = Integer.parseInt((sc.next()));
			int v2 = Integer.parseInt((sc.next()));
			int c = Integer.parseInt((sc.next()));
			in[v1][v2] = c;
			// in[v2][v1] = c;// if directed graph. Comment this line
		}
		sc.close();

		// initiate the algorithm
		long n = System.currentTimeMillis();
		Dijkstras obj = new Dijkstras(in);
		long n2 = System.currentTimeMillis();
		// print the output
		System.out.println("Djikstras");
		System.out.println("Vertex - Distance");
		for (int i = 0; i < v; i++) {
			if (obj.out[i] != 0) {
				System.out.println(i + " - " + obj.out[i]);
			} else {
				System.out.println(i + " - Infinite");
			}
		}
		System.out.println("Time taken "+(n2-n));
		
	}
}
