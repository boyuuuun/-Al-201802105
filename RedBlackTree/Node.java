package RedBlackTree;

public class Node {
	public int key, color;
	public Node parent, left, right;
	//public Node nil = new Node(0);

	public Node(int key, Node left, Node right) {
		this.key = key;
//		this.parent = null;
		this.left = left;
		this.right = right;
//		this.color = null;
	}
	
	public Node(int color) {
		this.color = color;
		
	}

}
