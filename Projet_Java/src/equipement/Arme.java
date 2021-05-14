package equipement;

public enum Arme {
	ARMEB("bois", 1, 200), ARMEO("or", 2, 400), ARMES("saphir", 3, 600), ARMER("rubis", 4, 800), ARMED("diamant", 5 , 1000);

	private String nom;
	private int degats;
	private int prix;
	/**
	 * Cr�e une arme
	 * @return rien 
	 * @param nom de l'arme (String) 
	 * @param d�gats de l'arme (int)
	 * @param prix de l'arme (int)
	 */
	Arme(String nom, int degats, int prix) {
		this.nom = nom;
		this.degats = degats;
		this.prix = prix;
	}
	/**
	 * Retourne le nom de l'arme
	 * @return string
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Retourne les d�gats de l'arme
	 * @return int
	 */
	public int getDegats() {
		return degats;
	}
	/**
	 * Retourne le prix de l'arme
	 * @return int
	 */
	public int getPrix() {
		return prix;
	}
	/**
	 * Fonction qui retourne l'arme sup�rieure
	 * @return objet de type Arme
	 */
	public Arme getArmeSup() {
		if (this.ordinal() + 1 == Arme.values().length) {
			System.out.println("Impossible d'am�liorer l'arme");
			return this;
		}

		return Arme.values()[this.ordinal() + 1];
	}
}