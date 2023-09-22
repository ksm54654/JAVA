package chapter08_innerclass;

enum Mandarin {
	금귤(600), 한라봉(500), 레드향(300), 천혜향(400), 황금향(800);
	
	private int price;
	
	Mandarin(int p){
		price = p;
	}
	
	int getPrice() {
		return price;
	}
}

public class EnumTest02 {
	public static void main(String[] args) {
		Object o1 = Mandarin.금귤;
		System.out.println("toString = " + o1.toString());
		o1.hashCode();
		System.out.println("hashcode = " + o1.hashCode());
		
		Mandarin ma = Mandarin.한라봉;
		
		System.out.println("ma = " + ma.name());
		System.out.println("ma.price = " + ma.getPrice());
		System.out.println("ma.ordinal = " + ma.ordinal());
		
		
//		if(ma == Mandarin.한라봉)
//			System.out.println("ma는 한라봉입니다.");
//		System.out.println(ma + "가격 : " + ma.getPrice());
//		
//		Mandarin list[] = Mandarin.values();
//		System.out.println("== 귤의 종류 ==");
//		for(Mandarin m : list)
//			System.out.println(m + ":" + m.getPrice());
	}
}
