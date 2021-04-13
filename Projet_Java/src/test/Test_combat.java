package test;

import affrontement.Combat;

public class Test_combat {
	public static void main(String[] args) {
		int test;
		Combat testC = new Combat();
		
		for(int i=0;i<10;i++) {
			test = testC.choixAttaquant();
			System.out.println(test);
		}
		
		
}
}