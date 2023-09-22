package chapter07;

public class Employee extends Person {

	private String dept;
	
	public Employee() {
		System.out.println("Employee 생성자가 호출되었습니다.");
	}
	
	public Employee(String name, int age, String dept) {
//		setName(name); //부모한테 있어서 set.
//		setAge(age);
		super(name, age);  //가장 간단하고 일반적인 방법
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [name=" + getName() + ", age=" + getAge() + ", dept=" + dept + "]";
	} //name선언이 private이라서 오류. 그래서 get으로 ... 
}
