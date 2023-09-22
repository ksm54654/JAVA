package chapter05;

public class Mission3 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		int year = 2024;
		int i = 0;

		while (i < 10) {
			if (year % 4 == 0) {
				if (year % 100 == 0) {
					if (year % 400 == 0) {
						arr[i] = year;
						System.out.println(arr[i]);
						year++;
						i++;
					}
				} else {
					arr[i] = year;
					System.out.println(arr[i]);
					year++;
					i++;
				}
				year++;
			}
			year++;
		}
	}
}
//윤년이 만족하는 조건
//(year%4 == 0)
//(year%4 == 0) && (!(year%100)==0)
//(year%4 == 0) && (year%100 == 0) && (year%400 == 0)