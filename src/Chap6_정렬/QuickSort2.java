package Chap6_정렬;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//퀵 정렬(비재귀 버전)

import java.util.Scanner;

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return x;
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	@Override
	public boolean equals(Object p) {
		Point px = (Point) p;
		if (this.x == px.x && this.y == px.y)
			return true;
		else
			return false;
	}
}

class EmptyIntStackException extends RuntimeException {
	public EmptyIntStackException() {

	}
}

class OverflowIntStackException extends RuntimeException {
	public OverflowIntStackException() {

	}
}

class Stack {
	private List<Point> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	public Stack(int maxlen) {
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
			data.add(x);
			top++;

			return 1;
		}
	}

	public Point pop() throws EmptyIntStackException {
		if (top <= 0)
			throw new EmptyIntStackException();
		{
			Point p = data.remove(top - 1);
			--top;
			return p;
		}
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

public class QuickSort2 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) {
//     IntStack lstack = new IntStack(right - left + 1);
//     IntStack rstack = new IntStack(right - left + 1);
//
//     lstack.push(left);
//     rstack.push(right);

		// stack을 단 하나 사용
		Stack st = new Stack(right - left + 1);
		Point p = new Point(left, right);
		try {
			st.push(p);
		} catch (OverflowIntStackException e) {
			System.out.println("스택이 가득 찼습니다.");
		}

		while (st.isEmpty() != true) {
			p = st.pop();
			int pl = left = p.getX();
			int pr = right = p.getY(); // 왼쪽 커서

			int x = a[(left + right) / 2]; // 피벗은 가운데 요소

			do {
				while (a[pl] < x)
					pl++;
				while (a[pr] > x)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);

			if (left < pr) {
				p = new Point(left, pr);
				try {
					st.push(p);
				} catch (OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
//             lstack.push(left);           // 왼쪽 그룹 범위의
//             rstack.push(pr);             // 인덱스를 푸시
			}
			if (pl < right) {
				p = new Point(pl, right);
				try {
					st.push(p);
				} catch (OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
//             lstack.push(pl);             // 오른쪽 그룹 범위의
//             rstack.push(right);          // 인덱스를 푸시
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Random random = new Random();
		System.out.println("퀵 정렬");
		System.out.print("요솟수: ");

		int nx;
		nx = 100;
		int[] x = new int[nx];
		for (int i = 0; i < nx; i++) {
			x[i] = random.nextInt(100);
		}

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println(" " + x[i]);
	}
}
