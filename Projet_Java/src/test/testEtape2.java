package test;

import personnage.Heros;
import vue.Clavier;

public class testEtape2 {

	public static void main(String[] args) {
		/*Heros mec = new Heros();
		mec.nommerHeros();
		boolean res =mec.seDeplacer();
		if(res) {
			System.out.println("vous avez perdu!");
		}*/
		int choix;
		boolean res;
		do {
			Heros mec = new Heros();
			mec.nommerHeros();
			res =mec.seDeplacer();
			if(res) {
				System.out.println("vous avez perdu!");
			}
			System.out.println("Pour recommencer la partie, entrer 1\nPour quitter le jeu, entrer 2  ");
			choix=Clavier.entrerClavierInt();
		}while(choix != 2);
		
	}
}
