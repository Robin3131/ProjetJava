package test;

import affrontement.Combat;


public class Testrandom {
	public static void main(String[] args) {
		Combat combat = new Combat();
		int b=0;
		for(int i=0;i<1000;i++) {
			if(combat.randomDrop(1,11)) {
				b=b+1;
			}
		}
		System.out.println(b);
	}
}
