package Chap4_스택과큐;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Chap4_스택과큐.Queue.EmptyIntQueueException;
import Chap4_스택과큐.Queue.OverflowIntQueueException;

//int형 고정 길이 큐
class objectQueue {
    private List<Point> que;  
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수
	
	
	public int enque(Point x) throws OverflowIntQueueException {
		if(num >= capacity)
			throw new OverflowIntQueueException();
		que.add(x);
		num++;
		if(rear == capacity)
			rear = 0;
		return 1;
		
	}


	public Point deque() throws EmptyIntStackException {
		if(num <= 0)
			throw new EmptyIntQueueException();
		Point p = que.remove(front);
		num--;
		if(front == capacity)
			front = 0;
		return p;
	}


	public Point peek() throws EmptyIntStackException {
		
		return null;
	}


	public void dump() {
		
		
	}
	
	public void clear() {
		num = front = rear = 0;
	}
	
	public int indexOf(int x) {
		for(int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if(que.get(idx).equals(x))
				return idx;
		}
		return -1;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int size() {
		return num;
	}
	
	public boolean isEmpty() {
		return num <= 0;
	}
	

}


//int형 고정 길이 큐의 사용 예
public class 큐객체_test {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		objectQueue s = new objectQueue(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 인큐
				System.out.print("데이터: ");
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point(rndx,rndy);
				try {
					s.enque(p);
				} catch(OverflowIntQueueException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = s.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (EmptyIntStackException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (EmptyIntStackException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}