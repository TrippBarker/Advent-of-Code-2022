package Day8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static FileReader fr;
	public static Scanner sc;
	public static ArrayList<ArrayList<Integer>> forest = new ArrayList<>();
	public static String input;
	public static int index = 0;
	public static int visableTrees = 0;
	public static boolean canSee = true;
	public static boolean counted = false;
	public static int currentTree;
	public static int scenicCounter = 0;
	public static int currentScenicScore = 0;
	public static int highestScenicScore = 0;

	public static void main(String[] args) {
		try {
			fr = new FileReader("forest.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe){
			System.out.println("File Not Found");
		}
		while (sc.hasNext()) {
			input = sc.nextLine();
			forest.add(new ArrayList<>());
			for(String num : input.split("")) {
				forest.get(index).add(Integer.valueOf(num));
			}
			index++;
		}
		for (int i = 0; i < forest.size(); i++) {
			for (int j = 0; j < forest.get(i).size(); j++) {
				currentTree = forest.get(i).get(j);
				currentScenicScore = 0;
				canSee = true;
				counted = false;
				checkIfBorder(i, j);
				if(canSee && !counted) {
					counted = true;
					visableTrees++;
				}
				canSee = true;
				checkToTheRight(i, j);
				if (canSee && !counted) {
					counted = true;
					visableTrees++;
				}
				currentScenicScore = scenicCounter;
				canSee = true;
				checkToTheLeft(i, j);
				if (canSee && !counted) {
					counted = true;
					visableTrees++;
				}
				currentScenicScore *= scenicCounter;
				canSee = true;
				checkAbove(i, j);
				if (canSee && !counted) {
					counted = true;
					visableTrees++;
				}
				currentScenicScore *= scenicCounter;
				canSee = true;
				checkBelow(i, j);
				if (canSee && !counted) {
					visableTrees++;
				}
				currentScenicScore *= scenicCounter;
				if (currentScenicScore > highestScenicScore) {
					highestScenicScore = currentScenicScore;
				}
			}
		}
		System.out.println("Total Visable Trees: " + visableTrees);
		System.out.println("Highest Scenic Score: " + highestScenicScore);
	}
	
	public static void checkIfBorder(int i, int j) {
		if (i == 0 || i == 98 || j == 0 || j == 98) {
			canSee = true;
		} else {
			canSee = false;
		}
	}
	
	public static void checkToTheRight(int i, int j) {
		scenicCounter = 0;
		for (int k = j +1; k < forest.get(i).size(); k++) {
			scenicCounter++;
			if (forest.get(i).get(k) >= currentTree) {
				canSee = false;
				break;
			}
		}
	}
	
	public static void checkToTheLeft(int i, int j) {
		scenicCounter = 0;
		for (int k = j -1; k >= 0; k--) {
			scenicCounter++;
			if (forest.get(i).get(k) >= currentTree) {
				canSee = false;
				break;
			}
		}
	}
	
	public static void checkAbove(int i, int j) {
		scenicCounter = 0;
		for (int k = i +1; k < forest.size(); k++) {
			scenicCounter++;
			if (forest.get(k).get(j) >= currentTree) {
				canSee = false;
				break;
			}
		}
	}
	
	public static void checkBelow(int i, int j) {
		scenicCounter = 0;
		for (int k = i -1; k >=0; k--) {
			scenicCounter++;
			if (forest.get(k).get(j) >= currentTree) {
				canSee = false;
				break;
			}
		}
	}

}
