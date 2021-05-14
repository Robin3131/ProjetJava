package personnage;

public abstract class EtreVivant {
	protected int vie;
	protected int degat;
	
	/**
	 * Cr�e un �tre vivant
	 * @param vie (int) pdv de l'�tre vivant
	 * @param degat (int) d�gats de l'�tre vivant
	 */
	public EtreVivant(int vie, int degat) {
		this.vie = vie;
		this.degat = degat;

	}
	
	/**
	 * Retourne la vie de l'�tre vivant
	 * @return int
	 */
	public int getVie() {
		return vie;
	}
	/**
	 * Modifie la vie de l'�tre vivant
	 * @param vie (int) nouveaux pdv de l'�tre vivant
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	//d�claration de la m�thode attaquer
	public abstract void attaquer (EtreVivant e);
}
