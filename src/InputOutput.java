import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
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
	public static void compress(BinaryTree key, File in, File out) throws IOException {
		
		BitSet bitSet = new BitSet(7);
		FileInputStream inStream = new FileInputStream(in);
		FileOutputStream outStream = new FileOutputStream(out);
		
		//to bitset
		int currentBitSetIndex = 0;
		while(inStream.available() > 0) {
			char next = (char)inStream.read();
			String path = key.getPath(String.valueOf(next));
			System.out.println();
			for(int i=0; i<path.length(); i++) {
				if(path.charAt(i) == '1') {
					bitSet.set(7 - currentBitSetIndex);
				}
				if(currentBitSetIndex < 7) {
					currentBitSetIndex++;
				} else {
					byte[] bArr = bitSet.toByteArray();
					if(bArr.length == 0) {
						bArr = new byte[1];
						bArr[0] = (byte) 0;
					}
					outStream.write(bArr);
					currentBitSetIndex = 0;
					bitSet.clear();
				}
			}
			if(currentBitSetIndex != 0 && inStream.available() == 0) {
				byte[] bArr = bitSet.toByteArray();
				key.getNode().c = 7 - currentBitSetIndex + "";
				outStream.write(bArr);
			}
		}
		
		inStream.close();
		outStream.close();
		
	}
	private static int getBit(int position, byte b){
	   return (b >> position) & 1;
	}
	
	public static void decompress(BinaryTree tree, File in, File out) throws IOException {
		
		FileInputStream inStream = new FileInputStream(in);
		FileOutputStream outStream = new FileOutputStream(out);
		
		ArrayList<Byte> byteArrayList = new ArrayList<>();
		int numOfUnlessBits = Integer.parseInt(tree.getNode().c);
		
		while(inStream.available() > 0) {
			byteArrayList.add((byte) inStream.read());
		}
		
		Byte[] byteArray = new Byte[byteArrayList.size()];
		byteArrayList.toArray(byteArray);
		
		BinaryTree currentTree = tree;
		for(int i=0; i<byteArray.length; i++) {
			byte b = byteArray[i];
			for(int j = 7; j >=0 ; j--) {
				int bit = getBit(j, b);
				System.out.println();
				if(bit == 0) {
					BinaryTree left;
					left = (BinaryTree) currentTree.left;
					currentTree = left;
				} 
				else {
					BinaryTree right;
					right = (BinaryTree) currentTree.right;
					currentTree = right;
				}
				if(currentTree.getNode().c != null) {
					char charRep = currentTree.getNode().c.charAt(0);
					outStream.write(charRep);
					currentTree = tree; 
				}
				if(i+1 == byteArray.length && j == numOfUnlessBits ) {
					break;
				}
			}
			
		}
		outStream.close();
		inStream.close();
		
	}


}
