package Chap2_기본자료구조;

import java.util.Random;

public class Matrix {

	static void getData(int[][] num) {
		// 난수 생성하여 배열에 입력
		Random rand = new Random(99);
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[0].length; j++)
				num[i][j] = rand.nextInt(10);
		}
	}

	static int[][] addMatrix(int[][] Arr1, int[][] Arr2) {
		// 행렬의 합
		int[][] sum = new int[Arr1.length][Arr1[0].length];
		for (int i = 0; i < Arr1.length; i++) {
			for (int j = 0; j < Arr1[0].length; j++) {
				sum[i][j] = Arr1[i][j] + Arr2[i][j];
			}
		}
		return sum;
	}

	static int[][] multiplyMatrix(int[][] Arr1, int[][] Arr2) {
		// 행렬의 곱
		int[][] sum = new int[Arr1.length][Arr2[0].length];
		for (int i = 0; i < Arr1.length; i++) {
			for (int j = 0; j < Arr2[0].length; j++) {
				for (int k = 0; k < Arr1[0].length; k++) {
					sum[i][j] += (Arr1[i][k] * Arr2[k][j]);
				}
			}
		}
		return sum;
	}

	static int[][] transposeMatrix(int[][] Arr) {
		// 전치 행렬
		int[][] sum = new int[Arr[0].length][Arr.length];
		for (int i = 0; i < Arr[0].length; i++)
			for (int j = 0; j < Arr.length; j++)
				sum[i][j] = Arr[j][i];
		return sum;
	}

	static void showData(int[][] arr) {
		// 배열 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] A1 = new int[2][3];
		int[][] A2 = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4];
		int[][] D = new int[3][2];

		getData(A);
		getData(A1);
		System.out.println("행렬 A");
		showData(A);
		System.out.println("행렬 A1");
		showData(A1);

		A2 = addMatrix(A, A1);
		System.out.println("행렬 A, A1의 합");
		showData(A2);

		getData(B);
		System.out.println("행렬 B");
		showData(B);

		C = multiplyMatrix(A, B);
		System.out.println("행렬 A, B의 곱");
		showData(C);

		D = transposeMatrix(A);
		System.out.println("A의 전치행렬");
		showData(D);
		// A2 = A + A1
		// C = A * B
		// D = A의 전치행렬

	}

}
