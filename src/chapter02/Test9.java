package chapter02;

public class Test9 {
	public static void main(String[] args) {
		int a = 10;
		int b = 2;
		boolean gender = true;
		System.out.println(a == 10 && gender == false);
		System.out.println(a == 10 & gender == false);
		if(a == 10 & !gender) {
			a++;
			System.out.println(a);
		}
	}

}
