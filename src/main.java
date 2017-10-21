import java.io.File;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {

        
        File f = new File("smallfile.txt");
        File out = new File("comp4.txt");
        
        File decomp = new File("decomp2.txt");

            BinaryTree tree = new BinaryTree(InputOutput.getFileToMap(f));
            
            System.out.println(Integer.toBinaryString((int)'Á'));
            
           //InputOutput.compress(tree, f, out);
            
           // InputOutput.decompress(tree, out, decomp);

    }

}
