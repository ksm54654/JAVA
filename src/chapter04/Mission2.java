package chapter04;

public class Mission2 {
	public static void main(String[] args) {
		int[][] A = {{ 1, 2, 3, 4 },
					{ 5, 6, 7, 8,}, 
					{ 9, 10, 11, 12 }};
		int[][] B = {{ 1, 2, 3 },
					{ 4, 5, 6 }, 
					{ 7, 8, 9 },
					{ 10, 11, 12 }};
		
		int sum = 0;
		for(int i = 0; i < A.length; i++) { 
			for(int j = 0; j < A.length; j++) {
				for(int k = 0; k < B.length; k++) {
				sum += (A[i][k]*B[k][j]);
				}
				System.out.print(sum + "\t");
				sum = 0;
			}
			System.out.println();
			sum = 0;
		}
	}
}

