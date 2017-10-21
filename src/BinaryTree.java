import java.util.Map;

public class BinaryTree implements BinaryTreeInterface {
	
	private Node node;
	private BinaryTree left;
	private BinaryTree right;
	private int path;
	
	public BinaryTree(Map m) {
		
	}

	@Override
	public void assemby(BinaryTreeInterface left, BinaryTreeInterface right) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getNode(int binary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPath(BinaryTreeInterface.Node n) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public class Node{
		final int count;
		final char c;
		
		public Node(int count, char c) {
			this.count = count;
			this.c = c;
		}
	}
}