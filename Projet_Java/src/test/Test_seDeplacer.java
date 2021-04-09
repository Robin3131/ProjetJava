package test;

import labyrinthe.java.Labyrinthe;

public class Test_seDeplacer {

	public static void main(String[] args) {
		Labyrinthe lab = new Labyrinthe();
		boolean test;
		test = lab.seDeplacer();
		while(test) {
			test = lab.seDeplacer();
		}
	}

}
