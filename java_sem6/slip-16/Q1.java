import java.util.TreeSet;

public class Q1 {
	public static void main(String args[]) {
		TreeSet ts = new TreeSet();
		ts.add("Red");
		ts.add("Yellow");
		ts.add("Blue");
		ts.add("Green");
		ts.add("Red");
		System.out.println("TreeSet in ascending order: "+ ts);
	}
}
