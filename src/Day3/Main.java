package Day3;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static FileReader fr;
	public static Scanner sc;
	
	public static String sackOne;
	public static String sackTwo;
	public static String sackThree;
	public static char same;
	public static int total = 0;
	public static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) {
		try {
			fr = new FileReader("rucksack.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		while (sc.hasNext()) {
			sackOne = sc.nextLine();
			sackTwo = sc.nextLine();
			sackThree = sc.nextLine();
			for (char letter : sackOne.toCharArray()) {
				if(sackTwo.contains(String.valueOf(letter)) && sackThree.contains(String.valueOf(letter))) {
					same = letter;
				}
			}
			total += alphabet.indexOf(same) + 1;
		}
		System.out.println(total);
	}

}
