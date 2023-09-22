package chapter07_1;

import java.util.Scanner;

public class Mission5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt(); // 상품 가격		
		int p = 0;
//		i/50000 = a
//		a/10000 = b
//		b/5000 = c
//		c/1000 = p
		
		
		if (i > 50000 ) {
			 p = (i/50000);	//5만원 지폐 갯수
			 
			if(i%50000 > 10000){  
				p = p + (i%50000)/10000; //만원 지폐 갯수 + 5만원 지폐 갯수
				
				if(((i%50000)/10000) > 5000 ) {
					p = p + ((i%50000)/10000)/5000; //5천원 지폐 갯수 + 만원 지폐 갯수 + 5만원 지폐 갯수
					
					if (  (((i%50000)/10000)/5000) > 1000 ) {
						p = p + (((i%50000)/10000)/5000)/1000;
					}
				}
			}
		}
		
		System.out.println(p);
		
		

	}
}
