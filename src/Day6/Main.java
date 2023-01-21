import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static FileReader fr;
	public static Scanner sc;
	public static String letters;
	public static String letterGroup;
	public static String letterCollection = "";
	public static boolean haveSeq = true;
	public static int index;
	public static int len = 4;

	public static void main(String[] args) {
		try {
			fr = new FileReader("chars.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		letters = sc.nextLine();
		for(int i = 0; i < letters.length() - len; i++) {
			letterCollection = "";
			haveSeq = true;
			letterGroup = letters.substring(i, i+len);
			for(char letter : letterGroup.toCharArray()) {
				if (letterCollection.contains(String.valueOf(letter))) {
					haveSeq = false;
				} else {
					letterCollection += letter;
				}
			}
			if (haveSeq) {
				index = i + len;
				i = letters.length();
			}
		}
		System.out.println(index);
	}

}
