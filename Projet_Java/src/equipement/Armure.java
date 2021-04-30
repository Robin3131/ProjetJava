package equipement;

public enum Armure {
	ARMUREC("cuir", 2), ARMUREF("fer", 4), ARMUREO("or", 6), ARMURER("rubis", 8), ARMURED("diamant", 10), ARMUREP("plastic", 15);

	private String nom;
	private int resistance;

	Armure(String nom, int resistance) {
		this.nom = nom;
		this.resistance = resistance;
	}

	public String getNom() {
		return nom;
	}

	public int getResistance() {
		return resistance;
	}

	public Armure getArmureSup() {
		if (this.ordinal() + 1 == Armure.values().length) {
			System.out.println("Impossible d'améliorer l'armure");
			return this;
		}

		return Armure.values()[this.ordinal() + 1];
	}
}