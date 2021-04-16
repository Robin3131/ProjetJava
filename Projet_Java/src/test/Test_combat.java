package test;

import affrontement.Combat;
//import labyrinthe.java.Labyrinthe;
import personnage.Heros;
import personnage.Monstre;
import vue.Clavier;

public class Test_combat {
	public static void main(String[] args) {
		Heros mec = new Heros();
		mec.nommerHeros();
		//combat commence
		Combat testC = new Combat();
		switch(testC.battle(mec)) {
		case 0:
			System.out.println("vous fuyez");
			//lastPosition = position
			break;
			
		case 1:
			//défaite
			System.out.println("Défaite");
			break;
			
		case 2:
			testC.gagnerCombat(mec);
			//victoire
			break;
			
			
		}
		
		
		
}
}