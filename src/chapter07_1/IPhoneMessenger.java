package chapter07_1;

public class IPhoneMessenger extends GraphicIOS implements Messenger {
	
	public String getMessage() {
		return "iPhone";
	}
	
	public void setMessage(String msg) {
		System.out.println("iPhone에서 메시지를 설정합니다 : " + msg);
	}
	
	public void clearMessage() {
		System.out.println("좌우로 흔들어 문자열을 지웁니다.");
	}
	
	public void draw_textBox() {
		System.out.println("IPhoneMessenger : 텍스트 상자를 그린다.");
		super.draw_textBox();//부모꺼 불러오는거
	}
	
	public void draw_submitButton() {
		System.out.println("IPhoneMessenger : 전송버튼을 그린다.");
		super.draw_submitButton();
	}

}
