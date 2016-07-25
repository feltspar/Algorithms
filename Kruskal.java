/**
 * Kruskals implementation
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Kruskal {
	Edge a[];
	ArrayList<Set> sets = new ArrayList<Set>();
	int v;
	int count;

	/*
	 * constructor
	 */
	public Kruskal(Edge[] a, int v) {
		this.a = a;
		this.v = v;
		Set s = new Set();
		s.set.add(a[0]);
		sets.add(s);
		// System.out.println("sets: "+sets);
		doIt();
		// result();
	}

	/**
	 * prints results
	 */
	public void result() {
		for (Set t : sets) {
			for (Edge u : t.set) {
				System.out.println(u);
			}
		}
	}

	/**
	 * inserting edges into sets.
	 */
	public void doIt() {
		for (int i = 1; i < a.length; i++) {
			insertToSet(a[i]);
			// System.out.println("inserted: "+a[i]+" = "+sets);
			if (count == v) {
				break;
			}
		}
	}

	/**
	 * finds set and inserts edge into set
	 * @param e - edge
	 */
	public void insertToSet(Edge e) {
		int v = -1;
		int y = -1;

		for (int i = 0; i < sets.size(); i++) {
			int x = sets.get(i).count(e);
			if (x == 2) {
				return;
			} else if (x == 1) {
				if (v == -1) {
					v = i;
				} else {
					y = i;
				}
			}
		}

		if (v != -1) {
			if (y != -1) {
				sets.get(v).union(sets.get(y), e);
				sets.remove(y);
			} else {
				sets.get(v).set.add(e);
			}
		} else {
			Set s = new Set();
			s.set.add(e);
			sets.add(s);
		}
		count++;
	}

	/**
	 * main method
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// File f = new File("input.txt");
		// Scanner sc = new Scanner(f);
		Scanner sc = new Scanner(System.in);

		// read the input
		int v = Integer.parseInt((sc.next()));
		int e = Integer.parseInt((sc.next()));
		// matrix of inputs
		Edge[] edges = new Edge[e];
		// fill the matrix
		int x = 0;
		for (int i = 0; i < e; ++i) {
			int v1 = Integer.parseInt((sc.next()));
			int v2 = Integer.parseInt((sc.next()));
			int c = Integer.parseInt((sc.next()));
			edges[x++] = new Edge(v1, v2, c);
		}
		sc.close();
		List<Edge> l = Arrays.asList(edges);
		long n = System.currentTimeMillis(); // start time
		Collections.sort(l);
		Kruskal ob = new Kruskal(edges, v);
		long n2 = System.currentTimeMillis(); // end time

		ob.result();
		System.out.println("Time taken " + (n2 - n));
	}
}
