
import java.util.ArrayList;
/**
 * 
 * @author Shubham
 *
 */
public class Set {
	
	ArrayList<Edge> set;
	/**
	 * constructor
	 */
	public Set(){
		set=new ArrayList<Edge>();
	}
	/**
	 * 
	 * @param e edge
	 * @return 
	 */
	public int count(Edge e){
		int c=0;
		for(int i=0;i<set.size();i++){
			c+=set.get(i).isCompatible(e);
		}
		return c;
	}
	/**
	 * 
	 * @param a
	 * @param e
	 */
	public void union(Set a, Edge e){
		set.addAll(a.set);
		set.add(e);
	}
	/**
	 * 
	 */
	public String toString(){
		return set.toString();
	}
}
