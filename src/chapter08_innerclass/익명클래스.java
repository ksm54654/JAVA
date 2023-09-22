package chapter08_innerclass;

interface Messenger{
	String getMessage();
	void setMessage(String msg);
}

//class GMessenger implements Messenger {
//	public String getMessage() {
//		return "good";
//	}
//	public void setMessage(String msg) {
//		System.out.println("my data = " + msg);
//	}
//	public void changeMode() {
//		System.out.println("chaned");
//	}
//}

public class 익명클래스 {  // class 가 없음에도 문제가업음 ... maybe,,, 
	public static void main(String[] args) {
//		GMessenger gm = new GMessenger();  클래스
		Messenger gm = new Messenger() { //인터페이스
			public String getMessage() {
				return "good";
			}
			public void setMessage(String msg) {
				System.out.println("my data = " + msg);
			}
			public void changeMode() {
				System.out.println("chaned");
			}
		};
		gm.getMessage();
		gm.setMessage("hong");
	}
}
