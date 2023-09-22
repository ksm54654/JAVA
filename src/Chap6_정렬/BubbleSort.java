package Chap6_정렬;

import java.util.Random;

public class BubbleSort {

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 버블정렬
	static void bubbleSort(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = n - 1; j > i; j--) {
				count++;
				if (a[j - 1] > a[j])
					swap(a, j - 1, j);
			}
		System.out.println("비교 횟수 = " + count);
	}

	// 버블정렬2
	static void bubbleSort2(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			int exchg = 0;
			for (int j = n - 1; j > i; j--) {
				count++;
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					exchg++;
				}
			}
			if (exchg == 0)
				break;
		}
		System.out.println("비교 횟수 = " + count);
	}

	// 버블정렬3
	static void bubbleSort3(int[] a, int n) {
		int count = 0;
		int k = 0;
		while (k < n - 1) {
			int last = n - 1;
			for (int j = n - 1; j > k; j--) {
				count++;

				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j;
				}
			}
			k = last;
		}
		System.out.println("비교 횟수 = " + count);
	}

	// 단순 선택 정렬
	static void selectionSort(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				count++;
				if (a[j] < a[min])
					min = j;
			}
			swap(a, i, min);
		}
		System.out.println("비교 횟수 = " + count);

	}

	// 단순 삽입 정렬
	static void insertionSort(int[] a, int n) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			int j;
			int tmp = a[i];
			for (j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1];
				count++;
			}
			a[j] = tmp;
		}
		System.out.println("비교 횟수 = " + count);
	}

	// shell 정렬
	static void shellSort(int[] a, int n) {
		int count = 0;
		for (int h = n / 2; h > 0; h /= 2)
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
					count++;
				}
				a[j + h] = tmp;
				
				
			}
		System.out.println("비교 횟수 = " + count);
	}

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("버블 정렬(버전1)");

		int nx;
		nx = 100;
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {

			x[i] = random.nextInt(100);
		}

//		bubbleSort(x, nx);
//		bubbleSort2(x, nx);
//		bubbleSort3(x, nx);
//		selectionSort(x, nx);
//		insertionSort(x, nx);
		shellSort(x, nx);
		

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println(" " + x[i]);
	}

}
