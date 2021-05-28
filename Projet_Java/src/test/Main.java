package test;

import labyrinthe.java.Labyrinthe;
import personnage.Heros;
import sauvegarde.Sauvegarde;
import vue.Clavier;

public class Main {

	public static void main(String[] args) {
		String choix;
		boolean res;
		String choixpartie;
		Heros mec = new Heros();
		Labyrinthe lab = new Labyrinthe();
		do {			
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
						mec.nommerHeros();
						System.out.println("\n*********Création d'un nouvelle partie*********\n");
						choixpartie="3";
						break;
					default :
						System.out.println("Veuillez entrer un choix valide :)");
						break;
				}
			}while (!choixpartie.equalsIgnoreCase("3"));
			
			res = mec.seDeplacer(lab);
			
			if (res) {
				System.out.println("Vous avez perdu!");
			}
			System.out.println("Pour recommencer la partie, entrer \"R\"\nPour quitter le jeu, entrer \"Q\" ");
			choix = Clavier.entrerClavierString();
			choix=choix.toUpperCase();
		} while (!choix.equalsIgnoreCase("Q"));
		System.out.println("Merci d'avoir joué !");
	}
}
