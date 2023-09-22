package chapter08;

import java.util.Scanner;

public class Mission6 { 	//이진수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt(); // 받는 수 
		
		int[] arr = null;
		
		while(i / 2 > 0) {
			int c = 1;
			if(i % 2 == 1) {
				arr[c] = 1;
				c++;
			}
			else {
				arr[c] = 0;
				c++;
			}
			System.out.print("1");
			if(c >= 0) {
				System.out.println(arr[c]);	
				c--;
			}
			
		}
			
		
		
		
//		char c1 = '1';
//		char c0 = '0';
//		int t = 0;
//		
//		while(i / 2 < 0) {
//			if(i % 2 == 1) {
//				t = t + c1;
//			}
		}
	}

