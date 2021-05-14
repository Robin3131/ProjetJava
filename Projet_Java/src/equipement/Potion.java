package equipement;

public enum Potion {
	PPOTION("Petite potion",5, 200), MPOTION("Moyenne Potion",7, 400), SPOTION("Super potion",10, 800);

	private String nom;
	private int regen;
	private int prix;
	/**
	 * Ajoute une potion 
	 * @param nom de la potion (String) 
	 * @param regénération de la potion (int)
	 * @param prix de la potion (int)
	 */
	private Potion(String nom, int regen, int prix) {
		this.nom = nom;
		this.regen = regen;
		this.prix = prix;
	}
	/**
	 * Retourne le nom de la potion
	 * @return string
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Retourne la régénération de la potion
	 * @return int
	 */
	public int getRegen() {
		return regen;
	}
	/**
	 * Retourne le prix
	 * @return int
	 */
	public int getPrix() {
		return prix;
	}

}
