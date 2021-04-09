package test;

import labyrinthe.java.Labyrinthe;
import personnage.Heros;

public class Test_seDeplacer {

	public static void main(String[] args) {
		Labyrinthe lab = new Labyrinthe();
		Heros mec = new Heros();
		mec.nommerHeros();
		boolean test;
		test = lab.seDeplacer();
		while(test) {
			test = lab.seDeplacer();
		}
	}

}
