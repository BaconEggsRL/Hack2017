import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class main {

    public static void main(String[] args) throws IOException {

        
        File f = new File("smallfile.txt");
        File out = new File("comps2.txt");
        
        File decomp = new File("decomps2.txt");

            BinaryTree tree = new BinaryTree(InputOutput.getFileToMap(f));
            
            System.out.println(tree.pathMap);
            
           
            
           InputOutput.compress(tree, f, out);
            
           InputOutput.decompress(tree, out, decomp, Integer.parseInt(tree.getNode().c));

    }

}
