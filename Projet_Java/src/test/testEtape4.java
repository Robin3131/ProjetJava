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
			System.out.println("Voulez vous charger une sauvegarde ou créer une partie (Ecrire \"save\" ou \"new\")");
			do {
				choixpartie= Clavier.entrerClavierString().toUpperCase();
				switch(choixpartie) {
					case "SAVE":
						Sauvegarde save = new Sauvegarde();
						save.recupSauvegarde(lab,mec);
						break;
					case "NEW":
						System.out.println("création d'un nouvelle partie");
						break;
					default :
						System.out.println("Veuillez entrer un choix valide :)");
						break;
				}
				res = mec.seDeplacer(lab);
			}while(choixpartie!="SAVE" || choixpartie!="NEW");
			
			if (res) {
				System.out.println("vous avez perdu!");
			}
			System.out.println("Pour recommencer la partie, entrer 1\nPour quitter le jeu, entrer 2  ");
			choix = Clavier.entrerClavierInt();
		} while (choix != 2);
		System.out.println("Merci d'avoir joué !");
	}
}
