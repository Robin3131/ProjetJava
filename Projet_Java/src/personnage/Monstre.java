package personnage;

public class Monstre extends EtreVivant {

	public Monstre() {
		
		super(2, 3);

	}
	
	public int getDegat() {
		return degat;
	} 
	
	public void setDegat(int degat) {
		this.degat = degat;
	}

	public void boss() {
		setVie(20);
		setDegat(10);
		System.out.println("Vous tombez sur le boss du labyrinthe ! Le combat commence.");
		System.out.println("Il a " + getVie() + " pv et il frappe à " + getDegat() );
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
