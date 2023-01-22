package Day7;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static FileReader fr;
	public static Scanner sc;
	
	public static String input = "";
	public static int fileSize = 0;
	public static int dirSize = 0;
	public static int counter = 0;
	public static int runningTotal = 0;
	public static int neededSpace = 3313415;
	public static int currentSmallestDir;
	public static int smallestDir = neededSpace * 10;
	public static Stack<String> currentTree = new Stack<>();
	public static Stack<Integer> currentTreeVals = new Stack<>();
	public static Stack<Integer> currentTreeValsCop = new Stack<>();
	public static ArrayList<String> dirs = new ArrayList<>();
	public static ArrayList<Integer> dirSizes = new ArrayList<>(); 
	
	public static void main(String[] args) {
		try {
			fr = new FileReader("filesys.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error with file provided");
		}
		while(sc.hasNext()) {
			input = sc.nextLine();
			if (input.equals("$ cd ..")) {
				currentTree.pop();
				dirSize = currentTreeVals.pop();
				if (dirSize <= 100000) {
					runningTotal += dirSize;
				}
				if (dirSize >= neededSpace && dirSize < smallestDir) {
					smallestDir = dirSize;
				}
				System.out.println(currentTree);
				System.out.println(currentTreeVals);
			} else if (input.substring(0, 4).equals("$ cd")) {
				currentTree.push(input.substring(4));
				currentTreeVals.push(0);
				
			} else if (input.equals("$ ls") || input.substring(0, 3).equals("dir")) {
			} else {
				fileSize = Integer.valueOf(input.split(" ")[0]);
				counter = currentTreeVals.size();
				for (int i = 0; i < counter; i++) {
					dirSize = fileSize + currentTreeVals.pop();
					currentTreeValsCop.push(dirSize);
				}
				for (int i = 0; i < counter; i++) {
					currentTreeVals.push(currentTreeValsCop.pop());
				}
			}
		}
		System.out.println("/ Size: " + currentTreeVals.get(0));
		System.out.println("Space Available: " + (70000000 - currentTreeVals.get(0)));
		System.out.println("Space Needed: " + (30000000 - (70000000 - currentTreeVals.get(0))));
		System.out.println("PartONE: " + runningTotal);
		System.out.println("PartTWO: " + smallestDir);
	}
}
