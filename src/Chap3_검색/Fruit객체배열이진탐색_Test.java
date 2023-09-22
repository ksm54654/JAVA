package Chap3_검색;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/

import java.util.Arrays;
import java.util.Comparator;

class Fruit {

	String name;
	int price;
	String expire;

	public Fruit(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;
	}
	
	public String toString() {
		return this.name + "\t" + this.price + "\t" + this.expire;
	}

	public static final Comparator<Fruit> class_cc = 
			new ComparatorFruit();

	private static class ComparatorFruit implements Comparator<Fruit> {// 익명클래스 사용
		public int compare(Fruit f1, Fruit f2) {
			return (f1.expire.compareTo(f2.expire));
		}
	}

	public int getPrice() {
		
		return price;
	}

	public String getName() {
		
		return name;
	};
}

public class Fruit객체배열이진탐색_Test {

	public static void main(String[] args) {
		Fruit[] arr = { 
				new Fruit("사과", 200, "2023-5-8"), 
				new Fruit("키위", 500, "2023-6-8"),
				new Fruit("오렌지", 200, "2023-7-8"), 
				new Fruit("바나나", 50, "2023-5-18"), 
				new Fruit("수박", 880, "2023-5-28"),
				new Fruit("체리", 10, "2023-9-8") };
		System.out.println("정렬전 객체 배열: ");
		showData(arr);
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit에 compareTo()가 있어도 람다식 우선 적용
		System.out.println("람다식 정렬(가격)후 객체 배열: ");
		showData(arr);
		Arrays.sort(arr, Fruit.class_cc);
		Arrays.sort(arr, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit a1, Fruit a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		System.out.println("comparator 정렬(이름)후 객체 배열: ");
		showData(arr);

		Comparator<Fruit> cc_name = new Comparator<Fruit>() {// 익명클래스 사용
			public int compare(Fruit f1, Fruit f2) {
				return (f1.name.compareTo(f2.name));
			}
		};
		Comparator<Fruit> cc_price = new Comparator<Fruit>() {// 익명클래스 사용
			public int compare(Fruit f1, Fruit f2) {
				return (f1.price - f2.price);

			}
		};

		Fruit newFruit = new Fruit("체리", 500, "2023-5-18");
		int result3 = Arrays.binarySearch(arr, newFruit, Fruit.class_cc);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_name);
		System.out.println("\nbinarySearch() 조회결과::" + result3);

		sortData(arr, cc_price);
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit, cc_price);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_price);
		System.out.println("\nbinarySearch() 조회결과::" + result3);
	}
	
	static void showData(Fruit []arr) {
		System.out.println();
		for (Fruit fruit: arr) {
			System.out.print(fruit+"\n");
		}
		System.out.println();
	}
	        
	static void sortData(Fruit []arr, Comparator<? super Fruit> cc) {
		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++) {
				if (cc.compare(arr[i], arr[j]) > 0) {
					Fruit t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
	}

	static int binarySearch(Fruit[] arr, Fruit newFruit, Comparator<? super Fruit> cc) {
		// 이진탐색 코드 가져와서 fruit 버전으로 변경
		// if문에서 비교할 때
		
		int pl = 0;
		int pr = arr.length - 1;

		do {
			int pc = (pl + pr) / 2;
			if (cc.compare(newFruit, arr[pc]) == 0)
				return pc;
			else if (cc.compare(newFruit, arr[pc]) > 0)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);
		
		return 0;
		
	}

}
