package chapter07;

public class Person {

	private String name;
	private int age;

	public Person() {
		System.out.println("Person 생성자가 호출되었습니다.");
	}
	
	public Person(String name, int age) {
		this.name = name; //set 불편해서 추가함.
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
