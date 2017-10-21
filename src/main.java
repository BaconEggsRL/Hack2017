import java.io.File;
import java.io.IOException;

public class main {

    public static void main(String[] args) {

        InputOutput io = new InputOutput();
        File f = new File("lyrics");
        File out = new File("comp");

        try {
            BinaryTree tree = new BinaryTree(io.getFileToMap(f));

            io.toCompressedFile(tree, f, out);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
