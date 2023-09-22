package chapter07;

public class LMSTest {
	
	public static void main(String[] args) {
		Employee e = new Employee();
		
		System.out.println(e); //null, 0, null (데이터 초기화 안해줘서)
		
		Employee e1 = new Employee("고길동", 20, "입학처");
		System.out.println(e1);

		
		
//		Professor p = new Professor();
//		Student s = new Student();
//		
//		e.setName("오정임");
//		e.setAge(47);
//		e.setDept("입학처");
//		
//		p.setName("김푸름");
//		p.setAge(52);
//		p.setSubject("빅데이터");
//		
//		s.setName("김유빈");
//		s.setAge(20);
//		s.setMajor("컴퓨터과학");
//		
//		System.out.println(e.toString());  //부모 클래스에 있는 toString이 사용되서 출력됨.
//		System.out.println(p.toString());
//		System.out.println(s.toString());
	}
}
