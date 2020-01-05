package BST;

import java.util.Arrays;

public class BST {
	public Node root;
	public int size;
	//private int array[];
	private int maxsize = 100;
	
	public int count=0;
	
	public BST() {
		root = null;
		size = 0;
		//array = new int[maxsize];
	}
	
	public class Node {
		private int key;
		private Node left, right;

		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
	
	public boolean insert(int value) {
		Node newNode = new Node(value);
		
		if (this.root == null) { // 트리가 비어있는 경우
			this.root = newNode;
			System.out.println(value + "삽입 성공");
			return true;
		}
		else {
			Node tmp_root = this.root;
			Node parent;

			while (true) {
				parent = tmp_root;

				if(value == parent.key) {
					System.out.println(value + "삽입 실패");
					return false;
				}
				else if (value < parent.key) {
					tmp_root = parent.left;

					if (tmp_root == null) {
						parent.left = newNode;
						System.out.println(value + "삽입 성공");
						return true;
					}

				} else {
					tmp_root = parent.right;

					if (tmp_root == null) {
						parent.right = newNode;
						System.out.println(value + "삽입 성공");
						return true;
					}
				}
			}
		}
	}
	
	public boolean searchIterative(int value) {
//		Node tmp_root = this.root;
//		while(tmp_root!=null && value!=tmp_root.key) {
//			if(value < tmp_root.key) 
//				tmp_root = tmp_root.left;
//			else if(value > tmp_root.key) 
//				tmp_root = tmp_root.right;
//			else
//				break;
//		}
//		return tmp_root;
		
		Node current = this.root;

		while (current != null) {
			if (current.key==value) {
				System.out.println(value + ": search 성공");
				return true;
			}

			if (current.key < value)
				current = current.right;
			else
				current = current.left;
		}

		System.out.println(value + ": search 실패");
		return false;
	}
	
	public Node searchRecursive(int value, Node r) {
		Node tmp_root = r;
		if(tmp_root == null || value==tmp_root.key)
			return r;
		if(value<tmp_root.key)
			return searchRecursive(value, tmp_root.left);
		else
			return searchRecursive(value, tmp_root.right);
	}
	
	public Node searchSuccessor(Node node) {
		if(node.right==null)
			return null;
		Node tmp = node.right;
		while(tmp.left!=null) {
			count++;
			tmp = tmp.left;
		}
		return tmp;
	}
	
	public Node searchPredecessor(Node node) {
		if(node.left==null)
			return null;
		Node tmp = node.left;
		while(tmp.right!=null) {
			count++;
			tmp=tmp.right;
		}
		return tmp;
	}
	

	public Node delete(int value) {
		count=0;
		Node tmp_root = this.root;
		Node parent = null;
		
		// 트리가 비어있는 경우, null 반환.
		if (tmp_root == null) {
			System.out.println(value+"삭제 실패");
			return null;
		}
		
		// 비어있지 않은 경우, 트리에서 value 찾는다.
		while (tmp_root.key != value) {
			count++;
			parent = tmp_root;
			if (value < tmp_root.key )
				tmp_root = tmp_root.left;
			else
				tmp_root = tmp_root.right;
			
			if (tmp_root == null)
				break;
		}

		// 트리에 value가 없을 때
		if (tmp_root == null) {
			System.out.println(value+"삭제 실패");
			System.out.println("자식으로 내려간 횟수: " + count);
			return tmp_root;
		}
		// 트리에서 value를 찾았을 때
		if (tmp_root.left == null && tmp_root.right == null) { // 자식이 없을때
			if(tmp_root==this.root) {
				this.root = null;
			}
			else if (parent.left == tmp_root)
				parent.left = null;
			else
				parent.right = null;
		} 
		else if (tmp_root.left == null) { // 오른쪽 서브트리만을 가질때
			if(tmp_root == this.root) {
				this.root = tmp_root.right;
			}
			else if (parent.left == tmp_root)
				parent.left = tmp_root.right;
			else
				parent.right = tmp_root.right;
		} 
		else if (tmp_root.right == null) { // 왼쪽 서브트리만을 가질때
			if(tmp_root == this.root) {
				this.root = tmp_root.left;
				//return tmp_root;
			}
			else if (parent.left == tmp_root)
				parent.left = tmp_root.left;
			else
				parent.right = tmp_root.left;
		}
		else { // 양쪽에 서브 트리를 가질때
			Node alt = searchPredecessor(tmp_root);
			if(tmp_root==this.root) {
				this.root = alt;
				//return tmp_root;
			}
			else if (parent.left == tmp_root)
				parent.left = alt;
			else
				parent.right = alt;
		}
		System.out.println(value+"삭제 성공");
		System.out.println("자식으로 내려간 횟수: " + count);
		return tmp_root;
	}
	
	public void reset() {
		this.root = null;
	}
	
	public void printTree(Node root) {
		if (root != null) {
			printTree(root.left);
			System.out.print(root.key + " ");
			printTree(root.right);
		}
	}
	
	public int printChildCount(Node root) {
		if(root==null)
			return 0;
		
		int count=1;
		int left = printChildCount(root.left)+count;
		int right = printChildCount(root.right)+count;
		int deep = left>=right ? left : right;
		
		return deep;
	}
	
	int sumDepthOfAllChildren(Node node, int depth)
	{
	    if ( node == null )
	        return 0;  // starting to see a pattern?
	    return depth + sumDepthOfAllChildren(node.left, depth + 1) + 
	                   sumDepthOfAllChildren(node.right, depth + 1);
	}

}
