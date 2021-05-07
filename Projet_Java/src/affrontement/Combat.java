package affrontement;

import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import personnage.Heros;
import personnage.Monstre;
import vue.Clavier;

public class Combat {

	public int choixAttaquant() {
		return (int) (Math.random() * 2 + 1);
	}

	public void prendrePotion(Heros h) {
		System.out.println("Entrez le nom de la potion que vous voulez utiliser (exemple pour utiliser la super potion : \"super\"");
		System.out.println("Vous avez " + h.getVie() + "pv et vos pv max sont de : " + h.getVieMax());
		System.out.println("Quel potion voulez-vous utiliser ?");
		System.out.println("Vous avez " + h.getPotion()[0] + " " + Potion.values()[0].getNom() + " qui soigne de "
				+ Potion.values()[0].getRegen());
		System.out.println("Vous avez " + h.getPotion()[1] + " " + Potion.values()[1].getNom() + " qui soigne de "
				+ Potion.values()[1].getRegen());
		System.out.println("Vous avez " + h.getPotion()[2] + " " + Potion.values()[2].getNom() + " qui soigne de "
				+ Potion.values()[2].getRegen() + "\n") ;

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
		if (i != 3) { // Si l'utilisateur a rentré un choix valide :
			if (h.getPotion()[i] > 0) {
				h.setVie(h.getVie() + Potion.values()[i].getRegen());
				if (h.getVie() > h.getVieMax()) {
					h.setVie(h.getVieMax());
				}
				h.getPotion()[i] -= 1;
				System.out.println("Vous avez pris la potion, Vous avez maintenant " + h.getVie() + "pv\n");
			} else {
				System.out.println("Vous ne possédez pas cette potion \n");
			}

		}
	}

	public int battle(Heros h) {
		Monstre m = new Monstre();
		System.out.println("Vous tombez sur un monstre ! Le combat commence.");

		while (m.getVie() > 0) {
			System.out.println("Quelle action voulez vous faire ?");
			System.out.println("1. Combattre");
			System.out.println("2. Fuir");
			if (h.getVie() != h.getVieMax()) {
				System.out.println("3. Utiliser une potion");
			}
			int temp = Clavier.entrerClavierInt();
			if (temp == 3 && (h.getVie() != h.getVieMax())) {
				prendrePotion(h);
			}
			if (temp == 2) {

				return 0;
			}
			if (temp == 1) {
				System.out.println("Vous choississez de combattre");
				int num = choixAttaquant();
				if (num == 1) {
					h.attaquer(m);
				} else {
					m.attaquer(h);
				}

			}
			if (h.getVie() <= 0) {

				// System.out.println("vous avez perdu");
				return 2;
			}

		}
		gagnerCombat(h);
		return 1;
	}

	public void gagnerCombat(Heros h) {
		h.setVieMax((h.getVieMax() + 1));
		System.out.println("Vous avez gagné le combat ! \nVous avez maintenant " + h.getVie() + " point de vie");
		herosDrop(h);
		System.out.println(h.getArme());
		System.out.println(h.getArmure());
	}

	public void herosDrop(Heros H) {

		if (randomDrop(1, 3)) {
			// drop d'une armure
			System.out.println("Drop armure");
			if (H.getArmure() == null) {
				H.setArmure(Armure.ARMUREC);
			} else {
				H.setArmure(H.getArmure().getArmureSup());
			}
		} else if (randomDrop(1, 3)) {
			// drop d'une arme
			System.out.println("Drop arme");
			if (H.getArme() == null) {
				H.setArme(Arme.ARMEB);
			} else {
				H.setArme(H.getArme().getArmeSup());
			}
		} else {
			// drop argent
			System.out.println("money");
			H.setArgent(H.getArgent() + 100);
		}
	}

	public boolean randomDrop(int minimum, int maximum) {
		int Randnum = (int) (Math.random() * maximum + minimum);
		if (Randnum == minimum) {
			return true;
		}
		return false;
	}
}
