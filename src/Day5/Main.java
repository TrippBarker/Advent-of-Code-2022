package Day5;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static FileReader fr;
	public static Scanner sc;
	public static String[] stacks;
	public static int counter = 0;
	public static boolean haveInitialStack = false;
	public static String[] stackVals;
	
	public static int index = 0;
	
	public static String stackInput;

	public static void main(String[] args) {
		try {
			fr = new FileReader("stacks.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		while (sc.hasNext()) {
			stackInput = sc.nextLine();
			if(counter == 0) {
				counter = stackInput.length();
				stacks = new String[9];
			}
			if (true) {
				if (stackInput.equals(" 1   2   3   4   5   6   7   8   9 ")) {
					haveInitialStack = true;
					sc.nextLine();
				} else if(stackInput.charAt(0) == 'm'){
					stackVals = stackInput.split(" ");
					int move = Integer.valueOf(stackVals[1]);
					String firstStack = stacks[Integer.valueOf(stackVals[3]) -1];
					String secStack = stacks[Integer.valueOf(stackVals[5]) -1];
					stacks[Integer.valueOf(stackVals[3])-1] = firstStack.substring(0, firstStack.length()-move);
					stacks[Integer.valueOf(stackVals[5])-1] += firstStack.substring(firstStack.length()-move);
				} else {
					stackVals = new String[]{
							String.valueOf(stackInput.charAt(1)),
							String.valueOf(stackInput.charAt(5)),
							String.valueOf(stackInput.charAt(9)),
							String.valueOf(stackInput.charAt(13)),
							String.valueOf(stackInput.charAt(17)),
							String.valueOf(stackInput.charAt(21)),
							String.valueOf(stackInput.charAt(25)),
							String.valueOf(stackInput.charAt(29)),
							String.valueOf(stackInput.charAt(33))
					};
					for (String val: stackVals) {
						if (!(val.equals(" "))) {
							if (stacks[index] == null) {
								stacks[index] = val;
							} else {
								stacks[index] = val + stacks[index];
							}
							index++;
						} else {
							index++;
						}
						if (index == 9) {
							index = 0;
						}
					}
				}
			}
		}
		for(String stack: stacks) {
			System.out.println(stack);
		}
	}

}
