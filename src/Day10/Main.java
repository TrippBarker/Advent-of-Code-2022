package Day9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	
	public static Scanner sc;
	public static FileReader fr;
	
	public static int totalStrength = 0;
	public static int cycle = 0;
	public static int xReg = 1;
	public static String input;
	
	public static void main(String[] args) {
		try {
			fr = new FileReader("signals.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		
		while(sc.hasNext()) {
			input = sc.nextLine();
			if(input.equals("noop")) {
				cycle++;
				checkCycle();
			} else {
				cycle++;
				checkCycle();
				cycle++;
				checkCycle();
				xReg += Integer.valueOf(input.split(" ")[1]);
			}
		}
		System.out.println("TotalStrength: " + totalStrength);

	}
	
	public static void checkCycle() {
		if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
			totalStrength += cycle * xReg;
		}
	}

}
