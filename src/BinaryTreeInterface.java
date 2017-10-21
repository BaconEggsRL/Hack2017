

public interface BinaryTreeInterface {
	
	public class Node {
		int count;
		String c;
	}
	
	public char getNode(String binary);
	public String getPath(String string);
	public void assembyTogether(BinaryTreeInterface left, BinaryTreeInterface right);
	Node getNode();
	public void setPath(String string);
	public void setParent(BinaryTreeInterface parent);
	public BinaryTreeInterface getParent();
	public String getPath();
	
}
