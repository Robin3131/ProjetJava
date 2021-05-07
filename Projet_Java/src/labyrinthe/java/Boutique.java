package labyrinthe.java;

import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import personnage.Heros;
import vue.Clavier;

public class Boutique {
	public void acheter(Heros h) {
		System.out.println("Bienvenue dans ma boutique étranger !");
		System.out.println("Que voulez achetez ?");
		System.out.println("Tapez 1 pour acheter une arme, tapez 2 pour acheter une armure ou tapez 3 pour acheter des potions");
		int choix = Clavier.entrerClavierInt();
		switch(choix) {
		case 1 :
			System.out.println("");
			break;
		case 2 :
			break;
		case 3 :
			break;
		default :
			System.out.println("ptdr brooo");
			break;
		}
		
	}
	
	public void afficherEquipement(int choixType) {
		//for
		
	}
}
