package personnage;

public abstract class EtreVivant {
	protected int vie;
	protected int degat;
	
	/**
	 * Crée un être vivant
	 * @param vie (int) pdv de l'être vivant
	 * @param degat (int) dégats de l'être vivant
	 */
	public EtreVivant(int vie, int degat) {
		this.vie = vie;
		this.degat = degat;

	}
	
	/**
	 * Retourne la vie de l'être vivant
	 * @return int
	 */
	public int getVie() {
		return vie;
	}
	/**
	 * Modifie la vie de l'être vivant
	 * @param vie (int) nouveaux pdv de l'être vivant
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	//déclaration de la méthode attaquer
	public abstract void attaquer (EtreVivant e);
}
