package Day9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static Scanner sc;
	public static FileReader fr;
	
	public static ArrayList<String> tCords= new ArrayList<>();
	public static int[] currenthCords = {0, 0};
	public static int[] current2Cords = {0, 0};
	public static int[] current3Cords = {0, 0};
	public static int[] current4Cords = {0, 0};
	public static int[] current5Cords = {0, 0};
	public static int[] current6Cords = {0, 0};
	public static int[] current7Cords = {0, 0};
	public static int[] current8Cords = {0, 0};
	public static int[] current9Cords = {0, 0};
	public static int[] currenttCords = {0, 0};
	public static String input;
	public static char dir;
	public static int dist;
	
	public static void main(String[] args) {
		try {
			fr = new FileReader("moves.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		tCords.add(currenttCords[0] + " " + currenttCords[1]);
		
		while (sc.hasNext()) {
			input = sc.nextLine();
			dir = input.charAt(0);
			dist = Integer.valueOf(input.split(" ")[1]);
			for (int i = 0; i < dist; i++) {
				moveH();
				if (Math.abs(currenthCords[0] - current2Cords[0]) > 1 || Math.abs(currenthCords[1] - current2Cords[1]) >1) {
					moveKnot(currenthCords, current2Cords);
				}
				if (Math.abs(current2Cords[0] - current3Cords[0]) > 1 || Math.abs(current2Cords[1] - current3Cords[1]) >1) {
					moveKnot(current2Cords, current3Cords);
				}
				if (Math.abs(current3Cords[0] - current4Cords[0]) > 1 || Math.abs(current3Cords[1] - current4Cords[1]) >1) {
					moveKnot(current3Cords, current4Cords);
				}
				if (Math.abs(current4Cords[0] - current5Cords[0]) > 1 || Math.abs(current4Cords[1] - current5Cords[1]) >1) {
					moveKnot(current4Cords, current5Cords);
				}
				if (Math.abs(current5Cords[0] - current6Cords[0]) > 1 || Math.abs(current5Cords[1] - current6Cords[1]) >1) {
					moveKnot(current5Cords, current6Cords);
				}
				if (Math.abs(current6Cords[0] - current7Cords[0]) > 1 || Math.abs(current6Cords[1] - current7Cords[1]) >1) {
					moveKnot(current6Cords, current7Cords);
				}
				if (Math.abs(current7Cords[0] - current8Cords[0]) > 1 || Math.abs(current7Cords[1] - current8Cords[1]) >1) {
					moveKnot(current7Cords, current8Cords);
				}
				if (Math.abs(current8Cords[0] - current9Cords[0]) > 1 || Math.abs(current8Cords[1] - current9Cords[1]) >1) {
					moveKnot(current8Cords, current9Cords);
				}
				if (Math.abs(current9Cords[0] - currenttCords[0]) > 1 || Math.abs(current9Cords[1] - currenttCords[1]) >1) {
					moveKnot(current9Cords, currenttCords);
				}
				System.out.println("H: " + currenthCords[0] + ", " + currenthCords[1]);
				System.out.println("T: " + currenttCords[0] + ", " + currenttCords[1]);
			}
		}
		System.out.println("Squares visited by tails: " + tCords.size());
		
	}
	
	public static void moveH() {
		switch (dir) {
			case 'U':
				System.out.println("Move UP");
				currenthCords[0]++;
				break;
			case 'D':
				System.out.println("Move DOWN");
				currenthCords[0]--;
				break;
			case 'L':
				System.out.println("Move LEFT");
				currenthCords[1]--;
				break;
			case 'R':
				System.out.println("Move RIGHT");
				currenthCords[1]++;
				break;
		}
	}
	
	public static void moveKnot(int[] first, int[] sec) {
		if (first[0] - sec[0] > 0) {
			sec[0]++;
		} else if (first[0] - sec[0] < 0) {
			sec[0]--;
		}
		if (first[1] - sec[1] > 0) {
			sec[1]++;
		} else if (first[1] - sec[1] < 0) {
			sec[1]--;
		}
		if (!tCords.contains(currenttCords[0] + " " + currenttCords[1])) {
			tCords.add(currenttCords[0] + " " + currenttCords[1]);
		}
	}
}
