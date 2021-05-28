package personnage;

public class Monstre extends EtreVivant {
	
	/**Cr�� un Monstre (2 pv, 3 d'attaque)
	 */
	public Monstre() {
		super(2, 3);
	}
	
	/**Retourne les d�gats du monstre
	 * @return int
	 */
	public int getDegat() {
		return degat;
	} 
	
	/**Modifie les d�gats du monstre
	 * @param degat (int)
	 */
	public void setDegat(int degat) {
		this.degat = degat;
	}
	
	/**Modifie les point de vie et les d�gats du monstre pour cr�er le boss (100 pv, 10 d'attaque)
	 */
	public void boss() {
		setVie(20);
		setDegat(10);
		System.out.println("Vous tombez sur le boss du labyrinthe ! Le combat commence.");
		System.out.println("Il a " + getVie() + " pv et il frappe � " + getDegat() );
	}
	
	
	/**Fonction qui inflige des d�gats au h�ros pass� en param�tre en fonction de sa r�sistance
	 * @param e (type "EtreVivant") heros cible de l'attaque
	 */
	public void attaquer(EtreVivant e) {
		System.out.println("\nVous choississez de combattre et le monstre vous attaque");
		int degat = this.degat;
		if (e instanceof Heros) {
			Heros h = (Heros) e;
			if (h.getArmure() != null) {//Adaptation des d�gats en fonction de l'armure du heros
				degat = degat - h.getArmure().getResistance();
			}

			if (degat < 0) {//Cas ou les d�gats sont enti�rement bloqu�s
				System.out.println("L'armure a bloqu� les d�gats.... La chance !Vous avez encore" + h.getVie() + " point de vie");
			} else {//Inflige les d�gats au h�ros
				h.setVie(h.getVie() - degat);
				if(h.getVie()>0) {//Affichage si le heros ne meurt pas
					System.out.println(
							"Vous subissez " + degat + " pts de d�gats. Il vous reste " + h.getVie() + " point de vie");
				}else {//Affichage si le heros meurt
					System.out.println(
							"Vous subissez " + degat + " pts de d�gats..... Vous mourez!");
				}
				
			}
		}

	}

}
