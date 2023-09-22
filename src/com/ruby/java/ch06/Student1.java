package com.ruby.java.ch06;

public class Student1 {
	private int sid;
	private String name;
	private String dept;
	public Student1() {}
	public Student1(int sid, String name, String dept) {
		this.sid = sid; this.name = name; this.dept = dept;
	} //this를 하면 
	
	public static void main(String[] args) {
		System.out.println("6장 시작");
		int n = 10;
		Student1 s = null;
//		s = new Student();
		s = new Student1(2023, "고길동", "컴퓨터");
		System.out.println(s.sid);
		System.out.println("student 객체 = " + s);
		
	}
}
