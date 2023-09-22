package edu;

class Student {
	public static int countStudents;// 객체수
	int sid;// 학번
	String sname; // 학생 이름
	String city; // 주소 도시

	public void showStudent() {
		System.out.print("객체: ");
		System.out.println(this.toString());	
	}
	
	public Student() {
		sid = 0;
		sname = null;
		city = null;
		countStudents++;
	}
	public Student(int sid) {
		this.sid = sid;
		sname = null;
		city = null;
		countStudents++;
	}

	public Student(int sid, String sname) {
		this.sid = sid;
		this.sname = sname;
		city = null;
		countStudents++;
	}

	public Student(int sid, String sname, String city) {
		this.sid = sid;
		this.sname = sname;
		this.city = city;
		countStudents++;
	}
	
	public String toString() {
		return sid + " : " + sname + " : " + city;
	}
	
	static void showNumberObjects() {// 생성된 객체수를 출력한다.
		System.out.println("NumberObjects : " + countStudents);
	}
}

public class TestStudent {
	private static void showNumberObjects() {
		
	}
	
	public static void main(String[] args) {
		int[] a = new int[5];
		Student arry[] = new Student[5];
		showNumberObjects();
		arry[0] = new Student();
		arry[1] = new Student(202301);
		arry[2] = new Student(202302, "Hong");
		arry[3] = new Student(202303, "Lee", "Busan");
		arry[4] = new Student(202304, "Na", "jeju");
		showNumberObjects();
		for (int i = 0; i < 5; i++) {
			arry[i].showStudent();// 생성된 객체 모두를 출력한다.
		}
	}

}
