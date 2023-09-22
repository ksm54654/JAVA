package Chap7_집합;

class Sets {
	public Sets(int sz)
	{
		n = sz;
		parent = new int[sz + 1]; // Don't want to use parent[0]
		for (int i = 0; i < n; i++) parent[i] = -1;  // 0 for Simple versions
	}

	public void display(){
		
		for (int i = 1; i <= n; i++) 
			System.out.print(" " +  i);
		System.out.println();
		for (int i = 1; i <= n; i++)
			System.out.print(" " + parent[i]);
		System.out.println();
	}

	public void SimpleUnion(int i, int j)
	// Replace the disjoint sets with roots i and j, i != j with their union
	{
		
		while (parent[i] > 0) i = parent[i];
		while (parent[j] > 0) j = parent[j];
		if (i == j) System.out.println("cycle");
		WeightedUnion(i,j);
//		System.out.println("i = " + i + " j = " + j);
//		parent[j] = i;
	}

	public int SimpleFind(int i)
	// Find the root of the tree containing element i
	{
		while (parent[i] > 0)
			i = parent[i];
		return i;
	}

	public void WeightedUnion(int i, int j)
	// Union sets with roots i and j, i != j, using the weighting rule.
	// parent[i] = - count[i] and parent[j] = - count[j].
	{
		int temp = parent[i] + parent[j];
		if (parent[i] > parent[j]) { // i has fewer nodes
			parent[i] = j;
			parent[j] = temp;
		} else { // j has fewer nodes
			parent[j] = i;
			parent[i] = temp;
		}
	}

	public int CollapsingFind(int i)
	// Find the root of the tree containing element i.
	// Use the collapsing rule to collapse all nodes from @i@ to the root
	{
		int r;
		for (r = i; parent[r] > 0; r = parent[r])
			; // find root
		while (i != r) {
			int s = parent[i];
			parent[i] = r;
			i = s;
		}
		return r;
	}

	private int[] parent;
	private int n;
}

public class TreeSet {
	public static void main(String[] args) {

	Sets s1 = new Sets(20);
	/*
	s1.SimpleUnion(0,1);s1.SimpleUnion(1,2);s1.SimpleUnion(3,4);s1.SimpleUnion(5,6); // 1이 7, 3이 2, 5가 4, 7이 6
	s1.SimpleUnion(7,8);s1.SimpleUnion(8,9);s1.SimpleUnion(2,5);s1.SimpleUnion(1,9); // 2가 4, 7이 이미 엮여있어서 루트끼리 엮여줌, 2 4 5 이미 다묶여잇음, f(2)!=f(5), 9는 1 
	s1.display();
	int n1 = s1.SimpleFind(5);
	int n2 = s1.SimpleFind(7);
	System.out.println("5의 parent = " + n1 + "  7의 parent = " + n2);
	*/
	s1.WeightedUnion(1, 2);
	s1.WeightedUnion(3, 4);
	s1.WeightedUnion(5, 6);
	s1.WeightedUnion(7, 8);
	System.out.println("find 5: " + s1.CollapsingFind(5)+ "\n");

	s1.display();
	System.out.println ("find 5: " + s1.CollapsingFind(5) + "\n");
	System.out.println ("find 6: " + s1.CollapsingFind(6) + "\n");
	s1.WeightedUnion(1, 3);
	s1.WeightedUnion(5, 7);
	s1.display();
	System.out.println ("find 5: " + s1.CollapsingFind(5) + "\n");
	System.out.println ("find 6: " + s1.CollapsingFind(6) + "\n");
	System.out.println ("find 7: " + s1.CollapsingFind(7) + "\n");
	System.out.println ("find 8: " + s1.CollapsingFind(8) + "\n");
	s1.WeightedUnion(1, 5);
	s1.display();
	System.out.println ("find 1: " + s1.CollapsingFind(1) + "\n");
	System.out.println ("find 2: " + s1.CollapsingFind(2) + "\n");
	System.out.println ("find 3: " + s1.CollapsingFind(3) + "\n");
	System.out.println( "find 4: " + s1.CollapsingFind(4) + "\n");
	System.out.println ("find 5: " + s1.CollapsingFind(5) + "\n");
	System.out.println ("find 6: " + s1.CollapsingFind(6) + "\n");
	System.out.println ("find 7: " + s1.CollapsingFind(7) + "\n");
	System.out.println ("find 8: " + s1.CollapsingFind(8) + "\n");
	s1.display();
	

}
}