package affrontement;

import personnage.Heros;
import personnage.Monstre;
import vue.Clavier;

public class Combat {

	public int choixAttaquant() {
		return (int) (Math.random() * 2 + 1);
	}

	public void battle(Heros h) {
		Monstre m = new Monstre();
		System.out.println("Vous tombez sur un monstre ! Le combat commence.");

		while (m.getVie() > 0) {
			System.out.println("Quelle action voulez vous faire ?");
			System.out.println("1. Combattre");
			System.out.println("2. Fuir");
			int temp = Clavier.entrerClavierInt();
			if (temp == 2) {
				//return 0;
				m.setVie(0);
				h.fuir();
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
				//return 2;
				System.out.println("vous avez perdu");
				break;
			}

		}

		gagnerCombat(h);
	}
	

	public void gagnerCombat(Heros h) {
		h.setVieMax((h.getVieMax() + 1));
		System.out.println("Vous avez gagn� le combat ! \nVous avez maintenant " + h.getVie() + " point de vie");
		h.seDeplacer();
	}
}



/*public int battle(Heros h) {
	Monstre m = new Monstre();
	System.out.println("Vous tombez sur un monstre ! Le combat commence.");

	while (h.getVie() > 0) {
		System.out.println("Quelle action voulez vous faire ?");
		System.out.println("1. Combattre");
		System.out.println("2. Fuir");
		int temp = Clavier.entrerClavierInt();
		if (temp == 2) {
			//return 0;
			System.out.println("vous fuez");
			break;
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
		if (m.getVie() <= 0) {
			//return 2;
			gagnerCombat(h);
		}

	}

	return 1;
}*/