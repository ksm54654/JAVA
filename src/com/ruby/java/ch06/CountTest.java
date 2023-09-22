package com.ruby.java.ch06;

class Count {
	public static int totalCount;
	private int num;
	public void setNum(int n) {
		num = n;
	}
	public int getNum() {
		return num;	
	}
}

public class CountTest {
	
	public static void main(String[] args) {
		int num = 0;
		Count.totalCount = 10;
		//Count.num = 20; //클래스 이름 -> stack으로 선언된 벼..변수?머랬지? 암튼 그거만 가능
		Count c1 = new Count();
		Count c2 = new Count();
		Count c3 = new Count();
		c3.totalCount = 110;
		//c1.num++;  //변수이름
		c1.setNum(num);
		System.out.println("num = " + c1.getNum());
		Count.totalCount++;
		//c2.num++;
		Count.totalCount++;
		//c3.num++;
		Count.totalCount++;
	
//		c1.count++;
//		Count.totalCount++;
//		c2.count++;
//		Count.totalCount++;
//		c3.count++;
//		Count.totalCount++;
		
		System.out.println(Count.totalCount + " : " + c1.totalCount);
		System.out.println(Count.totalCount + " : " + c2.totalCount);
		System.out.println(Count.totalCount + " : " + c3.totalCount);
	}
}
