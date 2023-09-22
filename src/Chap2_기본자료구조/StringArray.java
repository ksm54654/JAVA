package Chap2_기본자료구조;

import java.util.Random;

public class StringArray {
	static void getData(int[] items) {
		// 난수 생성하여 배열에 입력
		Random rand = new Random(99);
		for (int i = 0; i < items.length; i++) {
			items[i] = rand.nextInt(10);
		}
	}

	static void showData(String[] items) {
		// 배열 출력
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i] + " ");
		}
	}

	static void swap(String[] sp, int i, int j) {
		// 배열 안의 두 요소를 교환
		String t = sp[i];
		sp[i] = sp[j];
		sp[j] = t;
	}

	static void sortData(String[] args) {
		// 오름차순 정렬
		for (int i = 0; i < args.length; i++)
			for (int j = i + 1; j < args.length; j++) {
				if (args[i].compareTo(args[j])>0) {
					swap(args, i, j);
				}
			}
	}

	public static void main(String[] args) {
		String[] data = {"apple","딸기", "grape", "melon", "참외", "수박", "망고"};
		showData(data);
		
		sortData(data);
		System.out.print("정렬후 결과 \n");
		showData(data);
	}
}
