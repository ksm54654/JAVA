package chapter13.nonGen;

class Bag<T, N> {
	T thing;
	N name;
	
	public Bag(T thing, N name) {
		this.thing = thing; this.name = name;
	}
	
	public void showType() {
		System.out.println("타입은 " + this.getClass());
	}
}

public class Test02 {

	public static void main(String[] args) {
		Bag<Book, String> bag = new Bag<Book, String>(new Book(), "과학");
		bag.showType();
	}
}
