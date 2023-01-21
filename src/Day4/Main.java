
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static FileReader fr;
	public static Scanner sc;
	
	public static String assignmentOne;
	public static String assignmentTwo;
	public static String assignments;
	public static int aoo;
	public static int aot;
	public static int ato;
	public static int att;
	public static char same;
	public static int total = 0;
	public static int partialOL = 0;
	public static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) {
		try {
			fr = new FileReader("assignments.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		while(sc.hasNext()) {
			assignments = sc.nextLine();
			assignmentOne = assignments.substring(0, assignments.indexOf(','));
			assignmentTwo = assignments.substring(assignments.indexOf(',') + 1);
			try {
				aoo = Integer.parseInt(assignmentOne.substring(0, assignmentOne.indexOf('-')));
				aot = Integer.parseInt(assignmentOne.substring(assignmentOne.indexOf('-') + 1));
				ato = Integer.parseInt(assignmentTwo.substring(0, assignmentTwo.indexOf('-')));
				att = Integer.parseInt(assignmentTwo.substring(assignmentTwo.indexOf('-') + 1));
			} catch (NumberFormatException nfe) {
				System.out.println(nfe);
			}
			if (aoo <= ato && aot >= att) {
				total++;
			} else if (ato <= aoo && att >= aot) {
				total++;
			}
			if (aoo <= att  && aoo >= ato || ato <= aot && ato >= aoo) {
				partialOL++;
			}
		}
		System.out.println("Total overlaps: " + total);
		System.out.println("Partial overlaps: " + partialOL);
	}

}
