package Chap3_검색;


import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public String toString() {
		return this.name + "\t" + this.height + "\t" + this.vision;
	}

	@Override
	public int compareTo(PhyscData pd) {
		int result = this.name.compareTo(pd.name);
		if (result == 0) {
			int hresult = this.height - pd.height;
			if (hresult == 0) {
				return (int) (this.vision - pd.vision);
			} else
				return hresult;
		} else
			return result;
	}

}
public class 객체배열이진탐색_Test {

	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2),
				new PhyscData("길동", 167, 0.5),
		};
		showData(data);
		sortData(data);
		System.out.print("\n배열 정렬 \n");
		showData(data);
		
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = new PhyscData("홍길동", 162, 0.3);
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		
		int idx = Arrays.binarySearch(data, key);
//		Arrays.binarySearch(data, key, comparator)
		System.out.println("\nArrays.binarySearch(): result = " + result);
	}

	static void showData(PhyscData[]arr) {
		System.out.println();
		for (PhyscData fruit: arr) {
			System.out.print(fruit+"\n");
		}
		System.out.println();
	}
	
	private static void sortData(PhyscData[] data) {
		// 오름차순 정렬
		for (int i = 0; i < data.length; i++)
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}
	}
	
	static void swap(PhyscData[] sp, int i, int j) {
		// 배열 안의 두 요소를 교환
		PhyscData t = sp[i];
		sp[i] = sp[j];
		sp[j] = t;
	}
	
	private static int linearSearch(PhyscData[] data, PhyscData key) {
		for (int i = 0; i < data.length; i++) {
			if (key.compareTo(data[i]) == 0)
				return i;
		}
		return 0;
	}
	
	private static int binarySearch(PhyscData[] data, PhyscData key) {
		int pl = 0;
		int pr = data.length - 1;

		do {
			int pc = (pl + pr) / 2;
			if (data[pc].compareTo(key) == 0)
				return pc;
			else if (key.compareTo(data[pc]) > 0)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);

		return 0;

	}

}
