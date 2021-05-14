package equipement;

public enum Armure {
	ARMUREC("cuir", 1, 200), ARMUREM("maille", 2, 400), ARMUREF("fer", 3, 600), ARMUREA("acier", 4, 800), ARMURED("diamond", 5, 1000);

	private String nom;
	private int resistance;
	private int prix;
	/**
	 * Cr�e une armure
	 * @return rien 
	 * @param nom de l'armure (String) 
	 * @param r�sistance de l'armure (int)
	 * @param prix de l'armure (int)
	 */
	Armure(String nom, int resistance, int prix) {
		this.nom = nom;
		this.resistance = resistance;
		this.prix = prix;
	}
	/**
	 * Retourne le nom de l'armure
	 * @return string
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Retourne la r�sistance de l'armure
	 * @return int
	 */
	public int getResistance() {
		return resistance;
	}
	/**
	 * Retourne le prix de l'armure
	 * @return int
	 */
	public int getPrix() {
		return prix;
	}
	/**
	 * Fonction qui retourne l'armure sup�rieure
	 * @return objet de type Armure
	 */
	public Armure getArmureSup() {
		if (this.ordinal() + 1 == Armure.values().length) {
			System.out.println("Impossible d'am�liorer l'armure");
			return this;
		}

		return Armure.values()[this.ordinal() + 1];
	}
	
}