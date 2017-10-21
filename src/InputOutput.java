import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InputOutput {

    public static Map<Character, Integer> getFileToMap(File file)
            throws IOException {

        Map<Character, Integer> counts = new HashMap<>();

        FileInputStream iOStream = new FileInputStream(file);

        while (iOStream.available() > 0) {
            Character currentChar = (char) iOStream.read();
            if (counts.containsKey(currentChar)) {
                Integer currentValue = counts.get(currentChar);
                counts.replace(currentChar, currentValue + 1);
            } else {
                counts.put(currentChar, 1);
            }

        }

        iOStream.close();
        return counts;

    }

    public static int getCompressedFileCharLength(BinaryTree key,
            Map<Character, Integer> counts) {
        int count = 0;

        Iterator mapIterator = counts.entrySet().iterator();

        while (mapIterator.hasNext()) {
            Map.Entry<Character, Integer> pair = (Map.Entry) mapIterator.next();
            int occurances = pair.getValue();
            Character character = (char) pair.getKey();
            String path = key.getPath(String.valueOf(character));
            System.out.println(path);
            count += (path.length() * occurances);

        }

        return count;

    }

    public static void toCompressedFile(BinaryTree Key, File in, File out)
            throws IOException {
        Map<Character, Integer> fileMap = getFileToMap(in);
        int compressedFileLength = getCompressedFileCharLength(Key, fileMap);

        BitSet bitSet = new BitSet(compressedFileLength);

        FileInputStream inStream = new FileInputStream(in);

        //to bitset
        int currentBitSetIndex = 0;
        while (inStream.available() > 0) {
            Character next = (char) inStream.read();
            String path = Key.getPath(String.valueOf(next));
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == '1') {
                    bitSet.set(currentBitSetIndex);
                }
                currentBitSetIndex++;
            }
        }

        int bitRemainder = compressedFileLength % 8;

    }

}
