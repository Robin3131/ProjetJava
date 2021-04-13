package test;

import affrontement.Combat;
import labyrinthe.java.Labyrinthe;
import personnage.Heros;
import personnage.Monstre;

public class Test_combat {
	public static void main(String[] args) {
		int test;
		Combat testC = new Combat();
		Labyrinthe lab = new Labyrinthe();
		Heros mec = new Heros();
		for(int i=0;i<10;i++) {
			test = testC.choixAttaquant();
			System.out.println(test);
		}
		//combat commence
		Monstre monstr = new Monstre();
		boolean fuir;
		fuir = false;
		while(!fuir){
			// voulez vous fuir ?
			int num = testC.choixAttaquant();
			if(num== 1) {
				mec.Attaquer(monstr);
			}else {
				monstr.Attaquer(mec);
			}
			

		}
		
}
}