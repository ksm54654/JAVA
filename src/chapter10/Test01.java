package chapter10;

import java.util.ArrayList;

class Student {
	int sid; String name;
}

class Employee {
	String name;
	int age;
	int height;
	int weight;
	char bloodType;
	String email;

	public Employee(String name, int age, int height, int weight, char bloodType, String email) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
		this.email = email;
	}
	
	public String toString() {
		return name + ", " + age + ", " + height + ", " + weight + ", " + bloodType + ", " + email;
	}
}

public class Test01 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("서울"); list.add("부산"); list.add("창원"); 
		list.add("대전"); list.add("광주"); list.add("울산");
		// for(int i = 0; i < list.size(); i++)
		//		System.out.println(list.get(i).toString());
		for(String a : list)
			System.out.print(" " + a.toString());
		list.add(0, "인천");
		list.remove(1);
		System.out.println("\n 인천 삽입후 :: ");
		for(String a : list)
			System.out.print(" " + a.toString());
		
		System.out.println(list.toString()); 
		Object obj[] = list.toArray();
		System.out.println("8: " + Arrays.toString(obj));
		
//		Object arr[] = new Object[10];
//		ArrayList list1 = new ArrayList();
//		String s = "java"; Integer i = 123;
//		arr[0] = s; arr[1] = i;
//		int m = arr.length;
//		int l = s.length();
//		//int len = arr[0].length();
//		list1.add(s); list1.add(i);
//		int h = ((String)list1.get(0)).length();
//		
//		ArrayList<String> list2 = new ArrayList<String>();
//		Student s1 = new Student(10, "hong");
//		list2.add(s1);
		
		
		
//		int [] a = new int[10];
//		Employee [] eset = new Employee[10];
//		eset[0] = new Employee("hong", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[1] = new Employee("kim", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[2] = new Employee("lee", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[3] = new Employee("park", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[4] = eset[3];
//		eset[3] = eset[2];
//		eset[2] = new Employee("choi", 11, 130, 50, 'A', "bhhong@go.kr");
//		
//		for(int i = 0; i < 5; i++) {
//			System.out.println(eset[i].toString());
//		}
		
	}
}
