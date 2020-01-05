package RedBlackTree;

public class RBT {
	Node root;
	private int red = 1;
	private int black = 0;
	private Node nil = new Node(black);

	public RBT() {
		root = nil;
	}
	
	public boolean Search(int value) {
		Node current = this.root;

		while (current != nil) {
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

	public boolean insert(int value) {
		Node newNode = new Node(value, nil, nil);
		Node rootTmp = root;

		if (root == nil) { // 트리가 비어있을 때
			root = newNode;
			newNode.color = black;
			newNode.parent = nil;
		} 
		else {
			newNode.color = red;
			while (true) {
				if(value == rootTmp.key) {
					System.out.println(value+": 삽입 실패");
					return false;
				}
				
				if (value < rootTmp.key) {
					if (rootTmp.left == nil) {
						rootTmp.left = newNode;
						newNode.parent = rootTmp;
						break;
					} else {
						rootTmp = rootTmp.left;
					}
				} else if (value > rootTmp.key) {
					if (rootTmp.right == nil) {
						rootTmp.right = newNode;
						newNode.parent = rootTmp;
						break;
					} else {
						rootTmp = rootTmp.right;
					}
				}
			}
			insertCheck(newNode);
		}
		System.out.println(value+": 삽입 성공");
		return true;
	}

	public void insertCheck(Node node) {
		if (node.parent.color == black) {
			return ;
		}

		while (node.parent.color == red) {
			Node s = nil;
			// parent: right, s: left
			if (node.parent == node.parent.parent.left) { 
				s = node.parent.parent.right;
				
				if (s != nil && s.color == red) { // Case 1
					node.parent.color = black;
					s.color = black;
					node.parent.parent.color = red;
					node = node.parent.parent;
					continue; // parent.parent에서 한번 더 검사해야함.
				}
				else if (node == node.parent.right) { // Case 2
					leftRotate(node.parent);
					node = node.parent;
				} else {
					node.parent.color = black; // Case 3
					node.parent.parent.color = red;
					rightRotate(node.parent.parent);
				}
			} 
			// parent: left, s: right
			else { 
				s = node.parent.parent.left;
				if (s != nil && s.color == red) { // Case 1
					node.parent.color = black;
					s.color = black;
					node.parent.parent.color = red;
					node = node.parent.parent;
					continue;
				}
				else if (node == node.parent.left) { // Case 2
					rightRotate(node.parent);
					node = node.parent;
				} else {
					node.parent.color = black; // Case 3
					node.parent.parent.color = red;
					leftRotate(node.parent.parent);
				}
			}
		}
		root.color = black;
	}

	public void leftRotate(Node node) {
		if(node == this.root) {
			Node right = root.right;
			root.right = right.left;
			right.left.parent = root;
			root.parent = right;
			right.left = root;
			right.parent = nil;
			root = right;
		} 
		else {
			if (node == node.parent.left) {
				node.parent.left = node.right;
			} else {
				node.parent.right = node.right;
			}
			node.right.parent = node.parent;
			node.parent = node.right;
			if (node.right.left != nil) {
				node.right.left.parent = node;
			}
			node.right = node.right.left;
			node.parent.left = node;
		}
	}

	public void rightRotate(Node node) {
		if(node == this.root) {
			Node left = root.left;
			root.left = root.left.right;
			left.right.parent = root;
			root.parent = left;
			left.right = root;
			left.parent = nil;
			root = left;
		}
		else {
			if (node == node.parent.left) {
				node.parent.left = node.left;
			} else {
				node.parent.right = node.left;
			}

			node.left.parent = node.parent;
			node.parent = node.left;
			if (node.left.right != nil) {
				node.left.right.parent = node;
			}
			node.left = node.left.right;
			node.parent.right = node;
		}
	}

	public void printTree(Node root) {
		if (root != nil) {
			printTree(root.left);
			System.out.print(root.key + " ");
			printTree(root.right);
		}
	}
}
