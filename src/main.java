import java.io.File;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {

        
        File f = new File("lyrics");
        File out = new File("comp.txt");
        File decomp = new File("decomp.txt");

        BinaryTree tree = new BinaryTree(InputOutput.getFileToMap(f));
        
        InputOutput.compress(tree, f, out);
        InputOutput.decompress(tree, out, decomp);

    }

}
