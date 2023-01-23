package Day11;

import java.util.ArrayList;

public class Monkey {
	private ArrayList<Integer> items;
	private int ifTrue;
	private int ifFalse;
	private int test;
	
	public Monkey(int test) {
		this.test = test;
		this.ifFalse = 0;
		this.ifTrue = 0;
	}
	
	public void setTest(Integer test) {
		this.test = test;
	}
	
	public void setIfTrue(int ifTrue) {
		this.ifTrue = ifTrue;
	}
	
	public void setIfFalse(int ifFalse) {
		this.ifFalse = ifFalse;
	}
	
	public void catchItem(int item) {
		this.items.add(item);
	}
	
	public int throwItem() {
		int retItem = items.get(0);
		items.remove(0);
		return retItem;
	}
}
