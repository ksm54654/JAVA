package chapter07;

public class Professor extends Person {
	
	private String subject;
	
	public Professor() {
		System.out.println("Professor 생성자가 호출되었습니다.");
	}
	
	public Professor(String name, int age, String subject) {
		super(name, age);  
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Professor [name=" + getName() + ", age=" + getAge() + ", subject=" + subject + "]";
	} 

}
