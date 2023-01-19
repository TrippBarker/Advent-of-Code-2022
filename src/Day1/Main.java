package adventDay1Puzzle1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int mostCals = 0;
	public static int secMost = 0;
	public static int thirdMost = 0;
	public static int currentCals = 0;
	public static FileReader fr;
	public static Scanner sc;
	public static ArrayList<Integer> numsAL = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			fr = new FileReader("numbers.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		while (sc.hasNextLine()) {
			try {
				currentCals += Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException nfe) {
				numsAL.add(currentCals);
				currentCals = 0;
			}
		}
		numsAL.sort(null);
		
		System.out.println(numsAL.get(numsAL.size() -1) + numsAL.get(numsAL.size() -2) + numsAL.get(numsAL.size() -3));
	}

}
