package Day9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static Scanner sc;
	public static FileReader fr;
	
	public static ArrayList<String> hCords= new ArrayList<>();
	public static ArrayList<String> tCords= new ArrayList<>();
	public static int[] currenthCords = {0, 0};
	public static int[] currenttCords = {0, 0};
	public static String input;
	public static char dir;
	public static int dist;
	
	public static void main(String[] args) {
		try {
			fr = new FileReader("testMoves.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		hCords.add(currenthCords[0] + " " + currenthCords[1]);
		tCords.add(currenttCords[0] + " " + currenttCords[1]);
		
		while (sc.hasNext()) {
			input = sc.nextLine();
			dir = input.charAt(0);
			dist = Integer.valueOf(input.split(" ")[1]);
			for (int i = 0; i < dist; i++) {
				moveH();
				System.out.println(currenthCords[0] + ", " + currenthCords[1]);
			}
		}
		
		for(String cords : hCords) {
			System.out.println(cords);
		}
		
	}
	
	public static void moveH() {
		switch (dir) {
			case 'U':
				currenthCords[0]++;
				break;
			case 'D':
				currenthCords[0]--;
				break;
			case 'L':
				currenthCords[1]--;
				break;
			case 'R':
				currenthCords[1]++;
				break;
		}
	}
}
