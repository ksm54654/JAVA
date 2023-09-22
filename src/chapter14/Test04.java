package chapter14;

interface Verify2 {
	boolean check(int n, int d);
}

public class Test04 {
	public static void main(String[] args) {
		Verify2 vf = (n, d) -> (n % 2) == 0;
		System.out.println(vf.check(24, 3));
	}
}
