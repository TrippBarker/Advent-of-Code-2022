package adventDay8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static FileReader fr;
	public static Scanner sc;
	public static String line;
	public static int[][] numsAL;
	public static boolean[][] canSee;


	public static void main(String[] args) {
		try {
			fr = new FileReader("forest.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		while(sc.hasNext()) {
			line = sc.nextLine();
			numsAL[] =
			for (int i = 0; i < line.length(); i++) {
				nums.add(Integer.valueOf(line.substring(i, i+1)));
				bools.add(true);
			}
			numsAL.add(nums);
			canSee.add(bools);
		}
		for (int i = 1; i < numsAL.size() - 1; i++) {
			for (int j = 1; j < numsAL.get(i).size() - 1; j++) {
				for (int counter = j; counter >= 0; counter--) {
					if(numsAL.get(i).get(counter) >= numsAL.get(i).get(j)) {
						canSee.;
					}
				}
			}
		}
		
		for (ArrayList<Integer> nums : numsAL) {
			System.out.println(nums);
		}
	}

}
