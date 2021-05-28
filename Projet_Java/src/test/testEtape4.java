package test;

import labyrinthe.java.Labyrinthe;
import personnage.Heros;
import sauvegarde.Sauvegarde;
import vue.Clavier;

public class testEtape4 {

	public static void main(String[] args) {
		int choix;
		boolean res;
		String choixpartie;
		do {
			Heros mec = new Heros();
			mec.nommerHeros();
			Labyrinthe lab = new Labyrinthe();
			
			do {
				System.out.println("Voulez vous charger une sauvegarde ou créer une partie (Ecrire \"save\" ou \"new\")");
				choixpartie= Clavier.entrerClavierString();
				choixpartie=choixpartie.toUpperCase();
				switch(choixpartie) {
					case "SAVE":
						Sauvegarde save = new Sauvegarde();
						choixpartie=save.recupSauvegarde(lab,mec);
						break;
					case "NEW":
						System.out.println("création d'un nouvelle partie");
						choixpartie="3";
						break;
					default :
						System.out.println("Veuillez entrer un choix valide :)");
						break;
				}
			}while (choixpartie!="3");
			
			res = mec.seDeplacer(lab);
			
			if (res) {
				System.out.println("vous avez perdu!");
			}
			System.out.println("Pour recommencer la partie, entrer 1\nPour quitter le jeu, entrer 2  ");
			choix = Clavier.entrerClavierInt();
		} while (choix != 2);
		System.out.println("Merci d'avoir joué !");
	}
}
