package Day9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static Scanner sc;
	public static FileReader fr;
	
	public static int totalStrength = 0;
	public static int cycle = 0;
	public static int oldXReg;
	public static int xReg = 1;
	public static int cycleTracker = 40;
	public static String input;
	public static String row = "###.....................................";
	public static ArrayList<String> rows = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			fr = new FileReader("signals.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		
		while(sc.hasNext()) {
			if(cycleTracker == 40) {
				rows.add("");
				cycleTracker = 0;
			}
			input = sc.nextLine();
			if(input.equals("noop")) {
				cycle++;
				cycleTracker++;
				draw();
				checkCycle();
			} else {
				cycle++;
				cycleTracker++;
				draw();
				checkCycle();
				cycle++;
				cycleTracker++;
				draw();
				checkCycle();
				oldXReg = xReg;
				xReg += Integer.valueOf(input.split(" ")[1]);
				if (oldXReg > xReg) {
					for (int i = 0; i < oldXReg - xReg; i++) {
						moveLeft();
					}
				} if (oldXReg < xReg) {
					for (int i = 0; i < xReg - oldXReg; i++) {
						moveRight();
					}
				}
			}
		}
		System.out.println("TotalStrength: " + totalStrength);
		for (String r : rows) {
			System.out.println(r);
		}
	}
	
	public static void checkCycle() {
		if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
			totalStrength += cycle * xReg;
		}
	}
	
	public static void moveRight() {
		row = row.charAt(row.length() - 1) + row.substring(0, row.length() - 1);
		System.out.println(row);
	}
	
	public static void moveLeft() {
		row = row.substring(1) + row.charAt(0);
		System.out.println(row);
	}
	
	public static void draw() {
		String currentRow = rows.get(rows.size() - 1);
		currentRow += row.charAt(currentRow.length());
		rows.set(rows.size() - 1, currentRow);
	}

}
