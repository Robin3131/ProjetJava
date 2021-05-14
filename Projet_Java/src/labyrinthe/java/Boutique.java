package labyrinthe.java;

import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import personnage.Heros;
import vue.Clavier;

public class Boutique {
	
	/**
	 * Affiche a l'utilisateur les achats possibles pour les potions, les armures, les armes
	 */
	public void afficherChoix() {
		int i;
		System.out.println("Que voulez achetez ?");
		System.out.println(
				"Tapez arme pour afficher les armes, tapez armure pour afficher les armures ou tapez potion pour afficher les potions");
		// récupère le choix de l'utilisateur (affichage potion ou armure ou arme)
		String choix = Clavier.entrerClavierString();
		switch (choix.toLowerCase()) {// selon le choix affiche tout les types d'objets
		//affichage des armes
		case "arme" :
			for (i = 0; i < Arme.values().length; i++) {
				System.out.println(
						"Epée en " + Arme.values()[i].getNom() + " de puissance " + Arme.values()[i].getDegats());
				System.out.println("Prix : " + Arme.values()[i].getPrix() + "\n");
			}
			System.out.println(
					"Quel arme voulez-vous achetez ? Ecrivez le type de l'arme que vous voulez \n(exemple : pour épée en bois ecrire \"bois\")");
			break;
		//affichage des armures
		case "armure":
			for (i = 0; i < Armure.values().length; i++) {
				System.out.println("Armure en " + Armure.values()[i].getNom() + " de résistance "
						+ Armure.values()[i].getResistance());
				System.out.println("Prix : " + Armure.values()[i].getPrix() + "\n");
			}
			System.out.println(
					"Quel armure voulez-vous achetez ? Ecrivez le type de l'armure que vous voulez \n(exemple : pour armure en cuir ecrire \"cuir\")");
			break;
		//affichage des potions
		case "potion":
			for (i = 0; i < Potion.values().length; i++) {
				System.out.println(Potion.values()[i].getNom() + " de soin " + Potion.values()[i].getRegen() + "pv");
				System.out.println("Prix : " + Potion.values()[i].getPrix() + "\n");
			}
			System.out.println(
					"Quel potion voulez-vous achetez ? Ecrivez la puissance de la potion que vous voulez \n(exemple : pour une petite potion de soin 5 ecrire \"petite\")");
			break;
		//Choix utilisteur invalide
		default:
			System.out.println("Entrez un nombre valide");
			break;
		}

	}
	/**
	 * Vérifie si le le héros a assez d'argent pour acheter l'arme. 
	  * Si il a assez d'argent et que l'arme est meilleure lui achète l'arme et prélève l'argent.
	 * Sinon lui affiche qu'il n'a pas l'argent, ou lui demande si il confirme son achat.
	 * @param h , le héros de type heros
	 * @param a , l'arme qu'il veut acheter de type Arme
	 */
	public void verifPrixArme(Heros h, Arme a) {
		if (h.getArgent() >= a.getPrix()) {//Si il possède assez d'argent
			if (h.getArme() != null) {// Si il a déjà une arme
				if (h.getArme().getDegats() < a.getDegats()) {//Vérifie que l'arme voulue est meilleure
					h.setArme(a);
					h.setArgent(h.getArgent() - a.getPrix());
					System.out.println("Vous avez acheté une épée en " + a.getNom());
				} else if (h.getArme().getDegats() == a.getDegats()) {// Si il possède déjà l'arme
					System.out.println("Vous possédez déjà cette arme");
				} else {// si l'arme est moins puissante
					System.out.println(
							"Voulez-vous vraiment une arme moins puissante que celle que vous possédez déjà ? oui ou non");
					String reponse = Clavier.entrerClavierString();
					if (reponse.equalsIgnoreCase("oui")) {
						h.setArme(a);
						h.setArgent(h.getArgent() - a.getPrix());
						System.out.println("Vous avez acheté une épée en " + a.getNom());
					}
				}
			} else { //Si il n'a pas d'arme, achat normal
				h.setArme(a);
				h.setArgent(h.getArgent() - a.getPrix());
				System.out.println("Vous avez acheté une épée en " + a.getNom());
			}
		}else {//Si il ne possède pas assez d'argent
			System.out.println("Vous n'avez pas assez d'argent");
		}
	}
	/**
	 * Vérifie si le le héros a assez d'argent pour acheter l'armure. 
	 * Si il a assez d'argent et que l'armure est meilleure lui achète l'armure et prélève l'argent.
	 * Sinon lui affiche qu'il n'a pas l'argent, ou lui demande si il confirme son achat.
	 * @param h , le héros de type heros
	 * @param a , l'armure qu'il veut acheter de type Armure
	 */
	public void verifPrixArmure(Heros h, Armure a) {
		if (h.getArgent() >= a.getPrix()) {
			if (h.getArmure() != null) {
				if (h.getArmure().getResistance() < a.getResistance()) {
					h.setArmure(a);
					h.setArgent(h.getArgent() - a.getPrix());
					System.out.println("Vous avez acheté une armure en : " + a.getNom());
				} else if (h.getArmure().getResistance() == a.getResistance()) {
					System.out.println("Vous possédez déjà cette armure");
				} else {
					System.out.println(
							"Voulez-vous vraiment une armure moins résistante que celle que vous possédez déjà ? oui ou non");
					String reponse = Clavier.entrerClavierString();
					if (reponse.equalsIgnoreCase("oui")) {
						h.setArmure(a);
						h.setArgent(h.getArgent() - a.getPrix());
						System.out.println("Vous avez acheté une armure en : " + a.getNom());
					}
				}
			} else {
				h.setArmure(a);
				h.setArgent(h.getArgent() - a.getPrix());
				System.out.println("Vous avez acheté une armure en : " + a.getNom());
			}
		}else {
			System.out.println("Vous n'avez pas assez d'argent");
		}
	}
	/**
	 * Vérifie si le le héros a assez d'argent pour acheter la potion. 
	 * Si il a assez d'argent, lui achète la potion et prélève l'argent.
	 * Sinon lui affiche qu'il n'a pas l'argent
	 * @param h , le héros de type heros
	 * @param p , la potion qu'il veut acheter de type Potion
	 */
	public void verifPrixPotion(Heros h, Potion p) {
		if (h.getArgent() >= p.getPrix()) {
			h.getPotion()[p.ordinal()] += 1;
			h.setArgent(h.getArgent() - p.getPrix());
			System.out.println("Vous avez acheté : " + p.getNom());
		}else {
			System.out.println("Vous n'avez pas assez d'argent");
		}
	}
	/**
	 * Fonction qui récupère le choix de l'utilisateur sur l'équipement qu'il veut acheter
	 * et appelle les fonctions de vérification de prix
	 * @param h le heros de type heros
	 */
	public void acheter(Heros h) {
		String rep;
		System.out.println("Bienvenue dans ma boutique étranger !");
		do {
			System.out.println("Vous avez " + h.getArgent() + " pièces d'or\n");
			afficherChoix();
			String reponse = Clavier.entrerClavierString();
			reponse.toLowerCase();
			//vérification que le heros a assez d'argent
			if (reponse.equals("bois")) {
				verifPrixArme(h, Arme.ARMEB);
			} else if (reponse.equals("or")) {
				verifPrixArme(h, Arme.ARMEO);
			} else if (reponse.equals("saphir")) {
				verifPrixArme(h, Arme.ARMES);
			} else if (reponse.equals("rubis")) {
				verifPrixArme(h, Arme.ARMEB);
			} else if (reponse.equals("diamant")) {
				verifPrixArme(h, Arme.ARMED);
			} else if (reponse.equals("cuir")) {
				verifPrixArmure(h, Armure.ARMUREC);
			} else if (reponse.equals("maille")) {
				verifPrixArmure(h, Armure.ARMUREM);
			} else if (reponse.equals("fer")) {
				verifPrixArmure(h, Armure.ARMUREF);
			} else if (reponse.equals("acier")) {
				verifPrixArmure(h, Armure.ARMUREA);
			} else if (reponse.equals("diamond")) {
				verifPrixArmure(h, Armure.ARMURED);
			} else if (reponse.equals("petite")) {
				verifPrixPotion(h, Potion.PPOTION);
			} else if (reponse.equals("moyenne")) {
				verifPrixPotion(h, Potion.MPOTION);
			} else if (reponse.equals("super")) {
				verifPrixPotion(h, Potion.SPOTION);
			} else {
				System.out.println("Choix invalide");
			}
			System.out.println("Il vous reste " + h.getArgent() + " pièces d'or");
			System.out.println("Voulez-vous continuer à faire des achats ? oui ou non");
			rep = Clavier.entrerClavierString();
		}while(rep.equalsIgnoreCase("oui"));
		

	}
	
}
