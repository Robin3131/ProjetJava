package personnage;

public class Monstre extends EtreVivant {
	
	/**Créé un Monstre (2 pv, 3 d'attaque)
	 */
	public Monstre() {
		super(2, 3);
	}
	
	/**Retourne les dégats du monstre
	 * @return int
	 */
	public int getDegat() {
		return degat;
	} 
	
	/**Modifie les dégats du monstre
	 * @param degat (int)
	 */
	public void setDegat(int degat) {
		this.degat = degat;
	}
	
	/**Modifie les point de vie et les dégats du monstre pour créer le boss (100 pv, 10 d'attaque)
	 */
	public void boss() {
		setVie(20);
		setDegat(10);
		System.out.println("Vous tombez sur le boss du labyrinthe ! Le combat commence.");
		System.out.println("Il a " + getVie() + " pv et il frappe à " + getDegat() );
	}
	
	
	/**Fonction qui inflige des dégats au héros passé en paramètre en fonction de sa résistance
	 * @param e (type "EtreVivant") heros cible de l'attaque
	 */
	public void attaquer(EtreVivant e) {
		System.out.println("\nVous choississez de combattre et le monstre vous attaque");
		int degat = this.degat;
		if (e instanceof Heros) {
			Heros h = (Heros) e;
			if (h.getArmure() != null) {//Adaptation des dégats en fonction de l'armure du heros
				degat = degat - h.getArmure().getResistance();
			}

			if (degat < 0) {//Cas ou les dégats sont entièrement bloqués
				System.out.println("L'armure a bloqué les dégats.... La chance !Vous avez encore" + h.getVie() + " point de vie");
			} else {//Inflige les dégats au héros
				h.setVie(h.getVie() - degat);
				if(h.getVie()>0) {//Affichage si le heros ne meurt pas
					System.out.println(
							"Vous subissez " + degat + " pts de dégats. Il vous reste " + h.getVie() + " point de vie");
				}else {//Affichage si le heros meurt
					System.out.println(
							"Vous subissez " + degat + " pts de dégats..... Vous mourez!");
				}
				
			}
		}

	}

}
