package Chap5_재귀알고리즘;

import java.util.List;
import java.util.ArrayList;

class OverflowIntStackException extends Exception {

}

class EmptyIntStackException extends Exception {

}

class ObjectStack {
	private List<Point> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	public ObjectStack(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Point>();
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
//			Point p = data.get(top -1);
			Point p = data.remove(top - 1);
			top--;
			return p;
		}
		// return data[--ptr];
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
		Point px = (Point) p;
		if (this.x == px.x && this.y == px.y)
			return true;
		else
			return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

public class EightQueen {
	static final int numberQueens = 8;
//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking

	public static void SolveQueen(int[][] d) {

		int count = 0;
		int ix = 0, iy = 0;
		ObjectStack st = new ObjectStack(10);
		Point p = new Point(ix, iy);

		try {
			st.push(p);
		} catch (OverflowIntStackException e) {
			e.printStackTrace();
		}
		d[ix][iy] = 1;
		count++;

		while (count < numberQueens) {
			ix++;
			int cy = 0;
			while (ix < numberQueens) {

				while (cy < numberQueens) {
					if (checkMove(d, ix, cy)) {
						Point px = new Point(ix, cy);
						try {

							st.push(px);
							st.dump();
							d[ix][cy] = 1;
							count++;
							break;

						} catch (OverflowIntStackException e) {
							System.out.println("stack이 가득찼습니다.");
						}						
					}
					cy++;
				}
				if (cy != numberQueens)
					break;
				else {

					try {
						/*
						 * for (int i = 0; i < d.length; i++) for (int j = 0; j < d[0].length; j++)
						 * d[i][j] = 0;
						 */
						p = st.pop();
						count--;

					} catch (EmptyIntStackException e) {
						System.out.println("stack이 비어있습니다.");
					}
					d[p.getX()][p.getY()] = 0;
					ix = p.getX();
					cy = p.getY() + 1;
					// ix = 0;

				}
//				break;
			}

		}

	}

	// x = 0 , y = 0 , data{x}{y} = 1 >> (0,0)에 퀸을 놧다는소리
	public static boolean checkRow(int[][] d, int crow) {
		// 배열 d에서 crow에 Queen을 놓을 수 있느냐?
		// x축 검사
		for (int j = 0; j < numberQueens; j++)
			if (d[crow][j] == 1)
				return false;
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {
		// 배열 d에 ccol 열에 배치할 수 있느냐? 있다면 true로 리턴
		// y축 검사
		for (int i = 0; i < numberQueens; i++)
			if (d[i][ccol] == 1)
				return false;
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int x, int y) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		// 배열 d에 d[cx][cy]의 sw(남서쪽)대각선에 배치 가능하냐?
		// 대각선 검사(서쪽방향)
		int cx = x, cy = y;

		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy--;
		}

		cx = x;
		cy = y;

		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx--;
			cy++;
		}
		return true;
	}

	public static boolean checkDiagSE(int[][] d, int x, int y) {// x++, y++ or x--, y--
		// 대각선 검사(동쪽방향)
		int cx = x, cy = y;

		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy++;
		}
		cx = x;
		cy = y;

		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx--;
			cy--;
		}
		return true;
	}

	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		// y++
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
			return true;
		else
			return false;
	}

	public static int nextMove(int[][] d, int row, int newCol) {// 다음 row에 대하여 이동할 col을 조사
		// x줄 쭉 검사
		for (int i = 0; i < numberQueens; i++) {
			if (checkMove(d, row, i))
				return i;
		}
		return -1;
	}

//	public static boolean nextMove(int[][] d, int row, int newCol) {// 다음 row에 대하여 이동할 col을 조사
//		for (int col = 0; col <d.length; col++) {
//			if (CheckMove(d, row, col)){
//				newCol = col;
//				return true;
//			}
//		}
//		return false;
//	}

	public static void main(String[] args) {
//		int row = numberQueens, col = numberQueens;
		int[][] data = new int[numberQueens][numberQueens];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}
}
