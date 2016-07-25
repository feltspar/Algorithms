/**
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class calculates minimum paths from any vertex to another vertex
 * 
 * @author: shubham
 */
public class Floyd {
	// input matrix
	int[][] input;
	// output matrix [from][to][including these number of vertices]
	int[][][] distance;
	static// total number of vertices
	int noOfVertices;

	public Floyd(int[][] in) {
		this.input = in;
		noOfVertices = in.length;
		distance = new int[noOfVertices + 1][noOfVertices + 1][noOfVertices + 1];
		// initialize base case
		findBase();
		// calculate the distance
		findDistance();
	}

	/**
	 * calculate base case
	 */
	private void findBase() {
		for (int i = 1; i <= noOfVertices; i++) {
			for (int j = 1; j <= noOfVertices; j++) {
				// if they are same
				if (i == j) {
					distance[i][j][0] = 0;
				} else {
					// if they are connected
					if (input[i - 1][j - 1] != 0) {
						distance[i][j][0] = input[i - 1][j - 1];
					} else {
						// infinite assumed= 9999 (-1 can be a possible input)
						distance[i][j][0] = 9999;
						
					}
				}
			}
		}
	}

	/**
	 * calculate distance
	 */
	private void findDistance() {
		// for number of vertices in between
		for (int k = 1; k <= noOfVertices; k++) {
			// start vertex
			for (int i = 1; i <= noOfVertices; i++) {
				// end vertex
				for (int j = 1; j <= noOfVertices; j++) {
					// shortest path
					distance[i][j][k] = min(distance[i][j][k - 1],
							(distance[i][k][k - 1] + distance[k][j][k - 1]));
				}
			}
		}
	}

	/**
	 * print the shortest paths, from a vertex
	 * 
	 * @param from
	 *            startNode vertex
	 * @return values to be printed
	 */
	public String getDistanceFrom(int startNode) {
		String result = "Distance from " + startNode + " to \n";
		for (int i = 0; i < noOfVertices; i++) {
			// print the distance
			int var = distance[startNode + 1][i + 1][noOfVertices];
			result = result + i + " is " + var + "\n";
		}
		return result;
	}

	/**
	 * this method returns the min of 2 values
	 * 
	 * @param aValue
	 * @param otherValue
	 * @return minimum
	 */
	private int min(int aValue, int otherValue) {
		return (aValue > otherValue) ? otherValue : aValue;
	}

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
			// in[v2][v1] = c;
		}
		sc.close();
		long n = System.currentTimeMillis();
		Floyd o = new Floyd(in);
		long n2 = System.currentTimeMillis();
		
		System.out.println("Floyd- ALL pairs shortest path");
		System.out.println("Vertex - Distance");

		for (int i = 0; i < noOfVertices; i++)
			System.out.print(o.getDistanceFrom(i));
		
		System.out.println("Time taken "+(n2-n));
	}
}
