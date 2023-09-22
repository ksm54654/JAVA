package Chap2_기본자료구조;

import java.util.Random;

public class MaxOfArrayRand {
	static void getData(int[] num) {
		// 난수 생성하여 배열에 입력
		Random rand = new Random(99);
		for (int i = 0; i < num.length; i++) {
			num[i] = rand.nextInt(10);
		}
	}

	static void showData(int[] num) {
		// 배열 출력
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}

	static int findMax(int[] a) {
		// 최대값 출력
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}

	static void swap(int[] sp, int i, int j) {
		// 배열 안의 두 요소를 교환
		int t = sp[i];
		sp[i] = sp[j];
		sp[j] = t;
	}

	static void sortData(int[] s) {
		// 오름차순 정렬
		for (int i = 0; i < s.length; i++)
			for (int j = i + 1; j < s.length; j++) {
				if (s[i] > s[j]) {
					swap(s, i, j);
				}
			}
	}

	public static void main(String[] args) {
		int[] data = new int[10];
		getData(data);
		showData(data);
		int mvvalue = findMax(data);
		System.out.println("\nmax = " + mvvalue);
		sortData(data);
		System.out.print("정렬후 결과 \n");
		showData(data);
	}
}
