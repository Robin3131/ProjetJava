package equipement;

public enum Arme {
	ARMEB("bois", 1), ARMEO("or", 2), ARMES("saphir", 3), ARMER("rubis", 4), ARMED("diamant", 5);

	private String nom;
	private int degats;

	Arme(String nom, int degats) {
		this.nom = nom;
		this.degats = degats;
	}

	public String getNom() {
		return nom;
	}

	public int getDegats() {
		return degats;
	}

	public Arme getArmeSup() {
		if (this.ordinal() + 1 == Arme.values().length) {
			System.out.println("Impossible d'améliorer l'arme");
			return this;
		}

		return Arme.values()[this.ordinal() + 1];
	}
}