package equipement;

public enum Arme {
	ARMEB("bois", 1, 200), ARMEO("or", 2, 400), ARMES("saphir", 3, 600), ARMER("rubis", 4, 800), ARMED("diamant", 5 , 1000);

	private String nom;
	private int degats;
	private int prix;

	Arme(String nom, int degats, int prix) {
		this.nom = nom;
		this.degats = degats;
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public int getDegats() {
		return degats;
	}
	
	public int getPrix() {
		return prix;
	}

	public Arme getArmeSup() {
		if (this.ordinal() + 1 == Arme.values().length) {
			System.out.println("Impossible d'améliorer l'arme");
			return this;
		}

		return Arme.values()[this.ordinal() + 1];
	}
}