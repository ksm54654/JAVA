package Chap9_트리;

/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;

//정수를 저정하는 이진트리 만들기 실습
class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode(int x) {
		this.data = x;
		LeftChild = RightChild = null;
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
		TreeNode temp = new TreeNode(x);
		TreeNode p = root;
		TreeNode q = p;
		if (p == null) {
			root = temp;
			return true;
		}
		while (p != null) {
			if (x < p.data) {
				q = p;
				p = p.LeftChild;
			}
			else if (x == p.data)
				return false;
			else {
				q = p;
				p = p.RightChild;
			}
		}
		 if (x < q.data) {
		        q.LeftChild = temp;
		    } else {
		        q.RightChild = temp;
		    }
		 
		return true;

	}

	boolean delete(int num) {
		TreeNode p = root;
		TreeNode parent = root;
		boolean isLeftChild = true;
		
		// 1. leat 노드 삭제
		// 2. child가 1개인 노드 삭제
		// 3. child가 2개인 노드 삭제 -> 제일 복잡함... 
		
		while (parent.data != num) {
			p = parent;
			if (num < parent.data) {
				parent = parent.LeftChild;
				isLeftChild = true;
			}
			else if (num > parent.data){
				parent = parent.RightChild;
				isLeftChild = false;
			}
			if (parent == null) {
				return false;
			}
		}
		
//		if (p == null) {
//			return false;
//		}
		
		if (parent.LeftChild == null && parent.RightChild == null) {
			if (parent == root) {
				root = null;
			}
			if (isLeftChild) {
				p.LeftChild = null;
			} else {
				p.RightChild = null;
			}
		}
		else if (parent.LeftChild == null) {
			if (parent == root)
				root = parent.RightChild;
			else if (isLeftChild) 
				p.LeftChild = parent.RightChild;
			else 
				p.RightChild = parent.RightChild;
		}
		else if (parent.RightChild == null) {
			if(parent == root) {
				root = parent.LeftChild;
			} else if (isLeftChild) {
				p.LeftChild = parent.LeftChild;
			} else {
				p.RightChild = parent.LeftChild;
			}
		}
		// 확실한 이해 필요... 
//		else {
//			TreeNode successor = inorderSucc(parent);
//			if (parent == root) {
//				root = successor;
//			} else if (isLeftChild) {
//				parent.LeftChild = successor;
//			} else {
//				parent.RightChild = successor;
//			}
//			successor.LeftChild = parent.LeftChild;
//		}
		return true;
	}

	boolean search(int num) {
		TreeNode p = root;
		while (p != null) {
			if (p.data == num) {
				return true;
			} else if (p.data > num) {
				p = p.LeftChild;
			} else {
				p = p.RightChild;
			}
		}
		return false;
	}
}

public class 정수이진트리 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
				}
				for (int i = 0; i < count; i++) {
					if (t.insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num) == true)
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result == true)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}
