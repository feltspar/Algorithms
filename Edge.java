
/**
 * 
 * @author Shubham
 *
 */
public class Edge implements Comparable<Edge> {
	int a;
	int b;
	int weight;
/**
 * 
 * @param a
 * @param b
 * @param weight
 */
	public Edge(int a, int b, int weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
	}
/**
 * 
 * @param e
 * @return
 */
	public int isCompatible(Edge e) {
		if (e.a == this.a || e.b == this.a || e.a == this.b || e.b == this.b) {
			return 1;
		}
		return 0;
	}
/**
 * 
 */
	@Override
	public int compareTo(Edge a) {
		return this.weight - a.weight;
	}
/**
 * 
 */
	public String toString() {
		return a + "-" + b + "->" + weight;
	}

}
