package Chap3_검색;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;

public class 스트링배열이진탐색_Test {

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "감", "배", "사과", "포도", "pear", "blueberry", "strawberry",
				"melon", "oriental melon" };

		showData(data);
		sortData(data);
		System.out.print("\n배열 정렬 \n\n");
		showData(data);

		String key = "감";
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = "배";
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);

	}

	private static void showData(String[] data) {
		// 배열 출력
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i] + " ");
		}
	}

	private static void sortData(String[] data) {
		// 오름차순 정렬
		for (int i = 0; i < data.length; i++)
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}

	}

	static void swap(String[] sp, int i, int j) {
		// 배열 안의 두 요소를 교환
		String t = sp[i];
		sp[i] = sp[j];
		sp[j] = t;
	}

	private static int linearSearch(String[] data, String key) {
		for (int i = 0; i < data.length; i++) {
			if (key.compareTo(data[i]) == 0)
				return i;
		}
		return 0;
	}

	private static int binarySearch(String[] data, String key) {
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
