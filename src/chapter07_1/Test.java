package chapter07_1;

abstract class Employee {
	private String name;
	private int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public abstract void calcSalary();
	public abstract void calcBonus();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}

class Salesman extends Employee {
	public Salesman(String name, int salary) {
		super(name, salary);
	}

	public void calcSalary() {
		System.out.println(getName() + "의 급여");
		System.out.println(String.format("%10s:%10d", "기본급", getSalary()));
		System.out.println(String.format("%10s:%10d", "판매 수당", getSalary() * 15));
		System.out.println("-".repeat(20));
	}
	
	public void calcBonus() {
		System.out.println(getName() + "의 보너스 = ");
		System.out.println("기본급 : " + getSalary());
		System.out.println("판매 수당 : " + getSalary() * 12);
	}
}

class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}
	
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}

	
}
abstract class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
}

class Director extends Manager {
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
}

public class Test {
	public static void main(String[] args) {
		Salesman s = new Salesman("홍일동", 500);
//		s.setName("홍일동");
//		s.setSalary(100);
		Consultant c = new Consultant("홍이동");
		Director d = new Director();

		s.calcSalary();
		s.calcBonus();
		c.calcSalary();
		c.calcBonus();
		d.calcSalary();
		d.calcBonus();
	}
}