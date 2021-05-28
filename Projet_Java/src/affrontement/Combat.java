package affrontement;

import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import personnage.Heros;
import personnage.Monstre;
import vue.Clavier;

public class Combat {
	/**
	 * Permet de d�terminer quel joueur peut attaquer
	 * @return Un int qui d�signe quel joueurs attaque : 
	 * 1 = heros attaque, 2 = monstre attaque
	 */
	public int choixAttaquant() {
		return (int) (Math.random() * 2 + 1);
	}

	/**
	 * Affiche a l'utilisateur les potions qu'il poss�de, 
	 * lui demande celle qu'il veut prendre et utilise la potion si il la poss�de
	 * @param le heros
	 */
	public void prendrePotion(Heros h) {
		//propose � l'utilisateur les potions qu'il poss�de
		System.out.println(
				"Entrez le nom de la potion que vous voulez utiliser (exemple pour utiliser la super potion : \"super\"");
		System.out.println("Vous avez " + h.getVie() + "pv et vos pv max sont de : " + h.getVieMax());
		System.out.println("Quel potion voulez-vous utiliser ?");
		System.out.println("Vous avez " + h.getPotion()[0] + " " + Potion.values()[0].getNom() + " qui soigne de "
				+ Potion.values()[0].getRegen());
		System.out.println("Vous avez " + h.getPotion()[1] + " " + Potion.values()[1].getNom() + " qui soigne de "
				+ Potion.values()[1].getRegen());
		System.out.println("Vous avez " + h.getPotion()[2] + " " + Potion.values()[2].getNom() + " qui soigne de "
				+ Potion.values()[2].getRegen() + "\n");

		//r�cup�ration du choix de l'utilisateur
		String choix = Clavier.entrerClavierString();
		int i;
		switch (choix.toLowerCase()) {
		case "petite":
			i = 0;
			break;
		case "moyenne":
			i = 1;
			break;
		case "super":
			i = 2;
			break;
		default:
			i = 3;
			System.out.println("Choix invalide");
			break;
		}
		if (i != 3) { // Si l'utilisateur a rentr� un choix valide, utilisation de la potion
			if (h.getPotion()[i] > 0) {
				h.setVie(h.getVie() + Potion.values()[i].getRegen());
				if (h.getVie() > h.getVieMax()) {
					h.setVie(h.getVieMax());
				}
				h.getPotion()[i] -= 1;
				System.out.println("Vous avez pris la potion, Vous avez maintenant " + h.getVie() + "pv\n");
			} else {
				System.out.println("Vous ne poss�dez pas cette potion \n");
			}

		}
	}
	/**
	 * Cr�e un combat contre un monstre dans lequel le heros peut combattre (mourir ou gagner) ou fuir 
	 * @return un int qui d�termine le r�sultat du combat, 0 = fuite, 1 = gagn�, 2 = perdu
	 * @param h (heros)
	 * @param salleboss (boolean) qui signifie si c'est la salle du boss (true = salle du boss )
	 */
	public int battle(Heros h, boolean salleboss) {
		Monstre m = new Monstre();//cr�ation du monstre
		
		if (salleboss) {//v�rification salle du boss
			m.boss();
		}else {
			System.out.println("ATTENTIONNNN ! Vous tombez sur un monstre, Le combat commence !");
		}
		
		
		while (m.getVie() > 0) {//tant que le monstre est en vie et que le heros n'a pas fuit on continue le combat
			System.out.println("\nQuelle action voulez vous faire ?");
			System.out.println("1. Combattre");
			System.out.println("2. Fuir");
			if (h.getVie() != h.getVieMax()) {
				System.out.println("3. Utiliser une potion");
			}
			int temp = Clavier.entrerClavierInt();
			if (temp == 3 && (h.getVie() != h.getVieMax())) {
				prendrePotion(h);
			}
			if (temp == 2) {//fuite du heros
				return 0;
			}
			if (temp == 1) {
				int num = choixAttaquant();
				if (num == 1) {
					h.attaquer(m);
				} else {
					m.attaquer(h);
				}

			}
			if (h.getVie() <= 0) {//mort du heros
				return 2;
			}

		}
		//Par elimination, victoire du heros
		gagnerCombat(h);
		return 1;
	}
	/**
	 * Effectue la finalisation du combat, le heros gagne 1 pdv et appelle la fonction de drop
	 * @param Le heros h
	 */
	public void gagnerCombat(Heros h) {
		h.setVieMax((h.getVieMax() + 1));
		System.out.println("\nEt...Vous avez gagn� le combat, vous avez maintenant " + h.getVie() + " point de vie !");
		herosDrop(h);
	}
	/**
	 * Fonction de drop des items en fin de combat on ne peut drop que un type d'item par combat
	 * @param Le heros H
	 */
	public void herosDrop(Heros H) {

		if (randomDrop(1, 12)) {// Cas drop d'une armure 1 chance sur 12
			if (H.getArmure() == null) {// si il ne poss�de pas d'armure il r�cup�re une armure en cuir
				H.setArmure(Armure.ARMUREC);
			} else {
				H.setArmure(H.getArmure().getArmureSup()); // Si il a d�j� une armure passe � l'armure sup�rieure
			}
			System.out.println("EXCEPTIONNEL !!!! Ce montre viens de vous dropper une armure");
		}
		else if (randomDrop(1, 12)) {	// Cas drop d'une arme 1 chance sur 12
			if (H.getArme() == null) {// si il ne poss�de pas d'arme il r�cup�re une arme en bois
				H.setArme(Arme.ARMEB);
			} else {
				H.setArme(H.getArme().getArmeSup());// Si il a d�j� une arme passe � l'arme sup�rieure
			}
			System.out.println("MAGNIFIQUE !!!! Ce montre viens de vous dropper une arme");
		} 
		else {//Cas drop d'argent 5 chance sur 6
			System.out.println("\nDe plus, vous appercevez 100 pi�ces d'or � cot� du corps du monstre que vous ramassez\n");
			H.setArgent(H.getArgent() + 100);
		}
	}
	/**
	 * Fonction qui d�termine si un drop est r�alis� en fonction d'un taux pass� en param�tre
	 * La valeur 1 divis� par la valeur 2 donne le taux (valeurs enti�res)
	 * @param minimum valeur 1
	 * @param maximum valeur 2
	 * @return True si le drop est r�alis� sinon false
	 */
	public boolean randomDrop(int minimum, int maximum) {
		int Randnum = (int) (Math.random() * maximum + minimum);
		if (Randnum == minimum) {
			return true;
		}
		return false;
	}
}
