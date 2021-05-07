package personnage;

public class Monstre extends EtreVivant {

	public Monstre() {
		super(3, 3);

	}

	public void attaquer(EtreVivant e) {
		System.out.println("\nLe monstre vous attaque");
		int degat = this.degat;
		if (e instanceof Heros) {
			Heros h = (Heros) e;
			if (h.getArmure() != null) {
				degat = degat - h.getArmure().getResistance();
			}

			if (degat < 0) {
				System.out.println("L'armure a bloqué les dégats \nVous avez " + h.getVie() + " point de vie");
			} else {
				h.setVie(h.getVie() - degat);
				System.out.println(
						"Vous subissez " + degat + " pts de dégats \nIl vous reste " + h.getVie() + " point de vie");
			}
		}

	}

}
