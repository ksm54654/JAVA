package chapter14;

@FunctionalInterface
interface Multiply {
	double getValue();
//	double print(); 인터페이스 함수가 한개여야함. (람다식은)
}

@FunctionalInterface
interface verify {
	boolean check(int n);
}

public class TestMultiply {
	public static void main(String[] args) {
		verify v = (n) -> (n % 2) == 0;
//		Multiply m;
//		m = () -> 3.14 * 2;
//		System.out.println("m = " + m);
		System.out.println("v = " + v.check(10));
	}
}
