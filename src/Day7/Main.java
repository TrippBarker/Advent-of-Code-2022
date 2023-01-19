package adventDay7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static FileReader fr;
	public static Scanner sc;
	
	public static ArrayList<String> directoryAL = new ArrayList<>();
	public static Stack<String> dirStack = new Stack<>();
	public static ArrayList<Integer> dirSizeAL = new ArrayList<>();
	public static String[] fileIn;
	public static void main(String[] args) {
		try {
			fr = new FileReader("filesys.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		while(sc.hasNext()) {
			fileIn = sc.nextLine().split(" ");
			System.out.println(fileIn);
			if (fileIn[0].equals("$")) {
				if (fileIn[1].equals("cd")) {
					if (fileIn[2].equals("..")) {
						dirStack.pop();
					} else {
						directoryAL.add(fileIn[2]);
						dirStack.push(fileIn[2]);
					}
				}
			}
		}
		
		for (String word: directoryAL) {
			System.out.println(word);
		}
		System.out.println("dirStack");
		for(String word: dirStack) {
			System.out.println(word);
		}
	}
}
