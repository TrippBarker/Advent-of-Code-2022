package adventDay2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	
	public static FileReader fr;
	public static Scanner sc;
	
	public static char elfMove;
	public static char myMove;
	public static String game;
	public static int score = 0;

	public static void main(String[] args) {
		try {
			fr = new FileReader("rps.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		
		while (sc.hasNextLine()) {
			game = sc.nextLine();
			elfMove = game.charAt(0);
			myMove = game.charAt(2);
			if (myMove == 'X') {
				score += 0;
				if (elfMove == 'A') {
					score += 3;
				} else if (elfMove == 'B') {
					score += 1;
				} else {
					score += 2;
				}
			} else if (myMove == 'Y') {
				score += 3;
				if (elfMove == 'A') {
					score += 1;
				} else if (elfMove == 'B') {
					score += 2;
				} else {
					score += 3;
				}
			} else {
				score += 6;
				if (elfMove == 'A') {
					score += 2;
				} else if (elfMove == 'B') {
					score += 3;
				} else {
					score += 1;
				}
			}
		}
		System.out.println(score);
	}

}
