package chapter10;

public class Test07 {

	public static void main(String[] args) {
		
		HashMap<String,String> dic = new HashMap<String, String>();
		
		dic.put("고진감래", "고생 끝에 즐거움이 옴");
		dic.put("분골쇄신", "몸이 부서질정도로 노력을 다함");
		dic.put("권토중래", "실패를 발판삼아 재기함");
		dic.put("교학상자", "가르치고 배우면서 서로 성장함");
		dic.put(null,null);	// HashMap은 null 값 저장 가능
	}
}
