import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InputOutput {

	
	
	
	public static Map<Character, Integer> getFileToMap(File file) throws IOException{
			
		Map<Character, Integer> counts = new HashMap<>();
		
		FileInputStream iOStream = new FileInputStream(file);
		
		while(iOStream.available() > 0) {
			Character currentChar = (char)iOStream.read();
			if(counts.containsKey(currentChar)) {
				Integer currentValue = counts.get(currentChar);
				counts.replace(currentChar, currentValue+1);
			}else {
				counts.put(currentChar, 1);
			}
			
		}
		
		iOStream.close();
		return counts;
		
	}
	
	
	public static byte[] toByteArray(BitSet bits) {
        byte[] bytes = new byte[(bits.length() + 7) / 8];
        for (int i = 0; i < bits.length(); i++) {
            if (bits.get(i)) {
                bytes[bytes.length - i / 8 - 1] |= 1 << (i % 8);
            }
        }
        return bytes;
    }
	
	public static void compress(BinaryTree Key, File in, File out) throws IOException {
		Map<Character,Integer> fileMap = getFileToMap(in);
		
		FileInputStream inStream = new FileInputStream(in);
		
		String binaryStringRep = "";
		
		while(inStream.available() > 0) {
			Character next = (char)inStream.read();
			String currentPath = Key.getPath(""+next);
			binaryStringRep += currentPath;
			
		}
		
		int binaryStringRepRemainder = binaryStringRep.length() % 8;
		for(int j=0; j< 8-binaryStringRepRemainder; i++) {
			binaryStringRep+='0';
		}
		
		
		int compressedFileLength = getCompressedFileCharLength(Key, fileMap);
		BitSet bitSet = new BitSet(compressedFileLength);
		
		
		
		for(int i=0; i<binaryStringRep.length(); i++) {
			if(binaryStringRep.charAt(i) == '1') {
				bitSet.set(i);
			}
		}
		
		for(int k=0; k<bitSet.length(); k=k+8) {
			
		}
		
		FileOutputStream outStream = new FileOutputStream(out);
		
		
		
		inStream.close();
		outStream.close();
		
	}
	
	public static void decompress(BinaryTree tree, File in, File out) throws IOException {
		
		FileInputStream inStream = new FileInputStream(in);
		String binaryStringRep = "";
		
		while(inStream.available() > 0) {
			Character next = (char)inStream.read();
			binaryStringRep += Integer.toBinaryString((int)next);
		}
		
		
		
		
		FileOutputStream outStream = new FileOutputStream(out);
		
		BinaryTree currentTree = tree;
		for(int i=0; i<binaryStringRep.length(); i++) {
			
			if(binaryStringRep.charAt(i) == '0') {
				BinaryTree left;
				left = (BinaryTree) currentTree.left;
				currentTree = left;
			}else {
				BinaryTree right;
				right = (BinaryTree) currentTree.right;
				currentTree = right;
			}
			if(currentTree.getNode().c != null) {
				char charRep = currentTree.getNode().c.charAt(0);
				outStream.write(charRep);
				currentTree = tree; 
			}
		}
		outStream.close();
		inStream.close();
		
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
            count += (path.length() * occurances);

        }

        return count;

    }


}
