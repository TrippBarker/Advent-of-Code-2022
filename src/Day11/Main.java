package Day11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static Scanner sc;
	public static FileReader fr;
	
	public static void main(String[] args) {
		Monkey monk = new Monkey(10);
		try {
			fr = new FileReader("monkeys.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		System.out.println(monk);
	}

}
