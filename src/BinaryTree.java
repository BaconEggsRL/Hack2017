import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BinaryTree implements BinaryTreeInterface {

    private Node node;
    private BinaryTreeInterface parent;
    public BinaryTreeInterface left;
    public BinaryTreeInterface right;
    private String path = null;
    private Map<String, String> pathMap;

    public BinaryTree(Map<Character, Integer> m) {
        ArrayList<BinaryTree> list = new ArrayList<>();
        BinaryTree[] leaf = new BinaryTree[m.size()];

        //create leaf
        int i = 0;
        for (Entry<Character, Integer> pair : m.entrySet()) {
            Node newNode = new Node(pair.getValue(), pair.getKey() + "");
            BinaryTree tree = new BinaryTree(newNode);
            leaf[i] = tree;
            i++;
            addAndSort(list, tree);
        }

        //assemble tree
        while (list.size() > 1) {
            BinaryTree lowest1 = list.remove(0);
            BinaryTree lowest2 = list.remove(0);

            int parentCount = lowest1.getNode().count + lowest2.getNode().count;

            BinaryTree parent = new BinaryTree(new Node(parentCount, null));
            parent.left = lowest1;
            lowest1.parent = this;
            lowest1.path = "0";
            parent.right = lowest2;
            lowest2.parent = this;
            lowest1.path = "1";
            
            
            
            addAndSort(list, parent);
        }

        //root
        this.node = list.get(0).node;
        this.left = list.get(0).left;
        this.right = list.get(0).right;

        //map path
        this.pathMap = new HashMap<String, String>();
        for (BinaryTree leafTree : leaf) {
            this.pathMap.put(leafTree.node.c, leafTree.getPath());
        }
    }

    private static void addAndSort(ArrayList<BinaryTree> list,
            BinaryTree tree) {
        if (list.isEmpty()) {
            list.add(tree);
            return;
        }

        int i = 0;
        boolean added = false;
        while (i < list.size() && !added) {
        	System.out.println(tree.node.compareTo(list.get(0).node));
            if (tree.node.compareTo(list.get(0).node) > 0) {
                i++;
            } else {
                list.add(i, tree);
                added = true;
            }
            
            if(i == list.size()) {
            	list.add(i, tree);
            	added = true;
            }

        }

    }

    public BinaryTree(Node n) {
        this.node = n;
    }

    @Override
    public void assembyTogether(BinaryTreeInterface left,
            BinaryTreeInterface right) {
        left.setPath("0");
        right.setPath("1");
        left.setParent(this);
        right.setParent(this);
        this.left = left;
        this.right = right;
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
        if (c == '1') {
            nodeChar = this.right.getNode(sub);
        } else {
            nodeChar = this.left.getNode(sub);
        }

        return nodeChar;
    }

    @Override
    public String getPath(String string) {
        return this.pathMap.get(string);
    }

    @Override
    public String getPath() {
        if (this.parent == null) {
            return this.path;
        } else {
            return this.parent.getPath() + this.path;
        }
    }

    @Override
    public BinaryTreeInterface.Node getNode() {
        return this.node;
    }

    public class Node extends BinaryTreeInterface.Node {

        public Node(int count, String c) {
            this.count = count;
            this.c = c;
        }

        public int compareTo(Node n) {
            if (this.count >= n.count) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public void setParent(BinaryTreeInterface parent) {
        this.parent = parent;
    }

    @Override
    public BinaryTreeInterface getParent() {
        return this.parent;
    }

}
