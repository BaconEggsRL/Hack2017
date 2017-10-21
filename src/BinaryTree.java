import java.util.Map;

public class BinaryTree implements BinaryTreeInterface {

	private Node node;
	private BinaryTreeInterface parent;
	private BinaryTreeInterface left;
	private BinaryTreeInterface right;
	private String path;

	public BinaryTree(Map<Integer, Character> m) {

	}

	public BinaryTree(Node n) {

	}



	@Override
	public BinaryTreeInterface assembyTogether
	(BinaryTreeInterface left, BinaryTreeInterface right) {

		int parentCount = left.getNode().count + right.getNode().count;

		Node parent = new Node(parentCount, null);
		BinaryTree parentTree = new BinaryTree(parent);
		left.setPath("0");
		right.setPath("1");
		left.setParent(parentTree);
		right.setParent(parentTree);
		parentTree.left = left;
		parentTree.right = right;

		return parentTree;
	}



	@Override
	public void setPath(String string) {
		this.path = string;
	}

	@Override
	public char getNode(String binary) {
		//remove first bit
		char c = binary.charAt(0);
		String sub = binary.substring(1);

		char nodeChar;
		if(c == '1') {
			nodeChar = right.getNode(sub);
		}
		else {
			nodeChar = left.getNode(sub);
		}

		return nodeChar;
	}

	@Override
	public String getPath() {
		return path + this.getParent().getPath();
	}



	@Override
	public BinaryTreeInterface.Node getNode() {
		return this.node;
	}

	public class Node extends BinaryTreeInterface.Node{
		final int count;
		final String c;

		public Node(int count, String c) {
			this.count = count;
			this.c = c;
		}
	}

	@Override
	public void setParent(BinaryTreeInterface parent) {
		// TODO Auto-generated method stub
		this.parent = parent;
	}

	@Override
	public BinaryTreeInterface getParent() {
		// TODO Auto-generated method stub
		return this.parent;
		}



}