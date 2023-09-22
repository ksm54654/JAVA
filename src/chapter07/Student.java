package chapter07;

public class Student extends Person {
	
	private String major;
	
	public Student() {
		System.out.println("Student 생성자가 호출되었습니다.");
	}
	
	public Student(String name, int age, String major) {
		super(name, age);  
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + getName() + ", age=" + getAge() + ", major=" + major + "]";
	} 
	
}
