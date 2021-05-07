package equipement;

public enum Armure {
	ARMUREC("cuir", 1, 200), ARMUREF("fer", 2, 400), ARMUREO("or", 3, 600), ARMURER("rubis", 4, 800), ARMURED("diamant", 5, 1000);

	private String nom;
	private int resistance;
	private int prix;

	Armure(String nom, int resistance, int prix) {
		this.nom = nom;
		this.resistance = resistance;
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public int getResistance() {
		return resistance;
	}
	
	public int getPrix() {
		return prix;
	}

	public Armure getArmureSup() {
		if (this.ordinal() + 1 == Armure.values().length) {
			System.out.println("Impossible d'améliorer l'armure");
			return this;
		}

		return Armure.values()[this.ordinal() + 1];
	}
	
}