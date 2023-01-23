package Day11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	
	public static Scanner sc;
	public static FileReader fr;
	
	public static void main(String[] args) {
		try {
			fr = new FileReader("testMonkeys.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
	}

}
