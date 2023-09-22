package Chap3_검색;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;

public class 정수배열이진탐색_Test {

	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();
		for (int num : data) {
			System.out.print(num + " ");
		}
		int key = 78;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = 66;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);

	}

	private static int linearSearch(int[] data, int key) {
		// 배열 0번째 부터 찾는 거
		for (int i = 0; i < data.length; i++) {
			if (key == data[i])
				return i;
		}
		return 0;
	}

	private static int binarySearch(int[] data, int key) {
		int pl = 0;
		int pr = data.length - 1;

		do {
			int pc = (pl + pr) / 2;
			if (data[pc] == key)
				return pc;
			else if (data[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);

		return 0;
	}

	private static void inputData(int[] data) {
		Random rand = new Random(99);
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(99);
		}

	}

	private static void showData(int[] data) {
		// 배열 출력
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	private static void sortData(int[] data) {
		// 오름차순 정렬
		for (int i = 0; i < data.length; i++)
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {
					swap(data, i, j);
				}
			}
	}

	static void swap(int[] sp, int i, int j) {
		// 배열 안의 두 요소를 교환
		int t = sp[i];
		sp[i] = sp[j];
		sp[j] = t;
	}

}
