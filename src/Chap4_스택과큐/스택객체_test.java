package Chap4_스택과큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class ObjectStack {
	private List<Point> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	public ObjectStack(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Point>(capacity);
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public int push(Point x) throws OverflowIntStackException {
		if (top >= capacity)
			throw new OverflowIntStackException();
		{
			data.add(x); top++;
			
			return 1;
		}
	}

	public Point pop() throws EmptyIntStackException {
		if (top <= 0)
			throw new EmptyIntStackException();
		{
//			Point p = data.get(top -1);
			Point p = data.remove(top - 1); --top;
			return p;
		}
		// return data[--ptr];
	}

	public Point peek() throws EmptyIntStackException {
		if (top <= 0)
			throw new EmptyIntStackException();
//		return stk[ptr - 1];
		return data.get(top - 1);
	}

	public void clear() {
		top = 0;
	}

	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--)
			if (data.get(i).equals(x))
				return i;
		return -1;
	}

	public boolean isEmpty() {
		return top <= 0;
	}

	public void dump() {
		if (isEmpty())
//			if(ptr <= 0)
			System.out.println("stack이 비었습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	@Override
	public boolean equals(Object p) {
		Point px = (Point)p;
		if (this.x == px.x && this.y == px.y)
			return true;
		else
			return false;
	}
}

public class 스택객체_test {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		ObjectStack s = new ObjectStack(8); // 최대 8 개를 push할 수 있는 stack
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point p = null;
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
//			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point(rndx, rndy);
				try {
					s.push(p);
				} catch (OverflowIntStackException e) {
					System.out.println("stack이 가득찼습니다.");
				}
				break;

			case 2: // 팝
				try {
					p = s.pop();
					System.out.println("pop한 데이터는 " + p + "입니다.");
				} catch (EmptyIntStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("peek한 데이터는 " + p + "입니다.");
				} catch (EmptyIntStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}