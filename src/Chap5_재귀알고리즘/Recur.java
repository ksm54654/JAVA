package Chap5_재귀알고리즘;

import java.util.Scanner;


class EmptyIntStackException extends RuntimeException {
	public EmptyIntStackException() {

	}
}

class OverflowIntStackException extends RuntimeException {
	public OverflowIntStackException() {

	}
}

class IntStack {
	private int[] stk; // 스택용 배열
	private int capacity; // 스택의 크기
	private int ptr; // 스택 포인터

	public IntStack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public int push(int x) throws OverflowIntStackException{
		if (ptr >= capacity)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	public int pop() throws EmptyIntStackException{
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	public int peek() throws EmptyIntStackException{
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr-1];
	}

	public void clear() {
		ptr = 0;
	}

	public int indexOf(int x) {
		for(int i = ptr-1; i>= 0;i--)
			if(stk[i] == x)
				return i;
		return -1;
	}
	
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	public void dump() {
		if(isEmpty())
//		if(ptr <= 0)
			System.out.println("stack이 비었다");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}

public class Recur {
		
	static void recur(int n) {
		IntStack s = new IntStack(20);
	
		while (true) {
			if (n > 0) {
				System.out.println("recur(" + n + " - 1 );");
				
				try {
					s.push(n);
				} catch (OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				n = n - 1;
				continue;
			} 
			else if(s.isEmpty() != true) {
				try {
					n = s.pop();
					System.out.println("팝한 데이터는 " + n + "입니다.");
				} catch (EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				System.out.println(n);
				System.out.println("recur(" + n + " - 2 );");
				n = n - 2;
				continue;
			}
			break;
		}

//		while (n > 0)
////		if (n > 0) {
//			System.out.println("recur(" + n + " - 1 );");
//			recur(n - 1);
//			System.out.println(n);
//			System.out.println("recur(" + n + " - 2 );");
////			recur(n - 2);
//			n = n - 2;
//		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int x = stdIn.nextInt();

		recur(x);
	}
}
